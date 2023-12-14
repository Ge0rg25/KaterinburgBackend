package ru.umom.katerinburg.services

import jakarta.transaction.Transactional
import lombok.AccessLevel
import org.springframework.security.oauth2.jwt.Jwt
import org.springframework.stereotype.Service

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
class UserService {
    var userRepository: UserRepository? = null

    @Transactional
    fun update(dto: UserDto.Request.Update, jwt: Jwt): ResponseEntity<*> {
        val user: UserEntity = userRepository.findById(jwt.subject).orElse(
            UserEntity.builder()
                .id(jwt.subject)
                .name(jwt.getClaim("name"))
                .build()
        )

        user.setName(dto.name())
        user.setFloor(dto.floor())
        user.setWorkstation(dto.workstation())
        userRepository.save(user)
        return ResponseEntity.ok().build<Any>()
    }


    fun getUserInfo(jwt: Jwt): ResponseEntity<*> {
        val user: UserEntity = userRepository.findById(jwt.subject).orElse(
            UserEntity.builder()
                .id(jwt.subject)
                .name(jwt.getClaim("name"))
                .build()
        )
        val response: UserDto.Response.User = User(user.getId(), user.getName(), user.getFloor(), user.getWorkstation())
        return ResponseEntity.ok<Any>(response)
    }
}
