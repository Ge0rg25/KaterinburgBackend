package ru.umom.katerinburg.services.impl

import org.springframework.data.repository.findByIdOrNull
import org.springframework.security.oauth2.jwt.Jwt
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import ru.umom.katerinburg.dto.CreateOrderRq
import ru.umom.katerinburg.dto.OrderDtoRs
import ru.umom.katerinburg.errors.common.NotFoundError
import ru.umom.katerinburg.mappers.toDto
import ru.umom.katerinburg.mappers.toEntity
import ru.umom.katerinburg.repositories.DishRepository
import ru.umom.katerinburg.repositories.OrderRepository
import ru.umom.katerinburg.services.interfaces.OrderService
import java.util.UUID

@Service
class OrderServiceImpl(
    private val orderRepository: OrderRepository,
    private val dishRepository: DishRepository
): OrderService {

    @Transactional
    override fun create(dto: CreateOrderRq, jwt: Jwt) {
        orderRepository.save(
            dto.toEntity(jwt, dishRepository)
        )
    }

    @Transactional
    override fun complete(id: UUID) {
        orderRepository.findByIdOrNull(id)?.apply {
            isCompleted = true
        } ?: throw NotFoundError("Order not found")

    }

    override fun getUserOrders(jwt: Jwt): List<OrderDtoRs> = orderRepository.findAllByUserId(UUID.fromString(jwt.subject)).map { it.toDto() }

    override fun getAllOrdersByProvider(providerId: UUID): List<OrderDtoRs> = orderRepository.findAllByProviderId(providerId).map { it.toDto() }
}