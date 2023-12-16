package ru.umom.katerinburg.services.interfaces

import ru.umom.katerinburg.dto.CategoryDtoRs
import ru.umom.katerinburg.dto.CreateDishRq
import ru.umom.katerinburg.dto.DishDtoRs
import ru.umom.katerinburg.dto.UpdateDishRq
import java.util.*

interface DishService {

    fun create(dto: CreateDishRq)

    fun update(dto: UpdateDishRq)

    fun delete(id: UUID)

    fun getAllByCategoryId(categoryId: UUID): List<DishDtoRs>

    fun getAllByProviderId(providerId: UUID): List<DishDtoRs>

    fun getAllByMenuId(menuId: UUID): List<DishDtoRs>


    fun getDishCategories(id: UUID): List<CategoryDtoRs>
}