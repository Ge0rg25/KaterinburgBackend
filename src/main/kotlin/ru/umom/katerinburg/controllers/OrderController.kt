package ru.umom.katerinburg.controllers

import org.springframework.http.ResponseEntity
import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.security.oauth2.jwt.Jwt
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*
import ru.umom.katerinburg.dto.CompleteOrderRequest
import ru.umom.katerinburg.dto.CreateOrderRequest
import ru.umom.katerinburg.dto.GetAllOrdersByOrganizationRequest
import ru.umom.katerinburg.services.OrderService

@RestController
@RequestMapping("/order")
class OrderController(private val orderService: OrderService) {

    @PutMapping("/create")
    fun create(
        @AuthenticationPrincipal jwt: Jwt, @RequestBody @Validated dto: CreateOrderRequest
    ): ResponseEntity<*> = orderService.create(jwt, dto)

    @PatchMapping("/complete")
    fun delete(@RequestBody @Validated dto: CompleteOrderRequest): ResponseEntity<*> = orderService.complete(dto)


    @GetMapping("/get/all")
    fun getAll(@AuthenticationPrincipal jwt: Jwt): ResponseEntity<*> = orderService.getAll(jwt)


    @PostMapping("/get/by/organization")
    fun getAllByOrganization(@RequestBody @Validated dto: GetAllOrdersByOrganizationRequest): ResponseEntity<*> =
        orderService.getAllByOrganization(dto)

}
