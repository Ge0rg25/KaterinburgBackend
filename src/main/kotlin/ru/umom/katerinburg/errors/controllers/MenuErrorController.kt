package ru.umom.katerinburg.errors.controllers

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import ru.umom.katerinburg.errors.common.MenuNotExistsError
import ru.umom.katerinburg.utils.genereateErrorResponse

@RestControllerAdvice
class MenuErrorController {


    @ExceptionHandler(MenuNotExistsError::class)
    fun onNotExists(): ResponseEntity<*> = genereateErrorResponse("Menu not exists", HttpStatus.NOT_FOUND)

}