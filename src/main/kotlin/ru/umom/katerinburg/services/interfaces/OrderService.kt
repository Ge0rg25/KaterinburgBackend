package ru.umom.katerinburg.services.interfaces

import org.springframework.security.oauth2.jwt.Jwt
import ru.umom.katerinburg.dto.CreateOrderRq
import ru.umom.katerinburg.dto.OrderDtoRs
import java.util.UUID

interface OrderService {

    fun create(dto: CreateOrderRq, jwt: Jwt)

    fun complete(id: UUID)

    fun getUserOrders(jwt: Jwt): List<OrderDtoRs>


    fun getAllOrdersByProvider(providerId: UUID): List<OrderDtoRs>



}