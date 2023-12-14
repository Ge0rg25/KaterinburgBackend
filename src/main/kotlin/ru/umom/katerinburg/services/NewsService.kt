package ru.umom.katerinburg.services

import lombok.AccessLevel
import lombok.RequiredArgsConstructor
import lombok.experimental.FieldDefaults
import org.springframework.stereotype.Service
import ru.umom.umombackend.models.NewsEntity
import ru.umom.umombackend.repositories.NewsRepository

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
class NewsService {
    var newsRepository: NewsRepository? = null

    fun create(dto: NewsDto.Request.Create) {
        val newsEntity: NewsEntity = NewsEntity.builder()
            .title(dto.title())
            .body(dto.body())
            .photoId(dto.photoId())
            .build()

        newsRepository.save(newsEntity)
    }

    val all: List<Any>
        get() {
            val newsEntities: List<NewsEntity> = newsRepository.findAll()
            val response: MutableList<NewsDto.Response.News> = ArrayList<NewsDto.Response.News>()

            for (news in newsEntities) {
                response.add(News(news.getId(), news.getTitle(), news.getBody(), news.getPhotoId()))
            }
            return response
        }
}
