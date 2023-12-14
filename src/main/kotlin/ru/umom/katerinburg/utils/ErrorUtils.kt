package ru.umom.katerinburg.utils

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity

object ErrorUtils {
    fun genereateErrorResponse(message: String, status: HttpStatus): ResponseEntity<*> =
        ResponseEntity(mapOf("error" to message), status)

}