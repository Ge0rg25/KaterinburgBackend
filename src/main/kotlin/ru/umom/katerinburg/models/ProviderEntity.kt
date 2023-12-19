package ru.umom.katerinburg.models

import jakarta.persistence.*
import java.util.UUID

@Entity
@Table(name = "Providers")
class ProviderEntity(


    @Column
    var title: String,

    @Column
    var description: String?,

    @Column
    var photoId: UUID?,

    @ManyToOne
    @JoinColumn(name = "organization_id")
    val organization: OrganizationEntity?

) {
    @Id
    val id: UUID = UUID.randomUUID()

    @OneToMany(mappedBy = "provider")
    val dishes: MutableList<DishEntity> = mutableListOf()

    @OneToMany(mappedBy = "provider")
    val menus : MutableList<MenuEntity> = mutableListOf()

    @OneToMany(mappedBy = "provider")
    val categories : MutableList<CategoryEntity> = mutableListOf()

    @OneToMany(mappedBy = "provider")
    val orders : MutableList<OrderEntity> = mutableListOf()

    @OneToMany
    @JoinTable(
        name = "providers_news",
        joinColumns = [JoinColumn(name = "provider_id")],
        inverseJoinColumns = [JoinColumn(name = "news_id")]
    )
    val news: MutableList<NewsEntity> = mutableListOf()

    constructor(): this(title="", description=null, photoId=null, organization=null)
}