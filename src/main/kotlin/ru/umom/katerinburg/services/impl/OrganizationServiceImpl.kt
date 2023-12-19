package ru.umom.katerinburg.services.impl

import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import ru.umom.katerinburg.dto.CreateOrganizationRq
import ru.umom.katerinburg.dto.OrganizationDtoRs
import ru.umom.katerinburg.dto.UpdateOrganizationRq
import ru.umom.katerinburg.errors.common.NotFoundError
import ru.umom.katerinburg.mappers.toDto
import ru.umom.katerinburg.mappers.toEntity
import ru.umom.katerinburg.repositories.OrganizationRepository
import ru.umom.katerinburg.services.interfaces.OrganizationService
import java.util.*

@Service
class OrganizationServiceImpl(private val organizationRepository: OrganizationRepository) : OrganizationService {

    @Transactional
    override fun create(dto: CreateOrganizationRq) {
        organizationRepository.save(
            dto.toEntity()
        )
    }

    @Transactional
    override fun update(dto: UpdateOrganizationRq) {
        organizationRepository.findByIdOrNull(dto.id)?.apply {
            title = dto.title
            description = dto.description
            address = dto.address
            photoId = dto.photoId
        } ?: throw NotFoundError("Organization not found")

    }

    @Transactional
    override fun delete(id: UUID) {
        organizationRepository.findByIdOrNull(id)?.let {
            organizationRepository.delete(it)
        } ?: throw NotFoundError("Organization not found")
    }


    override fun getAll(): List<OrganizationDtoRs> = organizationRepository.findAll().map { it.toDto() }


}