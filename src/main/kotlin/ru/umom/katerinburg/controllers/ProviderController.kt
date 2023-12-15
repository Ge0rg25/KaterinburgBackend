package ru.umom.katerinburg.controllers

import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*
import ru.umom.katerinburg.dto.CreateProviderRq
import ru.umom.katerinburg.dto.UpdateProviderRq
import ru.umom.katerinburg.services.interfaces.ProviderService
import java.util.UUID

@RestController
@RequestMapping("/providers")
class ProviderController(private val providerService: ProviderService) {

    @GetMapping
    fun getAll(@RequestParam organizationId: UUID) = providerService.getAllByOrganizationId(organizationId)

    @PostMapping
    fun create(@RequestBody @Validated dto: CreateProviderRq) = providerService.create(dto)

    @PutMapping
    fun update(@RequestBody @Validated dto: UpdateProviderRq) = providerService.update(dto)

    @DeleteMapping
    fun delete(@RequestParam id: UUID) = providerService.delete(id)



}