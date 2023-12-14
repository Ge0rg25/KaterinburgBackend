package ru.umom.katerinburg.models

import jakarta.persistence.*
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.sql.Timestamp

@Table(name = "ORDERS")
@Entity
class OrderEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    val id: String? = null,

    @Column
    val delivery: Boolean? = false,


    @CreationTimestamp
    val createdAt: Timestamp? = null,

    @UpdateTimestamp
    val updatedAt: Timestamp? = null,

    @Column
    var isCompleted: Boolean? = false,

    @ManyToOne
    @JoinColumn(name = "user_id")
    val user: UserEntity? = null,

    @ManyToMany
    @JoinTable(
        name = "ORDERS_DISHS",
        joinColumns = [JoinColumn(name = "order_id")],
        inverseJoinColumns = [JoinColumn(name = "dish_id")]
    )
    val dishes: List<DishEntity>? = listOf(),

    @ManyToOne
    @JoinColumn(name = "organization_id")
    val organization: OrganizationEntity? = null,
)
