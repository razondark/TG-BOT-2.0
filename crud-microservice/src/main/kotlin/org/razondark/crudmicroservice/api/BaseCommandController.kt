package org.razondark.crudmicroservice.api

import org.razondark.crudmicroservice.model.BaseCommand
import org.razondark.crudmicroservice.service.BaseCommandService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/command")
class BaseCommandController(
    val baseCommandService: BaseCommandService
) {

    @GetMapping("/all")
    fun getBaseCommands(): List<BaseCommand> = baseCommandService.getBaseCommands()
}