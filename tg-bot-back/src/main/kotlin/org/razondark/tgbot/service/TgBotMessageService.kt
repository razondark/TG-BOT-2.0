package org.razondark.tgbot.service

import mu.KotlinLogging
import org.razondark.tgbot.handler.MessageHandler
import org.razondark.tgbot.handler.TgBotCommandHandler
import org.razondark.tgbot.handler.TgBotTextMessageHandler
import org.razondark.tgbot.props.TgBotProperties
import org.springframework.stereotype.Service
import org.telegram.telegrambots.meta.api.objects.Message
import org.telegram.telegrambots.meta.api.objects.Update

@Service
class TgBotMessageService(
    tgBotProperties: TgBotProperties,
    private val tgBotCommandsHandler: TgBotCommandHandler,
    private val tgBotTextMessageHandler: TgBotTextMessageHandler
) : TgBotAbstract(tgBotProperties) {

    private val log = KotlinLogging.logger {}

    override fun onUpdateReceived(update: Update?) {
        update?.apply {
            if (!hasMessage() || !message.hasText()) return

            if (message.isCommand) {
                answer(tgBotCommandsHandler, message)
            } else {
                answer(tgBotTextMessageHandler, message)
            }
        }
    }

    private fun answer(handler: MessageHandler, message: Message) = runCatching {
        executeAsync(handler.buildCommandQuery(message))
    }.onFailure {
        log.error {
            "Error while executing command ${message.text}, chatId: ${message.chatId}: ${it.message}"
        }
    }
}