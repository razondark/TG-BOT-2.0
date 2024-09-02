package org.razondark.crudmicroservice.repository

import org.razondark.crudmicroservice.model.BaseCommand
import org.springframework.data.repository.CrudRepository

interface BaseCommandRepository : CrudRepository<BaseCommand, Long>