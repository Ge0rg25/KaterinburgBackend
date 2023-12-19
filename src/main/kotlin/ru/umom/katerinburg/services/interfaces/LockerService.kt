package ru.umom.katerinburg.services.interfaces

import ru.umom.katerinburg.dto.RegisterLockerRq
import java.util.*

interface LockerService {

    fun register(dto: RegisterLockerRq)

    fun reserve(floor: Short)

    fun unreserve(lockerNumber: Short)

}