package ru.umom.katerinburg.models

import jakarta.persistence.*
import java.sql.Timestamp
import java.time.LocalTime
import java.util.UUID

@Entity
@Table(name = "Dishes")
class DishEntity(

    @Column
    var title: String = "",

    @Column
    var description: String? = null,

    @Column
    var photoId: UUID? = null,

    @Column
    var calories: Double = 0.0,

    @Column
    var proteins: Double = 0.0,

    @Column
    var fats: Double = 0.0,

    @Column
    var carbohydrates: Double = 0.0,

    @Column
    var price: Double = 0.0,

    @Column
    var cookingTime: LocalTime = LocalTime.of(0, 20),

    @ManyToOne
    @JoinColumn(name = "provider_id")
    val provider: ProviderEntity? = null

) {


    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    val id: UUID = UUID.randomUUID()

    @ManyToMany(mappedBy = "dishes")
    val categories: MutableList<CategoryEntity> = mutableListOf()

    @ManyToMany(mappedBy = "dishes")
    val menus: MutableList<MenuEntity> = mutableListOf()



}