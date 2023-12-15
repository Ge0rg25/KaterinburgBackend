package ru.umom.katerinburg.services.impl

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import ru.umom.katerinburg.dto.CreateProviderRq
import ru.umom.katerinburg.dto.ProviderDtoRs
import ru.umom.katerinburg.dto.UpdateProviderRq
import ru.umom.katerinburg.mappers.toDto
import ru.umom.katerinburg.mappers.toEntity
import ru.umom.katerinburg.repositories.OrganizationRepository
import ru.umom.katerinburg.repositories.ProviderRepository
import ru.umom.katerinburg.services.interfaces.ProviderService
import java.util.*

@Service
class IProviderService(
    private val providerRepository: ProviderRepository,
    private val organizationRepository: OrganizationRepository
) : ProviderService {

    @Transactional
    override fun create(dto: CreateProviderRq) {
        val provider = dto.toEntity(organizationRepository)
        providerRepository.save(provider)
    }

    @Transactional
    override fun update(dto: UpdateProviderRq) {
        val provider = providerRepository.findById(dto.id).orElseThrow()
        provider.title = dto.title
        provider.description = dto.description
        provider.photoId = dto.photoId
    }

    override fun delete(id: UUID) {
        val provider = providerRepository.findById(id).orElseThrow()
        providerRepository.delete(provider)
    }

    override fun getAllByOrganizationId(organizationId: UUID): List<ProviderDtoRs> = providerRepository.findAllByOrganizationId(organizationId).map { it.toDto() }
}