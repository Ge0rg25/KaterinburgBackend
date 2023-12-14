package ru.umom.katerinburg.models

import jakarta.persistence.*
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.sql.Timestamp


@Entity
@Table(name = "USERS")
class UserEntity (
    @Id
    val id: String? = null,

    @Column
    val name: String? = null,


    @Column
    val floor: Short? = 0,

    @Column
    val workstation: Short? = 0,

    @OneToMany(mappedBy = "user", orphanRemoval = true)
    val orders: MutableList<OrderEntity>? = mutableListOf(),


    @CreationTimestamp
    val createdAt: Timestamp? = null,

    @UpdateTimestamp
    val updatedAt: Timestamp? = null,
)
