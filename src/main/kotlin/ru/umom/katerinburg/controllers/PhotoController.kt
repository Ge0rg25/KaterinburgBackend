package ru.umom.katerinburg.controllers

import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import ru.umom.katerinburg.dto.DownloadPhotoRequest
import ru.umom.katerinburg.dto.UploadPhotoRequest
import ru.umom.katerinburg.services.PhotoService


@RestController
@RequestMapping("/photos")
class PhotoController(private val photoService: PhotoService) {


    @PostMapping(
        value = ["/upload"],
        consumes = [MediaType.MULTIPART_FORM_DATA_VALUE],
        produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun upload(@ModelAttribute dto: UploadPhotoRequest): ResponseEntity<*> = photoService.upload(dto)

    @GetMapping(value = ["/download"])
    fun download(@ModelAttribute dto: DownloadPhotoRequest): ResponseEntity<*> = photoService.download(dto)
}
