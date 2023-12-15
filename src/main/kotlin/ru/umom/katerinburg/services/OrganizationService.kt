package ru.umom.katerinburg.services

import org.springframework.stereotype.Service
import ru.umom.katerinburg.dto.CreateOrganizationRq
import ru.umom.katerinburg.dto.OrganizationDtoRs
import ru.umom.katerinburg.dto.UpdateOrganizationRq

@Service
interface OrganizationService {

    fun create(dto: CreateOrganizationRq)

    fun update(dto: UpdateOrganizationRq)

    fun delete(id: String)

    fun getAll(): List<OrganizationDtoRs>



}