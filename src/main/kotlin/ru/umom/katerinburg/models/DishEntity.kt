package ru.umom.katerinburg.models

import jakarta.persistence.*
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.sql.Timestamp

@Entity
@Table(name = "DISHS")
class DishEntity (
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    val id: String? = null,

    @Column
    val title: String? = null,

    @Column
    val description: String? = null,

    @Column
    val price: Double? = 0.0,

    @Column
    val calories: Double? = 0.0,

    @Column
    val proteins: Double? = 0.0,

    @Column
    val fats: Double? = 0.0,

    @Column
    val carbohydrates: Double? = 0.0,

    @Column
    val photoId: String? = null,

    @CreationTimestamp
    val createdAt: Timestamp? = null,

    @UpdateTimestamp
    val updatedAt: Timestamp? = null,

    @ManyToOne(optional = false)
    @JoinColumn(name = "category_id", nullable = false)
    val category: CategoryEntity? = null
)
