package ru.umom.katerinburg.services.impl

import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import ru.umom.katerinburg.dto.RegisterLockerRq
import ru.umom.katerinburg.errors.common.NotFoundError
import ru.umom.katerinburg.mappers.toEntity
import ru.umom.katerinburg.repositories.LockerRepository
import ru.umom.katerinburg.repositories.findByFloorOrNull
import ru.umom.katerinburg.repositories.findByLockerNumberOrNull
import ru.umom.katerinburg.services.interfaces.LockerService
import java.util.*

@Service
class LockerServiceImpl(private val lockerRepository: LockerRepository) : LockerService {

    @Transactional
    override fun register(dto: RegisterLockerRq) {
        lockerRepository.save(
            dto.toEntity()
        )
    }

    @Transactional
    override fun reserve(floor: Short) {
        lockerRepository.findByFloorOrNull(floor)?.apply {
            isLocked = true
        } ?: throw NotFoundError("Not locker found on floor $floor")

    }

    override fun unreserve(lockerNumber: Short) {
        lockerRepository.findByLockerNumberOrNull(lockerNumber)?.apply {
            isLocked = false
        }?: throw NotFoundError("Locker not found")
    }

}