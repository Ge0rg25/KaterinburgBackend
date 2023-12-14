package ru.umom.katerinburg.controllers

import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*
import ru.umom.katerinburg.dto.*
import ru.umom.katerinburg.services.DishService

@RestController
@RequestMapping("/dishes")
class DishController(private val dishService: DishService) {

    @PutMapping("/create")
    fun create(@RequestBody @Validated dto: CreateDishRequest): ResponseEntity<*> = dishService.create(dto)

    @PatchMapping("/update")
    fun update(@RequestBody @Validated dto: UpdateDishRequest): ResponseEntity<*> = dishService.update(dto)

    @DeleteMapping("/delete")
    fun delete(@RequestBody @Validated dto: DeleteDishRequest): ResponseEntity<*> = dishService.delete(dto)

    @GetMapping("/get/all")
    fun all(): ResponseEntity<*> = dishService.all

    @PostMapping("/get/by/category")
    fun getByCategory(@RequestBody @Validated dto: GetDishByCategoryRequest): ResponseEntity<*> = dishService.getByCategory(dto)

    @PostMapping("/get/by/id")
    fun getDishById(@RequestBody @Validated dto: GetDishById): Dish = dishService.getDishById(dto)

}
