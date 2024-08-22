package org.razondark.tgbot

import org.razondark.tgbot.props.TgBotProperties
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication

@SpringBootApplication
@EnableConfigurationProperties(TgBotProperties::class)
class TgBotBackApplication

fun main(args: Array<String>) {
    runApplication<TgBotBackApplication>(*args)
}