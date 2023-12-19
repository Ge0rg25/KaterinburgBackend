package ru.umom.katerinburg.models

import jakarta.persistence.*
import java.time.LocalTime
import java.util.*

@Entity
@Table(name = "Dishes")
class DishEntity(

    @Column
    var title: String,

    @Column
    var description: String? = null,

    @Column
    var photoId: UUID? = null,

    @Column
    var calories: Double,

    @Column
    var proteins: Double,

    @Column
    var fats: Double,

    @Column
    var carbohydrates: Double,

    @Column
    var price: Double,

    @Column
    var cookingTime: LocalTime = LocalTime.of(0, 20),

    @ManyToOne
    @JoinColumn(name = "provider_id")
    val provider: ProviderEntity? = null

) {


    @Id
    val id: UUID = UUID.randomUUID()

    @ManyToMany(mappedBy = "dishes")
    val categories: MutableList<CategoryEntity> = mutableListOf()

    @ManyToMany(mappedBy = "dishes")
    val menus: MutableList<MenuEntity> = mutableListOf()

    constructor(): this(title="", calories = 0.0, proteins = 0.0, fats = 0.0, carbohydrates = 0.0, price = 0.0)

}