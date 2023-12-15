package ru.umom.katerinburg.repositories

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import ru.umom.katerinburg.models.DishEntity
import java.util.UUID

@Repository
interface DishRepository: JpaRepository<DishEntity, UUID>{
    fun findAllByProviderId(providerId: UUID): List<DishEntity>

    fun findAllByMenusId(menuId: UUID): List<DishEntity>
}