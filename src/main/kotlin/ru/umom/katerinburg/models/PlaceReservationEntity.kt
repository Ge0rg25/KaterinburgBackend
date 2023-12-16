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
    @GeneratedValue(strategy = GenerationType.UUID)
    val id: UUID = UUID.randomUUID()

    constructor() : this(number = 0)
}