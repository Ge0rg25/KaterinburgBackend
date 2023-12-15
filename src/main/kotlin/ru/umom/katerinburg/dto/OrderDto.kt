package ru.umom.katerinburg.dto






data class CreateOrderRq(
    val lockerNumber: Short?,
    val workstationNumber: Short?,
    val dishIds: List<String>
)

data class OrderDtoRs(
    val id: String,
    val lockerNumber: Short?,
    val workstationNumber: Short?,
    val isCompleted: Boolean,
    val dishes: List<DishDtoRs>
)