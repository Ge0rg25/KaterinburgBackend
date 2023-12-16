package ru.umom.katerinburg.errors.controllers

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import ru.umom.katerinburg.errors.common.OrganizationNotExistsError
import ru.umom.katerinburg.utils.genereateErrorResponse

@RestControllerAdvice
class OrganizationErrorController {

    @ExceptionHandler(OrganizationNotExistsError::class)
    fun onNotExists(): ResponseEntity<*> = genereateErrorResponse("Organization not exists", HttpStatus.NOT_FOUND)

}