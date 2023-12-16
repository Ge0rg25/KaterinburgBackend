package ru.umom.katerinburg.models

import jakarta.persistence.*
import java.util.*

@Table(name = "Lockers")
@Entity
class LockerEntity(
    val lockerNumber: Short
) {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    val id: UUID = UUID.randomUUID()

    val isLocked: Boolean = false

    constructor(): this(lockerNumber=0)
}