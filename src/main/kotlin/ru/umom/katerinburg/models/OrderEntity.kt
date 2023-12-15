package ru.umom.katerinburg.models

import jakarta.persistence.*
import java.util.UUID

@Entity
@Table(name = "Orders")
class OrderEntity(

    @Column
    val workstationNumber: Short? = null,

    @Column
    val lockerNumber: Short? = null,

) {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    val id: UUID = UUID.randomUUID()

    val isCompleted: Boolean = false

    @ManyToMany
    @JoinTable(
        name = "orders_dishes",
        joinColumns = [JoinColumn(name = "order_id")],
        inverseJoinColumns = [JoinColumn(name = "dish_id")]
    )
    val dises: MutableList<DishEntity> = mutableListOf()

}