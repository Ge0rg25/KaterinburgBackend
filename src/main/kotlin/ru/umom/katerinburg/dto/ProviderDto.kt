package ru.umom.katerinburg.dto

import java.util.*


data class CreateProviderRq(
    val title: String,
    val description: String?,
    val photoId: UUID?,
    val organizationId: UUID
)

data class UpdateProviderRq(
    val id: UUID,
    val title: String,
    val description: String?,
    val photoId: UUID?,
    val organizationId: String
)



data class ProviderDtoRs(
    val id: UUID,
    val title: String,
    val description: String?,
    val photoId: UUID?,
    val organizationId: UUID
)

