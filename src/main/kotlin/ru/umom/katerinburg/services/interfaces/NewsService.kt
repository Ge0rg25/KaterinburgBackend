package ru.umom.katerinburg.services.interfaces

import ru.umom.katerinburg.dto.CreateNewsRq
import ru.umom.katerinburg.dto.NewsDtoRs
import java.util.UUID

interface NewsService {


    fun create(dto: CreateNewsRq)


    fun get(providerId: UUID): List<NewsDtoRs>

}