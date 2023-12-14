package ru.umom.katerinburg.services

import org.springframework.security.oauth2.jwt.Jwt
import org.springframework.stereotype.Service
import ru.umom.katerinburg.dto.CompleteOrderRequest
import ru.umom.katerinburg.dto.CreateOrderRequest
import ru.umom.katerinburg.dto.UpdateOrderRequest
import ru.umom.katerinburg.errors.common.OrderNotExistsError
import ru.umom.katerinburg.mappers.toBaseResponse
import ru.umom.katerinburg.mappers.toEntity
import ru.umom.katerinburg.models.DishEntity
import ru.umom.katerinburg.models.OrderEntity
import ru.umom.katerinburg.models.UserEntity
import ru.umom.katerinburg.repositories.DishRepository
import ru.umom.katerinburg.repositories.OrderRepository
import ru.umom.katerinburg.repositories.OrganizationRepository
import ru.umom.katerinburg.repositories.UserRepository
import kotlin.jvm.optionals.getOrNull

@Service
class OrderService(
    private val orderRepository: OrderRepository,
    private val userRepository: UserRepository,
    private val dishRepository: DishRepository,
    private val organizationRepository: OrganizationRepository
) {

    fun create(jwt: Jwt, dto: CreateOrderRequest) {
        val user: UserEntity = jwt.subject?.let { userRepository.findById(it).getOrNull() } ?: UserEntity(
            id = jwt.subject,
            name = jwt.getClaim("name"),
        )
        userRepository.save(user)

        val order: OrderEntity = dto.toEntity(user, organizationRepository, dishRepository)

        orderRepository.save(order)
    }

    fun complete(dto: CompleteOrderRequest) {
        val order: OrderEntity = dto.id?.let { orderRepository.findById(it).getOrNull() } ?: throw OrderNotExistsError()
        order.isCompleted = true
        orderRepository.save(order)
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
