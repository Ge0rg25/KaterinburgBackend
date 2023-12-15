package ru.umom.katerinburg.controllers

import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import ru.umom.katerinburg.dto.CreateMenuRq
import ru.umom.katerinburg.dto.UpdateMenuRq
import ru.umom.katerinburg.services.interfaces.MenuService
import java.util.*


@RestController
@RequestMapping("/menu")
class MenuController(private val menuService: MenuService) {

    @PostMapping
    fun create(@RequestBody @Validated dto: CreateMenuRq) = menuService.create(dto)

    @PutMapping
    fun update(@RequestBody @Validated dto: UpdateMenuRq) = menuService.update(dto)

    @DeleteMapping
    fun delete(@RequestParam id: UUID) = menuService.delete(id)

    @GetMapping
    fun getAllByProviderId(@RequestParam providerId: UUID) = menuService.getAllByProviderId(providerId)

}