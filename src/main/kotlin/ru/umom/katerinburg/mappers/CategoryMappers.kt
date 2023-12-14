package ru.umom.katerinburg.mappers

import ru.umom.katerinburg.dto.BaseCategoryResponse
import ru.umom.katerinburg.dto.CategoryDto
import ru.umom.katerinburg.dto.CreateCategoryRequest
import ru.umom.katerinburg.dto.UpdateCategoryRequest
import ru.umom.katerinburg.models.CategoryEntity


fun CategoryEntity.toBaseResponse() = BaseCategoryResponse(
    title = title,
    description = description,
    photoId = photoId,
    organizationId = organization?.id,
    id = id
)


fun CreateCategoryRequest.toEntity() = dtoToEntity(this)

fun UpdateCategoryRequest.toEntity() = dtoToEntity(this)




private fun dtoToEntity(
    dto: CategoryDto
): CategoryEntity = CategoryEntity(
    id = dto.id,
    title = dto.title,
    description = dto.description,
    photoId = dto.photoId
)
