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

    // TODO: refactor other methods

    fun getByCategory(dto: GetDishByCategoryRequest): List<BaseDishResponse> {
        val category = dto.categoryId?.let { categoryRepository.findById(it).getOrNull() } ?: throw CategoryNotExistsError()
        val response: List<BaseDishResponse> = category.dishes?.map { it.toBaseResponse() }
        for (dish in dishes!!) {
            response.add(entityToBaseResponse(dish))
        }
        return ResponseEntity.ok<List<DishDto.Response.Dish>>(response)
    }

    // Comment lol
    fun getDishById(dto: DishDto.Request.GetById): DishDto.Response.Dish {
        val dish = dishRepository!!.findById(dto.id()).orElseThrow { DishNotExistsError() }
        return entityToBaseResponse(dish)
    }

    private fun entityToBaseResponse(dish: DishEntity): DishDto.Response.Dish {
        return Dish(
            dish.id,
            dish.title,
            dish.description,
            dish.price,
            dish.calories,
            dish.proteins,
            dish.fats,
            dish.carbohydrates,
            dish.getCategory().getId(),
            dish.photoId
        )
    }
}
