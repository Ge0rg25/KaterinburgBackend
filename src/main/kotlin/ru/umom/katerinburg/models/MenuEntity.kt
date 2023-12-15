package ru.umom.katerinburg.models

import jakarta.persistence.*
import java.util.UUID

@Entity
@Table(name = "Menus")
class MenuEntity(
    @Column
    val title: String = "",

    @Column
    val description: String? = null,

    @Column
    val photoId: UUID? = null

) {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    val id: UUID = UUID.randomUUID()

    @ManyToOne
    @JoinColumn(name = "provider_id")
    val provider: ProviderEntity? = null

    @ManyToMany
    @JoinTable(
        name = "menus_dishes",
        joinColumns = [JoinColumn(name = "menu_id")],
        inverseJoinColumns = [JoinColumn(name = "dish_id")]
    )
    val dishes: MutableList<DishEntity> = mutableListOf()
}