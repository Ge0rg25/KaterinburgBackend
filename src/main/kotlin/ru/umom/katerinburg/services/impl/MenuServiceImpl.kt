package ru.umom.katerinburg.services.impl

import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import ru.umom.katerinburg.dto.CreateMenuRq
import ru.umom.katerinburg.dto.MenuDtoRs
import ru.umom.katerinburg.dto.UpdateMenuRq
import ru.umom.katerinburg.errors.common.MenuNotExistsError
import ru.umom.katerinburg.mappers.toDto
import ru.umom.katerinburg.mappers.toEntity
import ru.umom.katerinburg.repositories.MenuRepository
import ru.umom.katerinburg.repositories.ProviderRepository
import ru.umom.katerinburg.services.interfaces.MenuService
import java.util.*

@Service
class MenuServiceImpl(private val menuRepository: MenuRepository, private val providerRepository: ProviderRepository) :
    MenuService {

    @Transactional
    override fun create(dto: CreateMenuRq) {
        menuRepository.save(
            dto.toEntity(providerRepository)
        )
    }

    @Transactional
    override fun update(dto: UpdateMenuRq) {
        menuRepository.findByIdOrNull(dto.id)?.apply {
            title = dto.title
            description = dto.description
            photoId = dto.photoId
        } ?: throw MenuNotExistsError()
    }

    @Transactional
    override fun delete(id: UUID) {
        menuRepository.findByIdOrNull(id)?.let {
            menuRepository.delete(it)
        } ?: throw MenuNotExistsError()

    }

    override fun getAllByProviderId(providerId: UUID): List<MenuDtoRs> = menuRepository.findAllByProviderId(providerId).map { it.toDto() }
}