package ru.umom.katerinburg.services.impl

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import ru.umom.katerinburg.dto.CategoryDtoRs
import ru.umom.katerinburg.dto.CreateCategoryRq
import ru.umom.katerinburg.dto.UpdateCategoryRq
import ru.umom.katerinburg.mappers.toDto
import ru.umom.katerinburg.mappers.toEntity
import ru.umom.katerinburg.repositories.CategoryRepository
import ru.umom.katerinburg.repositories.ProviderRepository
import ru.umom.katerinburg.services.interfaces.CategoryService
import java.util.UUID

@Service
class ICategoryService(
    private val categoryRepository: CategoryRepository,
    private val providerRepository: ProviderRepository
) : CategoryService {

    @Transactional
    override fun create(dto: CreateCategoryRq) {
       val category = dto.toEntity(providerRepository)
        categoryRepository.save(category)
    }

    @Transactional
    override fun update(dto: UpdateCategoryRq) {
        val category = categoryRepository.findById(dto.id).orElseThrow()
        category.title = dto.title
        category.description = dto.description
        category.photoId = dto.photoId
    }

    @Transactional
    override fun delete(id: UUID) {
        val category = categoryRepository.findById(id).orElseThrow()
        categoryRepository.delete(category)
    }


    override fun getAllByProviderId(providerId: UUID): List<CategoryDtoRs> = categoryRepository.findAllByProviderId(providerId).map { it.toDto() }


}