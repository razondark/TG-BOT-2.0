package org.razondark.crudmicroservice.api

import org.razondark.crudmicroservice.api.dto.UserDTO
import org.razondark.crudmicroservice.service.UserService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/users")
class UserController(
    private val userService: UserService
) {

    @PostMapping("/create")
    fun registerUser(userDTO: UserDTO) {
        userService.registerUser(userDTO)
    }
}