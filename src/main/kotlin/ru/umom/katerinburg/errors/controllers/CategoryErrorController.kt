package ru.umom.katerinburg.errors.controllers

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestController
import ru.umom.katerinburg.errors.common.CategoryNotExistsError
import ru.umom.katerinburg.utils.genereateErrorResponse

@RestController
class CategoryErrorController {



    @ExceptionHandler(CategoryNotExistsError::class)
    fun onNotExists(): ResponseEntity<*> = genereateErrorResponse("Category not exists", HttpStatus.NOT_FOUND)


}