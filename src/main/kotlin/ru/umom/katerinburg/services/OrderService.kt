package ru.umom.katerinburg.services

import org.springframework.security.oauth2.jwt.Jwt
import org.springframework.stereotype.Service
import ru.umom.katerinburg.dto.CreateOrderRq
import ru.umom.katerinburg.dto.OrderDtoRs

@Service
interface OrderService {

    fun create(dto: CreateOrderRq, jwt: Jwt)

    fun complete(id: String)

    fun getUserOrders(jwt: Jwt): List<OrderDtoRs>


    fun getAllOrdersByProvider(providerId: String): List<OrderDtoRs>



}