package ru.umom.katerinburg.errors.controllers

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import ru.umom.katerinburg.errors.common.OrderNotExistsError
import ru.umom.katerinburg.utils.genereateErrorResponse

@RestControllerAdvice
class OrderErrorController {

    @ExceptionHandler(OrderNotExistsError::class)
    fun onNotExists(): ResponseEntity<*> = genereateErrorResponse("Order not exists", HttpStatus.NOT_FOUND)

}