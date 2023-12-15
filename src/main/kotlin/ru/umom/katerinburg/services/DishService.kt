package ru.umom.katerinburg.services

import org.springframework.stereotype.Service
import ru.umom.katerinburg.dto.CreateDishRq
import ru.umom.katerinburg.dto.DishDtoRs
import ru.umom.katerinburg.dto.UpdateDishRq

@Service
interface DishService {

    fun create(dto: CreateDishRq)

    fun update(dto: UpdateDishRq)

    fun delete(id: String)

    fun get(id: String)

    fun getAllByProviderId(providerId: String): List<DishDtoRs>

    fun getAllByMenuId(menuId: String): List<DishDtoRs>


    fun getDishCategories(id: String): List<String>
}