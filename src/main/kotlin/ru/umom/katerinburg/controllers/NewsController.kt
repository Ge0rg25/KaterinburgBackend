package ru.umom.katerinburg.controllers

import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*
import ru.umom.katerinburg.dto.BaseNewResponse
import ru.umom.katerinburg.dto.CreateNewRequest
import ru.umom.katerinburg.services.NewsService


@RestController
@RequestMapping("/news")
class NewsController(private val newsService: NewsService) {


    @PutMapping("/create")
    fun create(@RequestBody @Validated dto: CreateNewRequest) = newsService.create(dto)


    @GetMapping("/get")
    fun get(): List<BaseNewResponse> = newsService.all

}
