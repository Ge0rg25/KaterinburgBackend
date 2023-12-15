package ru.umom.katerinburg.dto

import java.util.*


data class CreateOrganizationRq(
    val title: String,
    val description: String?,
    val photoId: UUID?,
    val address: String
)

data class UpdateOrganizationRq(
    val id: UUID,
    val title: String,
    val description: String?,
    val photoId: UUID,
    val address: String
)


data class OrganizationDtoRs(
    val id: UUID,
    val title: String,
    val description: String?,
    val photoId: UUID?,
    val address: String
)




