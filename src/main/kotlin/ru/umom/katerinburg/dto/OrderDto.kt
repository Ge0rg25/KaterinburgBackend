package ru.umom.katerinburg.dto

import com.fasterxml.jackson.annotation.JsonProperty
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import java.sql.Timestamp

sealed class OrderDto{
    open val id: String? = null
    @JsonProperty("is_delivery")
    open val isDelivery: Boolean? = null
    @JsonProperty("id_completed")
    open val isCompleted: Boolean? = null
    open val user: UserDto? = null
    open val dishes: List<DishDto>? = null
    @JsonProperty("organization_id")
    open val organizationId: String? = null
    @JsonProperty("created_timestamp")
    open val createdTimestamp: Timestamp? = null
}

data class CreateOrderRequest(
    @NotNull
    override val isDelivery: Boolean?,
    @NotEmpty
    override val dishes: List<DishDto>?,
    @NotBlank
    override val organizationId: String?
): OrderDto()


data class CompleteOrderRequest(
    @NotBlank
    override val id: String?
): OrderDto()


data class GetAllOrdersByOrganizationRequest(
    @NotBlank
    override val organizationId: String?
): OrderDto()


data class BaseOrderResponse(
    override val id: String?,
    override val isDelivery: Boolean?,
    override val isCompleted: Boolean?,
    override val dishes: List<DishDto>?,
    override val user: UserDto?,
    override val createdTimestamp: Timestamp?
): OrderDto()