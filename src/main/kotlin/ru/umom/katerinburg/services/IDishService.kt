package ru.umom.katerinburg.services

import org.springframework.transaction.annotation.Transactional
import ru.umom.katerinburg.dto.CategoryDtoRs
import ru.umom.katerinburg.dto.CreateDishRq
import ru.umom.katerinburg.dto.DishDtoRs
import ru.umom.katerinburg.dto.UpdateDishRq
import ru.umom.katerinburg.mappers.toDto
import ru.umom.katerinburg.mappers.toEntity
import ru.umom.katerinburg.repositories.DishRepository
import ru.umom.katerinburg.repositories.ProviderRepository
import java.time.LocalTime
import java.util.UUID


class IDishService(private val dishRepository: DishRepository, private val providerRepository: ProviderRepository) :
    DishService {

    @Transactional
    override fun create(dto: CreateDishRq) {
        val dish = dto.toEntity(providerRepository)
        dishRepository.save(dish)
    }


    @Transactional
    override fun update(dto: UpdateDishRq) {
        val dish = dishRepository.findById(dto.id).orElseThrow()
        dish.title = dto.title
        dish.description = dto.description
        dish.photoId = dto.photoId
        dish.price = dto.price
        dish.calories = dto.calories
        dish.proteins = dto.proteins
        dish.fats = dto.fats
        dish.carbohydrates = dto.carbohydrates
        dish.cookingTime = LocalTime.of(0, dto.cookingTime)

    }

    override fun delete(id: UUID) {
        val dish = dishRepository.findById(id).orElseThrow()
        dishRepository.delete(dish)
    }


    override fun getAllByProviderId(providerId: UUID): List<DishDtoRs> = dishRepository
        .findAllByProviderId(providerId)
        .map { it.toDto() }

    override fun getAllByMenuId(menuId: UUID): List<DishDtoRs> = dishRepository
        .findAllByMenusId(menuId)
        .map { it.toDto() }

    override fun getDishCategories(id: UUID): List<CategoryDtoRs> = dishRepository.findById(id).orElseThrow().categories.map { it.toDto() }
}