package ru.umom.katerinburg.repositories

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import ru.umom.katerinburg.models.LockerEntity
import java.util.*

@Repository
interface LockerRepository : JpaRepository<LockerEntity, UUID>