package ru.umom.katerinburg.models

import jakarta.persistence.*
import java.util.UUID

@Entity
@Table(name = "Organizations")
class OrganizationEntity(


    @Column
    var title: String,

    @Column
    var description: String? = null,

    @Column
    var address: String,

    var photoId: UUID?

) {
    @Id
    val id: UUID = UUID.randomUUID()

    @OneToMany(mappedBy = "organization")
    val providers: MutableList<ProviderEntity> = mutableListOf()

    constructor() : this(title = "", description = null, address = "", photoId = null)
}