package ru.umom.katerinburg.dto

import java.util.*


data class CreateCategoryRq(
    val title: String,
    val description: String?,
    val photoId: UUID?,
    val providerId: String
)

data class UpdateCategoryRq(
    val id: UUID,
    val title: String,
    val description: String?,
    val photoId: UUID?,
    val providerId: String
)


data class CategoryDtoRs(
    val id: UUID,
    val title: String,
    val description: String?,
    val photoId: UUID?,
    val providerId: UUID
)



