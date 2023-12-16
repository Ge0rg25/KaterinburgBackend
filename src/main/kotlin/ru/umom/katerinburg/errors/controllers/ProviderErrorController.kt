package ru.umom.katerinburg.errors.controllers

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import ru.umom.katerinburg.errors.common.ProviderNotExistsError
import ru.umom.katerinburg.utils.genereateErrorResponse

@RestControllerAdvice
class ProviderErrorController {



    @ExceptionHandler(ProviderNotExistsError::class)
    fun onNotExists(): ResponseEntity<*> = genereateErrorResponse("Provider not exists", HttpStatus.NOT_FOUND)

}