package ru.umom.katerinburg.errors.controllers

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import ru.umom.katerinburg.errors.common.OrderNotExistsError
import ru.umom.katerinburg.utils.ErrorUtils

@RestControllerAdvice
class OrderErrorController {

    @ExceptionHandler(value = [OrderNotExistsError::class])
    fun onNotExists(): ResponseEntity<*> = ErrorUtils.genereateErrorResponse("order not exists", HttpStatus.NOT_FOUND)

}