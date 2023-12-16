package ru.umom.katerinburg.models

import jakarta.persistence.*
import java.util.UUID

@Table(name = "Workstations")
@Entity
class WorkstationEntity(
    @Column
    val userId: UUID,
    @Column
    val placeNumber: Short
) {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    val id: UUID = UUID.randomUUID()

    constructor(): this(userId=UUID.randomUUID(), placeNumber=0)
}