package ru.umom.katerinburg.services.impl

import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import ru.umom.katerinburg.dto.CategoryDtoRs
import ru.umom.katerinburg.dto.CreateDishRq
import ru.umom.katerinburg.dto.DishDtoRs
import ru.umom.katerinburg.dto.UpdateDishRq
import ru.umom.katerinburg.errors.common.NotFoundError
import ru.umom.katerinburg.mappers.toDto
import ru.umom.katerinburg.mappers.toEntity
import ru.umom.katerinburg.repositories.DishRepository
import ru.umom.katerinburg.repositories.ProviderRepository
import ru.umom.katerinburg.services.interfaces.DishService
import java.time.LocalTime
import java.util.UUID

@Service
class DishServiceImpl(private val dishRepository: DishRepository, private val providerRepository: ProviderRepository) :
    DishService {

    @Transactional
    override fun create(dto: CreateDishRq) {
        dishRepository.save(
            dto.toEntity(providerRepository)
        )
    }


    @Transactional
    override fun update(dto: UpdateDishRq) {
        dishRepository.findByIdOrNull(dto.id)?.apply {
            title = dto.title
            description = dto.description
            photoId = dto.photoId
            price = dto.price
            calories = dto.calories
            proteins = dto.proteins
            fats = dto.fats
            carbohydrates = dto.carbohydrates
            cookingTime = LocalTime.of(0, dto.cookingTime)
        }?: throw NotFoundError("Dish not found")
    }

    override fun delete(id: UUID) {
        dishRepository.findByIdOrNull(id)?.let {
            dishRepository.delete(it)
        } ?: throw NotFoundError("Dish not found")
    }

    override fun getAllByCategoryId(categoryId: UUID): List<DishDtoRs> = dishRepository
        .findAllByCategoriesId(categoryId)
        .map { it.toDto() }


    override fun getAllByProviderId(providerId: UUID): List<DishDtoRs> = dishRepository
        .findAllByProviderId(providerId)
        .map { it.toDto() }

    override fun getAllByMenuId(menuId: UUID): List<DishDtoRs> = dishRepository
        .findAllByMenusId(menuId)
        .map { it.toDto() }

    override fun getDishCategories(id: UUID): List<CategoryDtoRs> = dishRepository.findByIdOrNull(id)?.categories?.map { it.toDto() } ?: emptyList()
}