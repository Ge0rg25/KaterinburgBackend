package ru.umom.katerinburg.services.impl

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import ru.umom.katerinburg.dto.CreateNewsRq
import ru.umom.katerinburg.dto.NewsDtoRs
import ru.umom.katerinburg.mappers.toDto
import ru.umom.katerinburg.mappers.toEntity
import ru.umom.katerinburg.repositories.NewsRepository
import ru.umom.katerinburg.repositories.ProviderRepository
import ru.umom.katerinburg.services.interfaces.NewsService

@Service
class NewsServiceImpl (private val newsRepository: NewsRepository, private val providerRepository: ProviderRepository): NewsService{

    @Transactional
    override fun create(dto: CreateNewsRq) {
        val news = dto.toEntity(providerRepository)
        newsRepository.save(news)
    }

    override fun getAll(): List<NewsDtoRs> = newsRepository.findAll().map { it.toDto() }


}