package ru.umom.katerinburg.models

import jakarta.persistence.*
import java.util.UUID

@Table(name = "Workstations")
@Entity
class WorkstationEntity(
    @Column
    val userId: UUID? = null,
    @Column
    val placeNumber: Short = 0
) {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    val id: UUID = UUID.randomUUID()

}