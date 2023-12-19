package ru.umom.katerinburg.services.impl

import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import ru.umom.katerinburg.dto.CreateProviderRq
import ru.umom.katerinburg.dto.ProviderDtoRs
import ru.umom.katerinburg.dto.UpdateProviderRq
import ru.umom.katerinburg.errors.common.NotFoundError
import ru.umom.katerinburg.mappers.toDto
import ru.umom.katerinburg.mappers.toEntity
import ru.umom.katerinburg.repositories.OrganizationRepository
import ru.umom.katerinburg.repositories.ProviderRepository
import ru.umom.katerinburg.services.interfaces.ProviderService
import java.util.*

@Service
class ProviderServiceImpl(
    private val providerRepository: ProviderRepository,
    private val organizationRepository: OrganizationRepository
) : ProviderService {

    @Transactional
    override fun create(dto: CreateProviderRq) {
        providerRepository.save(
            dto.toEntity(organizationRepository)
        )
    }

    @Transactional
    override fun update(dto: UpdateProviderRq) {
        providerRepository.findByIdOrNull(dto.id)?.apply {
            title = dto.title
            description = dto.description
            photoId = dto.photoId
        }?: throw NotFoundError("Provider not found")
    }

    override fun delete(id: UUID) {
        providerRepository.findByIdOrNull(id)?.let {
            providerRepository.delete(it)
        } ?: NotFoundError("Provider not found")
    }

    override fun getAllByOrganizationId(organizationId: UUID): List<ProviderDtoRs> =
        providerRepository.findAllByOrganizationId(organizationId).map { it.toDto() }
}