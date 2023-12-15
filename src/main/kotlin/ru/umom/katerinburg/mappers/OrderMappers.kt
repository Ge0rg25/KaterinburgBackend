package ru.umom.katerinburg.mappers

import org.springframework.security.oauth2.jwt.Jwt
import ru.umom.katerinburg.dto.CreateOrderRq
import ru.umom.katerinburg.dto.OrderDtoRs
import ru.umom.katerinburg.models.OrderEntity
import ru.umom.katerinburg.repositories.DishRepository
import java.util.*


fun CreateOrderRq.toEntity(jwt: Jwt, dishRepository: DishRepository) = OrderEntity(
    workstationNumber = workstationNumber,
    lockerNumber = lockerNumber,
    userId = UUID.fromString(jwt.subject),
    dises = dishIds.map { dishRepository.findById(it).orElseThrow() }.toMutableList()
)


fun OrderEntity.toDto() = OrderDtoRs(
    id = id.toString(),
    lockerNumber = lockerNumber,
    workstationNumber = workstationNumber,
    isCompleted = isCompleted,
    dishes = dises.map { it.toDto() }

)


