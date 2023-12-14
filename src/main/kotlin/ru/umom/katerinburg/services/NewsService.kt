package ru.umom.katerinburg.services


import org.springframework.stereotype.Service
import ru.umom.katerinburg.dto.BaseNewResponse
import ru.umom.katerinburg.dto.CreateNewRequest
import ru.umom.katerinburg.mappers.toBaseResponse
import ru.umom.katerinburg.mappers.toEntity
import ru.umom.katerinburg.repositories.NewsRepository


@Service
class NewsService(private val newsRepository: NewsRepository) {


    fun create(dto: CreateNewRequest) {
        newsRepository.save(dto.toEntity())
    }


    fun getAll() : List<BaseNewResponse> = newsRepository.findAll().map { it.toBaseResponse() }
}
