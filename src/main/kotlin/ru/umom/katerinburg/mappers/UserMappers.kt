package ru.umom.katerinburg.mappers

import ru.umom.katerinburg.dto.*
import ru.umom.katerinburg.models.NewsEntity
import ru.umom.katerinburg.models.UserEntity

fun UserEntity.toBaseResponse() = BaseUserResponse(
    id = id,
    name = name,
    floor = floor,
    workstation = workstation,
)



fun UpdateUserRequest.toEntity() = dtoToEntity(this)




private fun dtoToEntity(
    dto: UserDto
): UserEntity = UserEntity(
    id = dto.id,
    name = dto.name,
    floor = dto.floor,
    workstation = dto.workstation
)
