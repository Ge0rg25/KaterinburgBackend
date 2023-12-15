package ru.umom.katerinburg.services

import org.springframework.stereotype.Service
import ru.umom.katerinburg.dto.CategoryDtoRs
import ru.umom.katerinburg.dto.CreateDishRq
import ru.umom.katerinburg.dto.DishDtoRs
import ru.umom.katerinburg.dto.UpdateDishRq
import java.util.UUID

@Service
interface DishService {

    fun create(dto: CreateDishRq)

    fun update(dto: UpdateDishRq)

    fun delete(id: UUID)


    fun getAllByProviderId(providerId: UUID): List<DishDtoRs>

    fun getAllByMenuId(menuId: UUID): List<DishDtoRs>


    fun getDishCategories(id: UUID): List<CategoryDtoRs>
}