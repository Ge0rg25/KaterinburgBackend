package ru.umom.katerinburg.controllers

import jakarta.validation.Valid
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import ru.umom.katerinburg.dto.CreateOrganizationRq
import ru.umom.katerinburg.dto.UpdateOrganizationRq
import ru.umom.katerinburg.services.interfaces.OrganizationService
import java.util.*

@RestController
@RequestMapping("/organizations")
class OrganizationController(private val organizationService: OrganizationService) {


    @PostMapping
    fun create(@RequestBody @Validated dto: CreateOrganizationRq) = organizationService.create(dto)

    @PutMapping
    fun update(@RequestBody @Validated dto: UpdateOrganizationRq) = organizationService.update(dto)

    @DeleteMapping
    fun delete(@RequestParam id: UUID) = organizationService.delete(id)

    @GetMapping
    fun getAll(): List<ru.umom.katerinburg.dto.OrganizationDtoRs> = organizationService.getAll()

}