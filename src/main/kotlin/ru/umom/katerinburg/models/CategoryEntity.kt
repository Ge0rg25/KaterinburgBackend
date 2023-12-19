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

    @ManyToOne
    @JoinColumn(name = "provider_id")
    val provider: ProviderEntity?,

    ) {

    @Id
    val id: UUID = UUID.randomUUID()



    @ManyToMany
    @JoinTable(
        name = "categories_dishes",
        joinColumns = [JoinColumn(name = "category_id")],
        inverseJoinColumns = [JoinColumn(name = "dish_id")]
    )
    val dishes: MutableList<DishEntity> = mutableListOf()

    constructor() : this(title="", provider=null)
}