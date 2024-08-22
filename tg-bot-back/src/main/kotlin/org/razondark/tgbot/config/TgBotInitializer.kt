package org.razondark.tgbot.config

import org.razondark.tgbot.service.TgBotService
import org.springframework.context.annotation.Configuration
import org.springframework.context.event.ContextRefreshedEvent
import org.springframework.context.event.EventListener
import org.telegram.telegrambots.meta.TelegramBotsApi
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession

@Configuration
class TgBotInitializer(
    private val tgBotService: TgBotService
) {
    @EventListener(ContextRefreshedEvent::class)
    fun initialize() = runCatching {
        TelegramBotsApi(DefaultBotSession::class.java)
            .registerBot(tgBotService)
    }.onFailure {
        println("Error start bot: ${it.message}")
    }
}