package ru.umom.katerinburg.models

import jakarta.persistence.*
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.sql.Timestamp

@Entity
@Table(name = "ORGANIZATIONS")
class OrganizationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    var id: String? = null

    @OneToMany(mappedBy = "organization", orphanRemoval = true)
    var categories: MutableList<CategoryEntity> = mutableListOf()

    @Column
    var title: String? = null

    @Column
    var description: String? = null

    @Column
    var address: String? = null

    @Column
    var photoId: String? = null


    @CreationTimestamp
    var createdAt: Timestamp? = null

    @UpdateTimestamp
    var updatedAt: Timestamp? = null

    @OneToMany(mappedBy = "organization", orphanRemoval = true)
    private val orders: MutableList<OrderEntity> = mutableListOf()
}
