package ru.umom.katerinburg.services.interfaces

import org.springframework.stereotype.Service
import ru.umom.katerinburg.dto.CategoryDtoRs
import ru.umom.katerinburg.dto.CreateCategoryRq
import ru.umom.katerinburg.dto.UpdateCategoryRq
import java.util.*


interface CategoryService {

    fun create(dto: CreateCategoryRq)

    fun update(dto: UpdateCategoryRq)

    fun delete(id: UUID)

    fun getAllByProviderId(providerId: UUID): List<CategoryDtoRs>

}