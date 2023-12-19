package ru.umom.katerinburg.dto

import java.util.UUID


data class RegisterLockerRq(
    val lockerNumber: Short,
    val floor: Short
)


data class LockerDtoRs (
    val id: UUID,
    val lockerNumber: Short,
    val floor: Short,
    val isLocked: Boolean
)
