package ru.umom.katerinburg.mappers

import ru.umom.katerinburg.dto.CategoryDtoRs
import ru.umom.katerinburg.dto.CreateCategoryRq
import ru.umom.katerinburg.models.CategoryEntity
import ru.umom.katerinburg.repositories.ProviderRepository


fun CreateCategoryRq.toEntity(providerRepository: ProviderRepository): CategoryEntity  = CategoryEntity(
    title = title,
    description = description,
    photoId = photoId,
)



fun CategoryEntity.toDto() = CategoryDtoRs(
    id = id,
    title = title,
    description = description,
    photoId = photoId,
    providerId = provider!!.id
)

fun Iterable<CategoryEntity>.toDto() = this.map { it.toDto() }