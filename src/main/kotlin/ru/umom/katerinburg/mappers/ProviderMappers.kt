package ru.umom.katerinburg.mappers

import ru.umom.katerinburg.dto.CreateProviderRq
import ru.umom.katerinburg.dto.ProviderDtoRs
import ru.umom.katerinburg.models.ProviderEntity
import ru.umom.katerinburg.repositories.OrganizationRepository


fun CreateProviderRq.toEntity(organizationRepository: OrganizationRepository): ProviderEntity {
    return ProviderEntity(
        title = title,
        description = description,
        photoId = photoId,
        organization = organizationRepository.findById(organizationId).orElseThrow()
    )
}



fun ProviderEntity.toDto() = ProviderDtoRs(
    id = id,
    title = title,
    description = description,
    photoId = photoId,
    organizationId = organization!!.id
)