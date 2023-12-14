package ru.umom.katerinburg.dto

import com.fasterxml.jackson.annotation.JsonProperty
import jakarta.validation.constraints.NotBlank

sealed class CategoryDto {
    open val id: String? = null
    @get:NotBlank
    open val title: String? = null
    open val description: String? = null
    @JsonProperty("photo_id")
    @get:NotBlank
    open val photoId: String? = null
    @JsonProperty("organization_id")
    @get:NotBlank
    open val organizationId: String? = null
}

data class CreateCategoryRequest(
    override val title: String?,
    override val description: String?,
    override val photoId: String?,
    override val organizationId: String?
): CategoryDto()

data class UpdateCategoryRequest(
    override val id: String?,
    override val title: String?,
    override val description: String?,
    override val photoId: String?,
): CategoryDto()

data class DeleteCategoryRequest(
    override val id: String?,
): CategoryDto()

data class GetCategoryByOrganizationRequest(
    override val organizationId: String?
): CategoryDto()


data class BaseCategoryResponse (
    override val id: String?,
    override val title: String?,
    override val description: String?,
    override val photoId: String?,
    override val organizationId: String?
): CategoryDto()

