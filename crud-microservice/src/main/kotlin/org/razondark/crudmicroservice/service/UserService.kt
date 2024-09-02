package org.razondark.crudmicroservice.service

import org.razondark.crudmicroservice.api.dto.UserDTO
import org.razondark.crudmicroservice.mapper.UserMapper
import org.razondark.crudmicroservice.model.Users
import org.razondark.crudmicroservice.repository.UsersRepository
import org.springframework.stereotype.Service

@Service
class UserService(
    private val usersRepository: UsersRepository,
    private val userMapper: UserMapper
) {

    fun registerUser(user: UserDTO) {
        usersRepository.save(userMapper.map(user))
    }
}