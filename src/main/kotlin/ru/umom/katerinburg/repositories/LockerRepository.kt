package ru.umom.katerinburg.repositories

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import ru.umom.katerinburg.models.LockerEntity
import java.util.*

@Repository
interface LockerRepository : JpaRepository<LockerEntity, UUID> {
    fun findByFloor(floor: Short): Optional<LockerEntity>
    fun findByLockerNumber(lockerNumber: Short): Optional<LockerEntity>
}

fun LockerRepository.findByFloorOrNull(floor: Short): LockerEntity? = findByFloor(floor).orElse(null)

fun LockerRepository.findByLockerNumberOrNull(lockerNumber: Short): LockerEntity? =
    findByLockerNumber(lockerNumber).orElse(null)

