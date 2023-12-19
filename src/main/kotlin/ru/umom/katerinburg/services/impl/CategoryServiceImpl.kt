package ru.umom.katerinburg.services.impl

import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import ru.umom.katerinburg.dto.CategoryDtoRs
import ru.umom.katerinburg.dto.CreateCategoryRq
import ru.umom.katerinburg.dto.UpdateCategoryRq
import ru.umom.katerinburg.errors.common.NotFoundError
import ru.umom.katerinburg.mappers.toDto
import ru.umom.katerinburg.mappers.toEntity
import ru.umom.katerinburg.repositories.CategoryRepository
import ru.umom.katerinburg.repositories.ProviderRepository
import ru.umom.katerinburg.services.interfaces.CategoryService
import java.util.UUID

@Service
class CategoryServiceImpl(
    private val categoryRepository: CategoryRepository,
    private val providerRepository: ProviderRepository
) : CategoryService {

    @Transactional
    override fun create(dto: CreateCategoryRq) {
        categoryRepository.save(
            dto.toEntity(providerRepository)
        )
    }

    @Transactional
    override fun update(dto: UpdateCategoryRq) {
        categoryRepository.findByIdOrNull(dto.id)?.apply {
            title = dto.title
            description = dto.description
            photoId = dto.photoId
        } ?: throw NotFoundError("Category not found")
    }

    @Transactional
    override fun delete(id: UUID) {
        categoryRepository.findByIdOrNull(id)?.let {
            categoryRepository.delete(it)
        } ?: throw NotFoundError("Category not found")
    }


    override fun getAllByProviderId(providerId: UUID): List<CategoryDtoRs> =
        categoryRepository.findAllByProviderId(providerId).toDto()


}