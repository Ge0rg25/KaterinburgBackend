package ru.umom.katerinburg.dto

import java.util.*


data class CreateNewsRq(
    val title: String,
    val body: String,
    val photoId: UUID?,
    val providerId: UUID
)



data class NewsDtoRs(
    val id: UUID,
    val title: String,
    val body: String?,
    val photoId: UUID?,
)

