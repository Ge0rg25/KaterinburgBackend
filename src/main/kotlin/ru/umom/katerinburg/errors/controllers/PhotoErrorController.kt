package ru.umom.katerinburg.errors.controllers

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import org.springframework.web.context.request.WebRequest
import ru.umom.katerinburg.errors.common.ContentTypeNotAllowedError
import ru.umom.katerinburg.errors.common.PhotoNotExistsError
import ru.umom.katerinburg.utils.ErrorUtils


@RestControllerAdvice
class PhotoErrorController {
    @ExceptionHandler(value = [ContentTypeNotAllowedError::class])
    fun contentTypeNotAllowed(exception: RuntimeException?, webRequest: WebRequest?): ResponseEntity<*> {
        return ErrorUtils.genereateErrorResponse(
            "File extention not allowed. Please, use .jpg or .png",
            HttpStatus.BAD_REQUEST
        )
    }

    @ExceptionHandler(value = [PhotoNotExistsError::class])
    fun photoNotExists(exception: RuntimeException?, webRequest: WebRequest?): ResponseEntity<*> {
        return ErrorUtils.genereateErrorResponse("Photo not exist", HttpStatus.NOT_FOUND)
    }
}
