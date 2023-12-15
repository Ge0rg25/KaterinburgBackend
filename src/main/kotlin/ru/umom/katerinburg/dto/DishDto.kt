package ru.umom.katerinburg.dto

import java.util.*


data class CreateDishRq(
    val title: String,
    val description: String?,
    val cookingTime: Int,
    val price: Double,
    val photoId: UUID?,
    val calories: Double,
    val proteins: Double,
    val fats: Double,
    val carbohydrates: Double,
    val providerId: UUID
)

data class UpdateDishRq(
    val id: UUID,
    val title: String,
    val description: String?,
    val cookingTime: Int,
    val price: Double,
    val photoId: UUID?,
    val calories: Double,
    val proteins: Double,
    val fats: Double,
    val carbohydrates: Double,
    val providerId: UUID
)


data class DishDtoRs(
    val id: UUID,
    val title: String,
    val description: String?,
    val cookingTime: Int,
    val price: Double,
    val photoId: UUID?,
    val calories: Double,
    val proteins: Double,
    val fats: Double,
    val carbohydrates: Double,
    val providerId: UUID
)