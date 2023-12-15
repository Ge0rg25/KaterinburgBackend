package ru.umom.katerinburg.dto




data class CreateMenuRq(
    val title: String,
    val description: String?,
    val photoId: String,
    val providerId: String
)

data class UpdateMenuRq(
    val id: String,
    val title: String,
    val description: String?,
    val photoId: String,
    val providerId: String
)


data class MenuDtoRs(
    val id: String,
    val title: String,
    val description: String?,
    val photoId: String,
    val providerId: String
)

