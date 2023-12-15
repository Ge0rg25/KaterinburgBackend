package ru.umom.katerinburg.services

import org.springframework.stereotype.Service
import ru.umom.katerinburg.dto.CreateProviderRq
import ru.umom.katerinburg.dto.ProviderDtoRs
import ru.umom.katerinburg.dto.UpdateProviderRq

@Service
interface ProviderRequest {

    fun create(dto: CreateProviderRq)

    fun update(dto: UpdateProviderRq)

    fun delete(id: String)

    fun get(id: String)

    fun getAllByOrganizationId(organizationId: String): List<ProviderDtoRs>

}