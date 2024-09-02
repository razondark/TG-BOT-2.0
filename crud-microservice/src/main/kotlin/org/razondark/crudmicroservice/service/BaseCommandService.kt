package org.razondark.crudmicroservice.service

import org.razondark.crudmicroservice.model.BaseCommand
import org.razondark.crudmicroservice.repository.BaseCommandRepository
import org.springframework.stereotype.Service

@Service
class BaseCommandService(
    val baseCommandRepository: BaseCommandRepository
) {

    fun getBaseCommands(): List<BaseCommand> =
        baseCommandRepository.findAll().toList()
}