package ru.umom.katerinburg.repositories

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import ru.umom.katerinburg.models.CategoryEntity
import java.util.UUID

@Repository
interface CategoryRepository : JpaRepository<CategoryEntity, UUID>