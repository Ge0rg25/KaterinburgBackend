package ru.umom.katerinburg.services

import org.springframework.stereotype.Service
import ru.umom.katerinburg.dto.CreateMenuRq
import ru.umom.katerinburg.dto.MenuDtoRs
import ru.umom.katerinburg.dto.UpdateMenuRq

@Service
interface MenuService {

    fun create(dto: CreateMenuRq)

    fun update(dto: UpdateMenuRq)

    fun delete(id: String)

    fun get(id: String)

    fun getAllByProviderId(providerId: String): List<MenuDtoRs>

}