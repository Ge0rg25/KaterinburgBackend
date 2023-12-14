package ru.umom.katerinburg.models

import jakarta.persistence.*
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.sql.Timestamp

@Table(name = "ORDERS")
@Entity
class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    var id: String? = null

    @Column
    var delivery: Boolean = false


    @CreationTimestamp
    var createdAt: Timestamp? = null

    @UpdateTimestamp
    var updatedAt: Timestamp? = null

    @Column
    var isCompleted: Boolean = false

    @ManyToOne
    @JoinColumn(name = "user_id")
    private val user: UserEntity? = null

    @ManyToMany
    @JoinTable(
        name = "ORDERS_DISHS",
        joinColumns = [JoinColumn(name = "order_id")],
        inverseJoinColumns = [JoinColumn(name = "dish_id")]
    )
    private val dishes: MutableList<DishEntity> = mutableListOf()

    @ManyToOne
    @JoinColumn(name = "organization_id")
    private val organization: OrganizationEntity? = null
}
