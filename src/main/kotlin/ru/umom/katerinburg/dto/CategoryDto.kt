package ru.umom.katerinburg.dto




data class CreateCategoryRq(
    val title: String,
    val description: String?,
    val photoId: String,
    val providerId: String
)

data class UpdateCategoryRq(
    val id: String,
    val title: String,
    val description: String?,
    val photoId: String,
    val providerId: String
)


data class CategoryDtoRs(
    val id: String,
    val title: String,
    val description: String?,
    val photoId: String,
    val providerId: String
)



