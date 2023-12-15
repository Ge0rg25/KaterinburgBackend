package ru.umom.katerinburg.models

import jakarta.persistence.*
import java.util.*


@Entity
@Table(name = "Reservations")
class PlaceReservationEntity(
    @Column
    val number: Int = 0
) {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    val id: UUID = UUID.randomUUID()
}