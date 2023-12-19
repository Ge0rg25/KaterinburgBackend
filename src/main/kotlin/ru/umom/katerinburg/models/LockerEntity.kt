package ru.umom.katerinburg.models

import jakarta.persistence.*
import java.util.*

@Table(name = "Lockers")
@Entity
class LockerEntity(
    val lockerNumber: Short,
    val floor: Short,
) {

    @Id
    val id: UUID = UUID.randomUUID()

    var isLocked: Boolean = false

    constructor(): this(lockerNumber=0, floor=0)
}