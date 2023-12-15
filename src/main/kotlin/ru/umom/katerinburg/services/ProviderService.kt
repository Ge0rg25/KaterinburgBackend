package ru.umom.katerinburg.services

import org.springframework.stereotype.Service
import ru.umom.katerinburg.dto.CreateProviderRq
import ru.umom.katerinburg.dto.ProviderDtoRs
import ru.umom.katerinburg.dto.UpdateProviderRq
import java.util.*

@Service
interface ProviderService {

    fun create(dto: CreateProviderRq)

    fun update(dto: UpdateProviderRq)

    fun delete(id: UUID)

    fun get(id: UUID): ProviderDtoRs

    fun getAllByOrganizationId(organizationId: UUID): List<ProviderDtoRs>

}