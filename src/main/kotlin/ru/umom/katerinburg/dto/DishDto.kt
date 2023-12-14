package ru.umom.katerinburg.dto

sealed class DishDto {
    open val id: String? = null
    open val title: String? = null
    open val description: String? = null
    open val price: Double? = null
    open val calories: Double? = null
    open val proteins: Double? = null
    open val fats: Double? = null
    open val carbohydrates: Double? = null
    open val categoryId: String? = null
    open val photoId: String? = null
}


data class CreateDishRequest(
    override val title: String?,
    override val description: String?,
    override val price: Double?,
    override val calories: Double?,
    override val proteins: Double?,
    override val fats: Double?,
    override val carbohydrates: Double?,
    override val categoryId: String?,
    override val photoId: String?
) : DishDto()

data class UpdateDishRequest(
    override val id: String?,
    override val title: String?,
    override val description: String?,
    override val price: Double?,
    override val calories: Double?,
    override val proteins: Double?,
    override val fats: Double?,
    override val carbohydrates: Double?,
    override val photoId: String?
) : DishDto()

data class DeleteDishRequest(
    override val id: String?
) : DishDto()

data class GetDishByCategoryRequest(
    override val categoryId: String?
) : DishDto()

data class GetDishByIdRequest(
    override val id: String?
): DishDto()

data class BaseDishResponse(
    override val id: String?,
    override val title: String?,
    override val description: String?,
    override val price: Double?,
    override val calories: Double?,
    override val proteins: Double?,
    override val fats: Double?,
    override val carbohydrates: Double?,
    override val categoryId: String?,
    override val photoId: String?
) : DishDto()


