package ru.umom.katerinburg.dto

import com.fasterxml.jackson.annotation.JsonProperty

sealed class OrganizationDto {
    open val id: String? = null
    open val title: String? = null
    open val description: String? = null
    open val address: String? = null
    @JsonProperty("photo_id")
    open val photoId: String? = null
}


data class CreateOrganizationRequest(
    override val title: String?,
    override val description: String?,
    override val address: String?,
    override val photoId: String?
): OrganizationDto()


data class UpdateOrganizationRequest(
    override val id: String?,
    override val title: String?,
    override val description: String?,
    override val address: String?,
    override val photoId: String?
): OrganizationDto()

data class DeleteOrganizationRequest(
    override val id: String?

): OrganizationDto()

data class BaseOrganizationResponse(
    override val id: String?,
    override val title: String?,
    override val description: String?,
    override val address: String?,
    override val photoId: String?
): OrganizationDto()


