package ru.umom.katerinburg.models

import jakarta.persistence.*
import java.util.UUID

@Entity
@Table(name = "Menus")
class MenuEntity(
    @Column
    var title: String = "",

    @Column
    var description: String? = null,

    @Column
    var photoId: UUID? = null,

    @ManyToOne
    @JoinColumn(name = "provider_id")
    val provider: ProviderEntity? = null


) {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    val id: UUID = UUID.randomUUID()



    @ManyToMany
    @JoinTable(
        name = "menus_dishes",
        joinColumns = [JoinColumn(name = "menu_id")],
        inverseJoinColumns = [JoinColumn(name = "dish_id")]
    )
    val dishes: MutableList<DishEntity> = mutableListOf()
}