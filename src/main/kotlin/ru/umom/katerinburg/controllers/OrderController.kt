package ru.umom.katerinburg.controllers

import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.security.oauth2.jwt.Jwt
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*
import ru.umom.katerinburg.dto.CreateOrderRq
import ru.umom.katerinburg.services.interfaces.OrderService
import java.util.*


@RequestMapping("/orders")
@RestController
class OrderController(private val orderService: OrderService) {

    @PostMapping
    fun create(@RequestBody @Validated dto: CreateOrderRq, @AuthenticationPrincipal jwt: Jwt) = orderService.create(dto, jwt)


    @PatchMapping
    fun complete(@RequestParam id: UUID) = orderService.complete(id)

    @GetMapping
    fun getUserOrders(@AuthenticationPrincipal jwt: Jwt) = orderService.getUserOrders(jwt)

    @GetMapping("/all")
    fun getAllOrdersByProvider(@RequestParam providerId: UUID) = orderService.getAllOrdersByProvider(providerId)

}