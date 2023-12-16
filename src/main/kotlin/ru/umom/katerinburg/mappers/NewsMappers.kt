package ru.umom.katerinburg.mappers

import ru.umom.katerinburg.dto.CreateNewsRq
import ru.umom.katerinburg.dto.NewsDtoRs
import ru.umom.katerinburg.models.NewsEntity


fun CreateNewsRq.toEntity() = NewsEntity(
    title = title,
    body = body,
    photoId = photoId,
)


fun NewsEntity.toDto() = NewsDtoRs(
    id = id,
    title = title,
    body = body,
    photoId = photoId,
)



