package ru.umom.katerinburg.dto

import java.util.UUID


data class CreateOrderRq(
    val lockerNumber: Short?,
    val workstationNumber: Short?,
    val dishIds: List<UUID>
)

data class OrderDtoRs(
    val id: String,
    val lockerNumber: Short?,
    val workstationNumber: Short?,
    val isCompleted: Boolean,
    val dishes: List<DishDtoRs>
)