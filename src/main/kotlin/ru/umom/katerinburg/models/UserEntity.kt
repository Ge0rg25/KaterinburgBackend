package ru.umom.katerinburg.models

import jakarta.persistence.*
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.sql.Timestamp


@Entity
@Table(name = "USERS")
class UserEntity {
    @Id
    var id: String? = null

    @Column
    var name: String? = null


    @Column
    var floor: Short = 0

    @Column
    var workstation: Short = 0

    @OneToMany(mappedBy = "user", orphanRemoval = true)
    private val orders: MutableList<OrderEntity> = mutableListOf()


    @CreationTimestamp
    var createdAt: Timestamp? = null

    @UpdateTimestamp
    var updatedAt: Timestamp? = null
}
