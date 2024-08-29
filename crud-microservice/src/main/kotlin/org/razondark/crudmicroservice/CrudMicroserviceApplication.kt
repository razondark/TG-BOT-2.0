package org.razondark.crudmicroservice

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
//@EnableConfigurationProperties(TgBotProperties::class)
class CrudMicroserviceApplication

fun main() {
    runApplication<CrudMicroserviceApplication>()
}