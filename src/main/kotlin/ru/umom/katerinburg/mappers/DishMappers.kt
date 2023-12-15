package ru.umom.katerinburg.mappers

import ru.umom.katerinburg.dto.CreateDishRq
import ru.umom.katerinburg.dto.DishDtoRs
import ru.umom.katerinburg.models.DishEntity
import ru.umom.katerinburg.repositories.ProviderRepository
import java.time.LocalTime

fun CreateDishRq.toEntity(providerRepository: ProviderRepository): DishEntity = DishEntity(
    title = title,
    description = description,
    photoId = photoId,
    cookingTime = LocalTime.of(0, cookingTime),
    price = price,
    calories = calories,
    proteins = proteins,
    fats = fats,
    carbohydrates = carbohydrates,
    provider = providerRepository.getReferenceById(providerId)
)



fun DishEntity.toDto() = DishDtoRs(
    id = id,
    title = title,
    description = description,
    photoId = photoId,
    cookingTime = cookingTime.minute,
    price = price,
    calories = calories,
    proteins = proteins,
    fats = fats,
    carbohydrates = carbohydrates,
    providerId = provider!!.id
)