package ru.umom.katerinburg.services.impl

import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import ru.umom.katerinburg.dto.CreateNewsRq
import ru.umom.katerinburg.dto.NewsDtoRs
import ru.umom.katerinburg.errors.common.ProviderNotExistsError
import ru.umom.katerinburg.mappers.toDto
import ru.umom.katerinburg.mappers.toEntity
import ru.umom.katerinburg.repositories.ProviderRepository
import ru.umom.katerinburg.services.interfaces.NewsService
import java.util.UUID

@Service
class NewsServiceImpl(private val providerRepository: ProviderRepository) : NewsService {

    @Transactional
    override fun create(dto: CreateNewsRq) {
        providerRepository.findByIdOrNull(dto.providerId)?.apply {
            news.add(dto.toEntity())
        } ?: throw ProviderNotExistsError()
    }

    override fun get(providerId: UUID): List<NewsDtoRs> = providerRepository.findByIdOrNull(providerId)?.let {
        it.news.map { news -> news.toDto() }
    } ?: throw ProviderNotExistsError()


}