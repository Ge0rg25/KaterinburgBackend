package ru.umom.katerinburg.models

import jakarta.persistence.*
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.sql.Timestamp

@Entity
@Table(name = "photos")
class PhotoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    var id: String? = null

    @Column(name = "file_name")
    var fileName: String? = null


    @CreationTimestamp
    var createdAt: Timestamp? = null

    @UpdateTimestamp
    var updatedAt: Timestamp? = null
}