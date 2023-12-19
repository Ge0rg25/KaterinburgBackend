package ru.umom.katerinburg.services.interfaces

import ru.umom.katerinburg.dto.LockerDtoRs
import ru.umom.katerinburg.dto.RegisterLockerRq
import java.util.*

interface LockerService {

    fun register(dto: RegisterLockerRq)

    fun reserve(floor: Short): LockerDtoRs

    fun unreserve(lockerNumber: Short)

}