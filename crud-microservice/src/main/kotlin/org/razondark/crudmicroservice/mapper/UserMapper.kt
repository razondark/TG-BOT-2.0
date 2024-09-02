package org.razondark.crudmicroservice.mapper

import org.razondark.crudmicroservice.api.dto.UserDTO
import org.razondark.crudmicroservice.model.Users
import org.springframework.stereotype.Component

@Component
class UserMapper {

    fun map(userDTO: UserDTO): Users {
        return Users(
            id = null,
            userId = userDTO.userId,
            username = userDTO.username,
            isAdmin = null
        )
    }
}