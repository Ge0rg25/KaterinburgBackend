package ru.umom.katerinburg.services

import org.springframework.transaction.annotation.Transactional
import ru.umom.katerinburg.dto.CreateMenuRq
import ru.umom.katerinburg.dto.MenuDtoRs
import ru.umom.katerinburg.dto.UpdateMenuRq
import ru.umom.katerinburg.mappers.toDto
import ru.umom.katerinburg.mappers.toEntity
import ru.umom.katerinburg.repositories.MenuRepository
import ru.umom.katerinburg.repositories.ProviderRepository
import java.util.*

class IMenuService(private val menuRepository: MenuRepository, private val providerRepository: ProviderRepository) : MenuService {

    @Transactional
    override fun create(dto: CreateMenuRq) {
        val menu = dto.toEntity(providerRepository)
        menuRepository.save(menu)
    }

    @Transactional
    override fun update(dto: UpdateMenuRq) {
        val menu = menuRepository.findById(dto.id).orElseThrow()
        menu.title = dto.title
        menu.description = dto.description
        menu.photoId = dto.photoId
    }

    @Transactional
    override fun delete(id: UUID) {
        val menu = menuRepository.findById(id).orElseThrow()
        menuRepository.delete(menu)
    }

    override fun getAllByProviderId(providerId: UUID): List<MenuDtoRs> = menuRepository.findAllByProviderId(providerId).map { it.toDto() }
}