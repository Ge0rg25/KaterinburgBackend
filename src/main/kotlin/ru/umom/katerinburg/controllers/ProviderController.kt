package ru.umom.katerinburg.controllers

import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import ru.umom.katerinburg.dto.CreateProviderRq
import ru.umom.katerinburg.dto.UpdateProviderRq
import ru.umom.katerinburg.services.interfaces.ProviderService
import java.util.UUID

@RestController
@RequestMapping("/providers")
class ProviderController(private val providerService: ProviderService) {

    @RequestMapping
    fun getAll(@RequestParam organizationId: UUID) = providerService.getAllByOrganizationId(organizationId)

    @PostMapping
    fun create(@RequestBody @Validated dto: CreateProviderRq) = providerService.create(dto)

    @PutMapping
    fun update(@RequestBody @Validated dto: UpdateProviderRq) = providerService.update(dto)

    @DeleteMapping
    fun delete(@RequestParam id: UUID) = providerService.delete(id)



}