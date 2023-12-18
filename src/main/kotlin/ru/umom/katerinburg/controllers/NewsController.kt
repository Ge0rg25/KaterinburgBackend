package ru.umom.katerinburg.controllers

import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import ru.umom.katerinburg.dto.CreateNewsRq
import ru.umom.katerinburg.dto.NewsDtoRs
import ru.umom.katerinburg.services.interfaces.NewsService
import java.util.*

@RestController
@RequestMapping("/news")
class NewsController (private val newsService: NewsService){

    @PostMapping
    fun create(@RequestBody @Validated dto: CreateNewsRq) = newsService.create(dto)

    @GetMapping
    fun getAll(@RequestParam providerId: UUID): List<NewsDtoRs> = newsService.get(providerId)
}