package ru.umom.katerinburg.services

import org.springframework.stereotype.Service
import ru.umom.katerinburg.dto.CreateMenuRq
import ru.umom.katerinburg.dto.MenuDtoRs
import ru.umom.katerinburg.dto.UpdateMenuRq
import java.util.UUID

@Service
interface MenuService {

    fun create(dto: CreateMenuRq)

    fun update(dto: UpdateMenuRq)

    fun delete(id: UUID)

    fun getAllByProviderId(providerId: UUID): List<MenuDtoRs>

}