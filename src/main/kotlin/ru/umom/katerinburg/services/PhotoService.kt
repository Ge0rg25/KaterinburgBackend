package ru.umom.katerinburg.services

import jakarta.transaction.Transactional
import lombok.AccessLevel
import lombok.RequiredArgsConstructor
import lombok.experimental.FieldDefaults
import lombok.extern.slf4j.Slf4j
import org.apache.tika.mime.MimeTypeException
import org.apache.tika.mime.MimeTypes
import org.springframework.core.io.ByteArrayResource
import org.springframework.core.io.Resource
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import ru.umom.umombackend.dto.UploadPhotoRequest
import ru.umom.umombackend.errors.common.ContentTypeNotAllowedError
import ru.umom.umombackend.errors.common.PhotoNotExistsError
import ru.umom.umombackend.models.PhotoEntity
import ru.umom.umombackend.models.PhotoEntity.fileName
import ru.umom.umombackend.models.PhotoEntity.id
import ru.umom.umombackend.repositories.PhotoRepository
import java.io.IOException
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths
import java.util.*

@Service
@Slf4j
class PhotoService(private val photoRepository: PhotoRepository) {
    private val photosDir: Path = Paths.get("photos")

    @Transactional
    @Throws(MimeTypeException::class, IOException::class)
    fun upload(dto: UploadPhotoRequest): ResponseEntity<*> {
        val allowedContentTypes = listOf("image/png", "image/jpeg")
        PhotoService.log.warn(dto.photo().getContentType())
        if (!allowedContentTypes.contains(dto.photo().getContentType())) {
            throw ContentTypeNotAllowedError()
        }
        val fileExtention = MimeTypes.getDefaultMimeTypes().forName(dto.photo().getContentType()).extension
        val photoEntity: PhotoEntity = PhotoEntity.builder()
            .fileName(UUID.randomUUID().toString() + fileExtention)
            .build()
        photoRepository!!.save(photoEntity)
        Files.createDirectories(photosDir)
        Files.copy(dto.photo().getInputStream(), photosDir.resolve(photoEntity.fileName))

        val response: PhotoDto.Response.BaseResponse = BaseResponse(photoEntity.id)

        return ResponseEntity.ok<Any>(response)
    }


    @Throws(IOException::class)
    fun download(dto: PhotoDto.Request.Download): ResponseEntity<*> {
        val photoEntity = photoRepository!!.findById(dto.id()).orElseThrow { PhotoNotExistsError() }

        val file = photosDir.resolve(photoEntity.fileName)
        val resource: Resource = ByteArrayResource(Files.readAllBytes(file))
        return ResponseEntity
            .ok()
            .contentType(MediaType.parseMediaType(Files.probeContentType(file)))
            .contentLength(resource.contentLength()) //                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.toFile().getName() + "\"" ) // Этот хеадер скачивает изображение а не открывает его как веб страницу
            .body(resource)
    }
}