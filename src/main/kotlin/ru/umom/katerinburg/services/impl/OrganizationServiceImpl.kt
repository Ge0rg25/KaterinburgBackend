package ru.umom.katerinburg.services.impl

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import ru.umom.katerinburg.dto.CreateOrganizationRq
import ru.umom.katerinburg.dto.OrganizationDtoRs
import ru.umom.katerinburg.dto.UpdateOrganizationRq
import ru.umom.katerinburg.mappers.toDto
import ru.umom.katerinburg.mappers.toEntity
import ru.umom.katerinburg.models.OrganizationEntity
import ru.umom.katerinburg.repositories.OrganizationRepository
import ru.umom.katerinburg.services.interfaces.OrganizationService
import java.util.*

@Service
class OrganizationServiceImpl(private val organizationRepository: OrganizationRepository) : OrganizationService {

    @Transactional
    override fun create(dto: CreateOrganizationRq) {
        val organization: OrganizationEntity = dto.toEntity()
        organizationRepository.save(organization)
    }

    @Transactional
    override fun update(dto: UpdateOrganizationRq) {
        val organization: OrganizationEntity = organizationRepository.findById(dto.id).orElseThrow()
        organization.title = dto.title
        organization.description = dto.description
        organization.address = dto.address
        organization.photoId = dto.photoId
    }

    @Transactional
    override fun delete(id: UUID) {
        val organization: OrganizationEntity = organizationRepository.findById(id).orElseThrow()
        organizationRepository.delete(organization)
    }


    override fun getAll(): List<OrganizationDtoRs> = organizationRepository.findAll().map { it.toDto() }


}