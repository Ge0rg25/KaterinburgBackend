package ru.umom.katerinburg.services.interfaces

import ru.umom.katerinburg.dto.CreateNewsRq
import ru.umom.katerinburg.dto.NewsDtoRs

interface NewsService {


    fun create(dto: CreateNewsRq)


    fun getAll(): List<NewsDtoRs>

}