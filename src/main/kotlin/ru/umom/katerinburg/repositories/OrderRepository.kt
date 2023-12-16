package ru.umom.katerinburg.repositories

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import ru.umom.katerinburg.models.OrderEntity
import java.util.*

@Repository
interface OrderRepository : JpaRepository<OrderEntity, UUID> {

    fun findAllByUserId(userId: UUID): List<OrderEntity>

    fun findAllByProviderId(providerId: UUID): List<OrderEntity>
}