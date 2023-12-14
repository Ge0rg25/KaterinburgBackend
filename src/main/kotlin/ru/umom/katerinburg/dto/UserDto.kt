package ru.umom.katerinburg.dto

sealed class UserDto {
    open val id: String? = null
    open val name: String? = null
    open val floor: Short? = null
    open val workstation: Short? = null
}



data class UpdateUserRequest(
    override val name: String?,
    override val floor: Short?,
    override val workstation: Short?
): UserDto()


data class GetUserRequest(
    override val id: String?
): UserDto()



data class BaseUserResponse(
    override val id: String?,
    override val name: String?,
    override val floor: Short?,
    override val workstation: Short?
): UserDto()