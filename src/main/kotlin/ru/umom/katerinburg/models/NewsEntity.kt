package ru.umom.katerinburg.models

import jakarta.persistence.*
import java.util.UUID


@Entity
@Table(name = "News")
class NewsEntity(

    @Column
    val title: String = "",

    @Column
    val body: String? = null,

    @Column
    val photoId: UUID? = null

) {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    val id: UUID = UUID.randomUUID()
}