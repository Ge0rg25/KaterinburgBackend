package ru.umom.katerinburg.mappers

import ru.umom.katerinburg.dto.CreateMenuRq
import ru.umom.katerinburg.dto.MenuDtoRs
import ru.umom.katerinburg.models.MenuEntity
import ru.umom.katerinburg.repositories.ProviderRepository


fun CreateMenuRq.toEntity(providerRepository: ProviderRepository) = MenuEntity(
    title = title,
    description = description,
    photoId = photoId,
    provider = providerRepository.findById(providerId).orElseThrow()
)


fun MenuEntity.toDto() = MenuDtoRs(
    id = id,
    title = title,
    description = description,
    photoId = photoId,
    providerId = provider!!.id
)