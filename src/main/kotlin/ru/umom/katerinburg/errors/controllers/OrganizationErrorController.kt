package ru.umom.katerinburg.errors.controllers

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import ru.umom.katerinburg.errors.common.OrganizationNotExsitsError
import ru.umom.katerinburg.utils.ErrorUtils

@RestControllerAdvice
class OrganizationErrorController {
    @ExceptionHandler(value = [OrganizationNotExsitsError::class])
    fun onNotExists(): ResponseEntity<*> {
        return ErrorUtils.genereateErrorResponse("organization not exists!", HttpStatus.BAD_REQUEST)
    }
}
