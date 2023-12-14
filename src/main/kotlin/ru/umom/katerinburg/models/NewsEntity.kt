package ru.umom.katerinburg.models

import jakarta.persistence.*


@Entity
@Table(name = "news")
class NewsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    var id: String? = null

    @Column
    var title: String? = null


    @Column
    var body: String? = null


    @Column
    var photoId: String? = null
}
