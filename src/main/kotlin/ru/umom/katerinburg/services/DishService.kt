package ru.umom.katerinburg.services

import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import ru.umom.katerinburg.dto.*
import ru.umom.katerinburg.errors.common.CategoryNotExistsError
import ru.umom.katerinburg.errors.common.DishNotExistsError
import ru.umom.katerinburg.mappers.toBaseResponse
import ru.umom.katerinburg.mappers.toEntity
import ru.umom.katerinburg.models.DishEntity
import ru.umom.katerinburg.repositories.CategoryRepository
import ru.umom.katerinburg.repositories.DishRepository
import kotlin.jvm.optionals.getOrNull


@Service
class DishService(val dishRepository: DishRepository, val categoryRepository: CategoryRepository) {


    fun create(dto: CreateDishRequest): ResponseEntity<*> {
        val dish: DishEntity = dto.toEntity(categoryRepository)
        dishRepository.save(dish)
        return ResponseEntity.ok().build<Any>()
    }

    fun update(dto: UpdateDishRequest): ResponseEntity<*> {
        dto.id?.let { dishRepository.findById(it).getOrNull() } ?: throw DishNotExistsError()
        val dish: DishEntity = dto.toEntity(categoryRepository)
        dishRepository.save(dish)
        return ResponseEntity.ok().build<Any>()
    }


    fun delete(dto: DeleteDishRequest): ResponseEntity<*> {
        val dish: DishEntity = dto.id?.let { dishRepository.findById(it).getOrNull() } ?: throw DishNotExistsError()
        dishRepository.delete(dish)
        return ResponseEntity.ok().build<Any>()
    }



    fun getAll(): List<BaseDishResponse> = dishRepository.findAll().map { it.toBaseResponse() }


    fun getByCategory(dto: GetDishByCategoryRequest): List<BaseDishResponse> {
        val category = dto.categoryId?.let { categoryRepository.findById(it).getOrNull() } ?: throw CategoryNotExistsError()
        return category.dishes?.map { it.toBaseResponse() } ?: emptyList()
    }

    // Comment lol
    fun getDishById(dto: GetDishByIdRequest): BaseDishResponse {
        return dto.id?.let { dishRepository.findById(dto.id).getOrNull()?.toBaseResponse() } ?: throw DishNotExistsError()
    }

}
