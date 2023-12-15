package ru.umom.katerinburg.models

import jakarta.persistence.*
import java.util.UUID

@Entity
@Table(name = "Providers")
class ProviderEntity(


    @Column
    var title: String = "",

    @Column
    var description: String? = null,

    @Column
    var photoId: UUID? = null,

    @ManyToOne
    @JoinColumn(name = "organization_id")
    val organization: OrganizationEntity? = null

) {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    val id: UUID = UUID.randomUUID()

    @OneToMany(mappedBy = "provider")
    val dishes: MutableList<DishEntity> = mutableListOf()

    @OneToMany(mappedBy = "provider")
    val menus : MutableList<MenuEntity> = mutableListOf()

    @OneToMany(mappedBy = "provider")
    val categories : MutableList<CategoryEntity> = mutableListOf()

    @OneToMany(mappedBy = "provider")
    val orders : MutableList<OrderEntity> = mutableListOf()
}