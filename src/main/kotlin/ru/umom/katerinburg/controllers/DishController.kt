package ru.umom.katerinburg.controllers

import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import ru.umom.katerinburg.dto.CreateDishRq
import ru.umom.katerinburg.dto.UpdateDishRq
import ru.umom.katerinburg.services.interfaces.DishService
import java.util.*

@RestController
@RequestMapping("/dishes")
class DishController (private val dishService: DishService){

    @PostMapping
    fun create(@RequestBody @Validated dto: CreateDishRq) = dishService.create(dto)

    @PutMapping
    fun update(@RequestBody @Validated dto: UpdateDishRq) = dishService.update(dto)

    @DeleteMapping
    fun delete(@RequestParam id: UUID) = dishService.delete(id)


    @GetMapping
    fun getAllByProviderId(@RequestParam providerId: UUID) = dishService.getAllByProviderId(providerId)

    @GetMapping("/by/menu")
    fun getAllByMenuId(@RequestParam menuId: UUID) = dishService.getAllByMenuId(menuId)

    @GetMapping("/categories")
    fun getDishCategories(@RequestParam id: UUID) = dishService.getDishCategories(id)

}