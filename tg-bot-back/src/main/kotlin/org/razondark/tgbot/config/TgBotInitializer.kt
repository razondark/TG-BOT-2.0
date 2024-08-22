package org.razondark.tgbot.config

import mu.KotlinLogging
import org.razondark.tgbot.handler.TgBotGlobalHandler
import org.springframework.context.annotation.Configuration
import org.springframework.context.event.ContextRefreshedEvent
import org.springframework.context.event.EventListener
import org.telegram.telegrambots.meta.TelegramBotsApi
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession

@Configuration
class TgBotInitializer(
    private val tgBotGlobalHandler: TgBotGlobalHandler
) {
    private val log = KotlinLogging.logger {}

    @EventListener(ContextRefreshedEvent::class)
    fun initialize() = runCatching {
        TelegramBotsApi(DefaultBotSession::class.java)
            .registerBot(tgBotGlobalHandler)
    }.onFailure {
        log.error {
            "Error start bot: ${it.message}"
        }
    }
}