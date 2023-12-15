package ru.umom.katerinburg.dto

import java.util.UUID


data class CreateMenuRq(
    val title: String,
    val description: String?,
    val photoId: UUID,
    val providerId: UUID
)

data class UpdateMenuRq(
    val id: UUID,
    val title: String,
    val description: String?,
    val photoId: UUID?,
    val providerId: UUID
)


data class MenuDtoRs(
    val id: UUID,
    val title: String,
    val description: String?,
    val photoId: UUID?,
    val providerId: UUID
)

