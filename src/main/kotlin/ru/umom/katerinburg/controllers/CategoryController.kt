package ru.umom.katerinburg.controllers

import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*
import ru.umom.katerinburg.dto.CreateCategoryRq
import ru.umom.katerinburg.dto.UpdateCategoryRq
import ru.umom.katerinburg.repositories.CategoryRepository
import ru.umom.katerinburg.services.interfaces.CategoryService
import java.util.*

@RestController
@RequestMapping("/categories")
class CategoryController(private val categoryService: CategoryService) {


    @PostMapping
    fun create(@RequestBody @Validated dto: CreateCategoryRq) = categoryService.create(dto)


    @PutMapping
    fun update(@RequestBody @Validated dto: UpdateCategoryRq) = categoryService.update(dto)


    @DeleteMapping
    fun delete(@RequestParam id: UUID) = categoryService.delete(id)


    @GetMapping
    fun getAllByProviderId(@RequestParam providerId: UUID) = categoryService.getAllByProviderId(providerId)


}