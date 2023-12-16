package ru.umom.katerinburg.models

import jakarta.persistence.*
import java.util.UUID

@Entity
@Table(name = "Categories")
class CategoryEntity(
    @Column
    var title: String,

    @Column
    var description: String? = null,

    @Column
    var photoId: UUID? = null,


    ) {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    val id: UUID = UUID.randomUUID()

    @ManyToOne
    @JoinColumn(name = "provider_id")
    val provider: ProviderEntity? = null

    @ManyToMany
    @JoinTable(
        name = "categories_dishes",
        joinColumns = [JoinColumn(name = "category_id")],
        inverseJoinColumns = [JoinColumn(name = "dish_id")]
    )
    val dishes: MutableList<DishEntity> = mutableListOf()

    constructor() : this(title="")
}