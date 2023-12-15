package ru.umom.katerinburg.repositories

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import ru.umom.katerinburg.models.MenuEntity
import java.util.UUID

@Repository
interface OrderRepository : JpaRepository<MenuEntity, UUID>