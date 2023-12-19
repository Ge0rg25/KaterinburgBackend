package ru.umom.katerinburg.models

import jakarta.persistence.*
import java.util.*


@Entity
@Table(name = "Reservations")
class PlaceReservationEntity(
    @Column
    val number: Int,
) {
    @Id
    val id: UUID = UUID.randomUUID()

    constructor() : this(number = 0)
}