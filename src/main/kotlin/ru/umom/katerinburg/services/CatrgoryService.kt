package ru.umom.katerinburg.services

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import ru.umom.katerinburg.dto.*
import ru.umom.katerinburg.errors.common.CategoryNotExistsError
import ru.umom.katerinburg.errors.common.OrganizationNotExsitsError
import ru.umom.katerinburg.mappers.toBaseResponse
import ru.umom.katerinburg.mappers.toEntity
import ru.umom.katerinburg.models.CategoryEntity
import ru.umom.katerinburg.repositories.CategoryRepository
import ru.umom.katerinburg.repositories.OrganizationRepository
import kotlin.jvm.optionals.getOrNull

@Service
class CatrgoryService(
    private val catrgoryRepository: CategoryRepository,
    private val organizationRepository: OrganizationRepository
) {


    fun create(dto: CreateCategoryRequest): ResponseEntity<*> {
        dto.organizationId?.let { organizationRepository.findById(it).getOrNull() }
            ?: throw OrganizationNotExsitsError()
        val category: CategoryEntity = dto.toEntity()
        catrgoryRepository.save(category)

        return ResponseEntity.ok().build<Any>()
    }

    fun update(dto: UpdateCategoryRequest): ResponseEntity<*> {
        dto.id?.let { catrgoryRepository.findById(it).getOrNull() } ?: throw CategoryNotExistsError()
        val category: CategoryEntity = dto.toEntity()
        catrgoryRepository.save(category)
        return ResponseEntity.ok().build<Any>()
    }

    fun delete(dto: DeleteCategoryRequest): ResponseEntity<*> {
        val category = dto.id?.let { catrgoryRepository.findById(it).getOrNull() } ?: throw CategoryNotExistsError()
        catrgoryRepository.delete(category)
        return ResponseEntity<Any>(HttpStatus.OK)
    }

    fun getByOrganization(dto: GetCategoryByOrganizationRequest): ResponseEntity<*> {
        val organization = dto.organizationId?.let { organizationRepository.findById(it).getOrNull() }
            ?: throw OrganizationNotExsitsError()
        val response: List<BaseCategoryResponse> = organization.categories.map { category -> category.toBaseResponse() }
        return ResponseEntity.ok(response)
    }


    fun all(): List<BaseCategoryResponse> = catrgoryRepository.findAll().map { it.toBaseResponse() }

}
