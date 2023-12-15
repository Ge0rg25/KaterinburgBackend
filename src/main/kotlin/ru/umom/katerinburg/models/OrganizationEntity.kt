package ru.umom.katerinburg.models

import jakarta.persistence.*
import java.util.UUID

@Entity
@Table(name = "Organizations")
class OrganizationEntity(


    @Column
    val title: String = "",

    @Column
    val description: String? = null,

    @Column
    val address: String = "",

    val photoId: UUID? = null

) {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    val id: UUID = UUID.randomUUID()

    @OneToMany(mappedBy = "organization")
    val providers: MutableList<ProviderEntity> = mutableListOf()
}