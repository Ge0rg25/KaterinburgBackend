package ru.umom.katerinburg.dto




data class CreateProviderRq(
    val title: String,
    val description: String?,
    val photoId: String,
    val organizationId: String
)

data class UpdateProviderRq(
    val id: String,
    val title: String,
    val description: String?,
    val photoId: String,
    val organizationId: String
)



data class ProviderDtoRs(
    val id: String,
    val title: String,
    val description: String?,
    val photoId: String,
    val organizationId: String
)

