package org.razondark.tgbot.handler

import mu.KotlinLogging
import org.razondark.tgbot.props.TgBotProperties
import org.springframework.stereotype.Service
import org.telegram.telegrambots.bots.TelegramLongPollingBot
import org.telegram.telegrambots.meta.api.objects.Message
import org.telegram.telegrambots.meta.api.objects.Update

@Service
class TgBotGlobalHandler(
    private val tgBotProperties: TgBotProperties,
    private val tgBotCommandsHandler: TgBotCommandHandler,
    private val tgBotTextMessageHandler: TgBotTextMessageHandler
) : TelegramLongPollingBot(tgBotProperties.token) {

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
            """
                Error answer: ${message.text};
                chatId: ${message.chatId}: ${it.message};
                sender: {
                    id: ${message.from.id}
                    nickname: ${message.from.userName}
                }
                stackTrace: ${it.stackTrace}
            """.trimIndent()
        }
    }

    override fun getBotUsername(): String = tgBotProperties.name
}