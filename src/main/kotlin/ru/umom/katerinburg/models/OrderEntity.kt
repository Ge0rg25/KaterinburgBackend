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


    @Column
    val userId: UUID? = null,

    @ManyToMany
    @JoinTable(
        name = "orders_dishes",
        joinColumns = [JoinColumn(name = "order_id")],
        inverseJoinColumns = [JoinColumn(name = "dish_id")]
    )
    val dises: MutableList<DishEntity> = mutableListOf(),


    @ManyToOne
@JoinColumn(name = "provider_id")
val provider: ProviderEntity? = null
) {

    @Id
    val id: UUID = UUID.randomUUID()

    var isCompleted: Boolean = false



}