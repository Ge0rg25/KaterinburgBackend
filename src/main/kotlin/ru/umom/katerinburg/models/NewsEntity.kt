package ru.umom.katerinburg.models

import jakarta.persistence.*
import java.util.UUID


@Entity
@Table(name = "News")
class NewsEntity(

    @Column
    val title: String,

    @Column
    val body: String,

    @Column
    val photoId: UUID? = null,


) {
    @Id
    val id: UUID = UUID.randomUUID()

    constructor(): this(title="", body="")
}