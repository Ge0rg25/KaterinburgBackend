package ru.umom.katerinburg.dto






data class CreateDishRq(
    val title: String,
    val description: String?,
    val cookingTime: Int,
    val price: Double,
    val photoId: String,
    val calories: Double,
    val proteins: Double,
    val fats: Double,
    val carbohydrates: Double,
)

data class UpdateDishRq(
    val id: String,
    val title: String,
    val description: String?,
    val cookingTime: Int,
    val price: Double,
    val photoId: String,
    val calories: Double,
    val proteins: Double,
    val fats: Double,
    val carbohydrates: Double,
)


data class DishDtoRs(
    val id: String,
    val title: String,
    val description: String?,
    val cookingTime: Int,
    val price: Double,
    val photoId: String,
    val calories: Double,
    val proteins: Double,
    val fats: Double,
    val carbohydrates: Double
)