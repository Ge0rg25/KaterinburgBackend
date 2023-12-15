package ru.umom.katerinburg.services.interfaces

import org.springframework.stereotype.Service
import ru.umom.katerinburg.dto.CreateOrganizationRq
import ru.umom.katerinburg.dto.OrganizationDtoRs
import ru.umom.katerinburg.dto.UpdateOrganizationRq
import java.util.*

interface OrganizationService {

    fun create(dto: CreateOrganizationRq)

    fun update(dto: UpdateOrganizationRq)

    fun delete(id: UUID)

    fun getAll(): List<OrganizationDtoRs>



}