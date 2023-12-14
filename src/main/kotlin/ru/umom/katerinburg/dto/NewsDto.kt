package ru.umom.katerinburg.dto

import com.fasterxml.jackson.annotation.JsonProperty

sealed class NewsDto {
    open val id: String? = null
    open val title: String? = null
    open val body: String? = null
    @JsonProperty("photo_id")
    open val photoId: String? = null
}


data class CreateNewRequest(
    override val title: String?,
    override val body: String?,
    override val photoId: String?
): NewsDto()

data class UpdateNewRequest(
    override val id: String?,
    override val title: String?,
    override val body: String?,
    override val photoId: String?
): NewsDto()


data class BaseNewResponse(
    override val id: String?,
    override val title: String?,
    override val body: String?,
    override val photoId: String?
): NewsDto()