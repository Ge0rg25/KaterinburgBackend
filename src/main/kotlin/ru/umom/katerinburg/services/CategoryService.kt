package ru.umom.katerinburg.services

import org.springframework.stereotype.Service
import ru.umom.katerinburg.dto.CategoryDtoRs
import ru.umom.katerinburg.dto.CreateCategoryRq
import ru.umom.katerinburg.dto.UpdateCategoryRq

@Service
interface CategoryService {

    fun create(dto: CreateCategoryRq)

    fun update(dto: UpdateCategoryRq)

    fun delete(id: String)

    fun get(id: String)

    fun getAllByProviderId(providerId: String): List<CategoryDtoRs>

}