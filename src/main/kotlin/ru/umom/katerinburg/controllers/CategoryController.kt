package ru.umom.katerinburg.controllers

import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*
import ru.umom.katerinburg.dto.*
import ru.umom.katerinburg.services.CatrgoryService

@RestController
@RequestMapping("/categories")
class CategoryController(private var catrgoryService: CatrgoryService) {


    @PutMapping("/create")
    fun create(@RequestBody @Validated dto: CreateCategoryRequest): ResponseEntity<*> =
        catrgoryService.create(dto)

    @PatchMapping("/update")
    fun update(@RequestBody @Validated dto: UpdateCategoryRequest): ResponseEntity<*> =
        catrgoryService.update(dto)

    @DeleteMapping("/delete")
    fun delete(@RequestBody @Validated dto: DeleteCategoryRequest): ResponseEntity<*> {
        return catrgoryService.delete(dto)
    }


    @PostMapping("/get/by/organization")
    fun getByOrganization(@RequestBody @Validated dto: GetCategoryByOrganizationRequest): ResponseEntity<*> =
        catrgoryService.getByOrganization(dto)

    @GetMapping("/get/all")
    fun getAll(): List<BaseCategoryResponse> = catrgoryService.all()

}
