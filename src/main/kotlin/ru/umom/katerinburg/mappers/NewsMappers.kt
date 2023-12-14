package ru.umom.katerinburg.mappers

import ru.umom.katerinburg.dto.*
import ru.umom.katerinburg.models.NewsEntity


fun NewsEntity.toBaseResponse() = BaseNewResponse(
    id = id,
    title = title,
    body = body,
    photoId = photoId,
)


fun CreateNewRequest.toEntity() = dtoToEntity(this)

fun UpdateNewRequest.toEntity() = dtoToEntity(this)




private fun dtoToEntity(
    dto: NewsDto
): NewsEntity = NewsEntity(
    id = dto.id,
    title = dto.title,
    body = dto.body,
    photoId = dto.photoId
)
