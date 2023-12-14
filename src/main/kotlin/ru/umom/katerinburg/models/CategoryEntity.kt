package ru.umom.katerinburg.models

import jakarta.persistence.*
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.sql.Timestamp

@Entity
@Table(name = "CATEGORIES")
class CategoryEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    val id: String? = null,


    val title: String? = null,

    val description: String? = null,

    val photoId: String? = null,


    @CreationTimestamp
    val createdAt: Timestamp? = null,

    @UpdateTimestamp
    val updatedAt: Timestamp? = null,

    @OneToMany(mappedBy = "category", orphanRemoval = true)
    val dishes: MutableList<DishEntity>? = mutableListOf(),

    @ManyToOne(optional = false)
    @JoinColumn(name = "organization_id", nullable = false)
    val organization: OrganizationEntity? = null
)
