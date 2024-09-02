package org.razondark.crudmicroservice.repository

import org.razondark.crudmicroservice.model.Users
import org.springframework.data.repository.CrudRepository

interface UsersRepository : CrudRepository<Users, Long>