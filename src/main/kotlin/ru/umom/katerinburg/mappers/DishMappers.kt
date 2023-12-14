package ru.umom.katerinburg.mappers

import ru.umom.katerinburg.dto.*
import ru.umom.katerinburg.errors.common.CategoryNotExistsError
import ru.umom.katerinburg.models.DishEntity
import ru.umom.katerinburg.repositories.CategoryRepository
import kotlin.jvm.optionals.getOrNull

fun DishEntity.toBaseResponse() = BaseDishResponse(
    id = id,
    title = title,
    description = description,
    price = price,
    calories = calories,
    proteins = proteins,
    fats = fats,
    carbohydrates = carbohydrates,
    categoryId = category?.id,
    photoId = photoId,
)


fun CreateDishRequest.toEntity(categoryRepository: CategoryRepository) = dtoToEntity(this, categoryRepository)

fun UpdateDishRequest.toEntity(categoryRepository: CategoryRepository) = dtoToEntity(this, categoryRepository)


private fun dtoToEntity(
    dto: DishDto,
    categoryRepository: CategoryRepository
): DishEntity = DishEntity(
    id = dto.id,
    title = dto.title,
    description = dto.description,
    price = dto.price,
    calories = dto.calories,
    proteins = dto.proteins,
    fats = dto.fats,
    carbohydrates = dto.carbohydrates,
    photoId = dto.photoId,
    category = dto.categoryId?.let { categoryRepository.findById(it).getOrNull() } ?: throw CategoryNotExistsError()
)
