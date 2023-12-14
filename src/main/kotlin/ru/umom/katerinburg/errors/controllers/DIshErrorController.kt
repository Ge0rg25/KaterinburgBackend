package ru.umom.katerinburg.errors.controllers

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import ru.umom.katerinburg.errors.common.DishNotExistsError
import ru.umom.katerinburg.utils.ErrorUtils


@RestControllerAdvice
class DIshErrorController {
    @ExceptionHandler(value = [DishNotExistsError::class])
    fun onNotExists(): ResponseEntity<*> {
        return ErrorUtils.genereateErrorResponse("dish not exists!", HttpStatus.BAD_REQUEST)
    }
}
