package ru.umom.katerinburg.services.interfaces

import ru.umom.katerinburg.dto.CreateMenuRq
import ru.umom.katerinburg.dto.MenuDtoRs
import ru.umom.katerinburg.dto.UpdateMenuRq
import java.util.*

interface MenuService {

    fun create(dto: CreateMenuRq)

    fun update(dto: UpdateMenuRq)

    fun delete(id: UUID)

    fun getAllByProviderId(providerId: UUID): List<MenuDtoRs>

}