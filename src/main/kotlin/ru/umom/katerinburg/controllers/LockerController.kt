package ru.umom.katerinburg.controllers

import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import ru.umom.katerinburg.dto.RegisterLockerRq
import ru.umom.katerinburg.services.interfaces.LockerService

@RestController
@RequestMapping("/lockers")
class LockerController(private val lockerService: LockerService) {


    @PostMapping
    fun register(@RequestBody @Validated dto: RegisterLockerRq) = lockerService.register(dto)

    @PatchMapping("/{floor}/reserve")
    fun reserve(@PathVariable floor: Short) = lockerService.reserve(floor)

    @PutMapping("/{lockerNumber}/unreserve")
    fun unreserve(@PathVariable lockerNumber: Short) = lockerService.unreserve(lockerNumber)


}