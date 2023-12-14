package ru.umom.katerinburg.controllers


import org.springframework.http.ResponseEntity
import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.security.oauth2.jwt.Jwt
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*
import ru.umom.katerinburg.dto.UpdateUserRequest

@RestController
@RequestMapping("/user")
class UserController(private val userService: UserService) {

    @GetMapping("/info")
    fun getInfo(@AuthenticationPrincipal jwt: Jwt): ResponseEntity<*> = userService.getUserInfo(jwt)

    @PatchMapping("/update")
    fun update(
        @AuthenticationPrincipal jwt: Jwt, @RequestBody @Validated dto: UpdateUserRequest
    ): ResponseEntity<*> = userService.update(dto, jwt)
}
