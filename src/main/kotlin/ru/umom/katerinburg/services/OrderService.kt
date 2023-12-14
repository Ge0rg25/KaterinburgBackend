package ru.umom.katerinburg.services

import lombok.AccessLevel
import org.springframework.security.oauth2.jwt.Jwt
import org.springframework.stereotype.Service

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
class OrderService {
    var orderRepository: OrderRepository? = null
    var userRepository: UserRepository? = null
    var dishRepository: DishRepository? = null
    var organizationRepository: OrganizationRepository? = null

    fun create(jwt: Jwt, dto: CreateOrderRequest): ResponseEntity<*> {
        val user: UserEntity = userRepository.findById(jwt.subject)
            .orElse(UserEntity.builder().id(jwt.subject).name(jwt.getClaim("name")).build())
        userRepository.save(user)
        val dishes: List<DishEntity> = dishRepository.findAllById(dto.dishesId())

        val organization: OrganizationEntity =
            organizationRepository.findById(dto.organizationId()).orElseThrow { OrganizationNotExsitsError() }

        val order: OrderEntity =
            OrderEntity.builder().delivery(dto.delivery()).user(user).dishes(dishes).organization(organization).build()

        orderRepository.save(order)
        return ResponseEntity.ok().build<Any>()
    }

    fun complete(dto: OrderDto.Request.Complete): ResponseEntity<*> {
        val order: OrderEntity = orderRepository.findById(dto.id()).orElseThrow()
        order.setCompleted(true)
        return ResponseEntity.ok().build<Any>()
    }

    fun getAllByOrganization(dto: OrderDto.Request.GetAllByOrganization): ResponseEntity<*> {
        val orders: List<OrderEntity> =
            organizationRepository.findById(dto.organizationId()).orElseThrow { OrganizationNotExsitsError() }
                .getOrders()
        val response: MutableList<OrderDto.Response.BaseResponse> = ArrayList<OrderDto.Response.BaseResponse>()

        for (order in orders) {
            val dishes: MutableList<DishDto.Response.Dish> = ArrayList<DishDto.Response.Dish>()
            for (dish in order.getDishes()) {
                dishes.add(
                    Dish(
                        dish.getId(),
                        dish.getTitle(),
                        dish.getDescription(),
                        dish.getPrice(),
                        dish.getCalories(),
                        dish.getProteins(),
                        dish.getFats(),
                        dish.getCarbohydrates(),
                        dish.getCategory().getId(),
                        dish.getPhotoId()
                    )
                )
            }

            val user: UserDto.Response.User = User(
                order.getUser().getId(),
                order.getUser().getName(),
                order.getUser().getFloor(),
                order.getUser().getWorkstation()
            )
            response.add(
                BaseResponse(
                    order.getId(),
                    order.isDelivery(),
                    dishes,
                    user,
                    order.getCreatedAt(),
                    order.isCompleted()
                )
            )
        }

        return ResponseEntity.ok<List<OrderDto.Response.BaseResponse>>(response)
    }

    fun getAll(jwt: Jwt): ResponseEntity<*> {
        val user: UserEntity = userRepository.findById(jwt.subject).orElse(
            UserEntity.builder().id(jwt.subject).name(jwt.getClaim("name")).orders(
                ArrayList<E>()
            ).build()
        )
        val orders: List<OrderEntity> = user.getOrders()
        val userDto: UserDto.Response.User = User(user.getId(), user.getName(), user.getFloor(), user.getWorkstation())
        val response: MutableList<OrderDto.Response.BaseResponse> = ArrayList<OrderDto.Response.BaseResponse>()
        for (order in orders) {
            val dishes: MutableList<DishDto.Response.Dish> = ArrayList<DishDto.Response.Dish>()
            for (dish in order.getDishes()) {
                dishes.add(
                    Dish(
                        dish.getId(),
                        dish.getTitle(),
                        dish.getDescription(),
                        dish.getPrice(),
                        dish.getCalories(),
                        dish.getProteins(),
                        dish.getFats(),
                        dish.getCarbohydrates(),
                        dish.getCategory().getId(),
                        dish.getPhotoId()
                    )
                )
            }
            response.add(
                BaseResponse(
                    order.getId(),
                    order.isDelivery(),
                    dishes,
                    userDto,
                    order.getCreatedAt(),
                    order.isCompleted()
                )
            )
        }
        return ResponseEntity.ok<List<OrderDto.Response.BaseResponse>>(response)
    }
}
