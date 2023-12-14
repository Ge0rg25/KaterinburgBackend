package ru.umom.katerinburg.controllers

import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*
import ru.umom.katerinburg.dto.CreateOrganizationRequest
import ru.umom.katerinburg.dto.DeleteOrganizationRequest
import ru.umom.katerinburg.dto.UpdateOrganizationRequest
import ru.umom.katerinburg.services.OrganizationService


@RestController
@RequestMapping("/organizations")
class OrganizationController(private val organizationService: OrganizationService) {

    @PutMapping("/create")
    fun create(@RequestBody @Validated dto: CreateOrganizationRequest): ResponseEntity<*> =
        organizationService.create(dto)


    @PatchMapping("/update")
    fun update(@RequestBody @Validated dto: UpdateOrganizationRequest): ResponseEntity<*> =
        organizationService.update(dto)


    @DeleteMapping("/delete")
    fun delete(@RequestBody @Validated dto: DeleteOrganizationRequest): ResponseEntity<*> =
        organizationService.delete(dto)

    @GetMapping("/get/all")
    fun getAll(): ResponseEntity<*> = organizationService.all
}
