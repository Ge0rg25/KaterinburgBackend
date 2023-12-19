package ru.umom.katerinburg.mappers

import ru.umom.katerinburg.dto.LockerDtoRs
import ru.umom.katerinburg.dto.RegisterLockerRq
import ru.umom.katerinburg.models.LockerEntity

fun RegisterLockerRq.toEntity() = LockerEntity(
    lockerNumber = lockerNumber,
    floor = floor
)

fun LockerEntity.toDto() = LockerDtoRs(
    id = id,
    lockerNumber = lockerNumber,
    floor = floor,
    isLocked = isLocked
)