package ru.umom.katerinburg.dto

import com.fasterxml.jackson.annotation.JsonProperty
import org.springframework.web.multipart.MultipartFile

sealed class PhotoDto {
    open val id: String? = null
    @JsonProperty("file_name")
    open val fileName: String? = null
    open val photo: MultipartFile? = null
}



data class UploadPhotoRequest(
    override val photo: MultipartFile?
): PhotoDto()


data class DownloadPhotoRequest(
    override val id: String?
): PhotoDto()


data class BasePhotoResponse(
    override val id: String?
): PhotoDto()