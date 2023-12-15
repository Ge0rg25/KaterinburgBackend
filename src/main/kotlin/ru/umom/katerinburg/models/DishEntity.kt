package ru.umom.katerinburg.models

import jakarta.persistence.*
import java.sql.Timestamp
import java.time.LocalTime
import java.util.UUID

@Entity
@Table(name = "Dishes")
class DishEntity(

    val title: String = "",
    val description: String? = null,
    val photoId: UUID? = null,
    val calories: Double = 0.0,
    val proteins: Double = 0.0,
    val fats: Double = 0.0,
    val carbohydrates: Double = 0.0,
    val price: Double = 0.0,
    val cookingTime: LocalTime = LocalTime.of(0, 20),

) {


    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    val id: UUID = UUID.randomUUID()

    @ManyToMany(mappedBy = "dishes")
    val categories: MutableList<CategoryEntity> = mutableListOf()

    @ManyToMany(mappedBy = "dishes")
    val menus: MutableList<MenuEntity> = mutableListOf()

    @ManyToOne
    @JoinColumn(name = "provider_id")
    val provider: ProviderEntity? = null

}