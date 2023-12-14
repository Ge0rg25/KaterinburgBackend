package ru.umom.katerinburg.mappers

import ru.umom.katerinburg.dto.*
import ru.umom.katerinburg.errors.common.OrganizationNotExsitsError
import ru.umom.katerinburg.models.OrderEntity
import ru.umom.katerinburg.models.UserEntity
import ru.umom.katerinburg.repositories.DishRepository
import ru.umom.katerinburg.repositories.OrganizationRepository
import ru.umom.katerinburg.repositories.UserRepository
import kotlin.jvm.optionals.getOrNull


fun OrderEntity.toBaseResponse() = BaseOrderResponse(
    id = id,
    isDelivery = delivery,
    isCompleted = isCompleted,
    dishes = dishes?.map { it.toBaseResponse() },
    user = user?.toBaseResponse(),
    createdTimestamp = createdAt,
)


fun CreateOrderRequest.toEntity(
    user: UserEntity,
    organizationRepository: OrganizationRepository,
    dishRepository: DishRepository
) = dtoToEntity(this,user, organizationRepository, dishRepository)


private fun dtoToEntity(
    dto: OrderDto,
    user: UserEntity,
    organizationRepository: OrganizationRepository,
    dishRepository: DishRepository
): OrderEntity = OrderEntity(
    id = dto.id,
    delivery = dto.isDelivery,
    organization = dto.organizationId?.let { organizationRepository.findById(it).getOrNull() }
        ?: throw OrganizationNotExsitsError(),
    isCompleted = dto.isCompleted,
    dishes = dto.dishes?.map { it.id }?.let { dishRepository.findAllById(it) },
    user = user
)
