package ru.umom.katerinburg.services.interfaces

import ru.umom.katerinburg.dto.CreateProviderRq
import ru.umom.katerinburg.dto.ProviderDtoRs
import ru.umom.katerinburg.dto.UpdateProviderRq
import java.util.*

interface ProviderService {

    fun create(dto: CreateProviderRq)

    fun update(dto: UpdateProviderRq)

    fun delete(id: UUID)



    fun getAllByOrganizationId(organizationId: UUID): List<ProviderDtoRs>

}