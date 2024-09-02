package org.razondark.tgbot.handler

import org.razondark.tgbot.enums.TgBotCommands
import org.razondark.tgbot.ext.sendMessageWithText
import org.springframework.stereotype.Service
import org.telegram.telegrambots.meta.api.methods.send.SendMessage
import org.telegram.telegrambots.meta.api.objects.Message

@Service
class TgBotCommandHandler : MessageHandler {

    override fun buildCommandQuery(
        message: Message,
    ): SendMessage? =
        when (TgBotCommands.get(message.text)) {
            TgBotCommands.START -> startMessage(message.chatId)
            TgBotCommands.KIRILL -> kirillMessage(message.chatId)
            TgBotCommands.IRINA -> irinaMessage(message.chatId)
            TgBotCommands.NATASHA -> natashaMessage(message.chatId)

            else -> sendMessageWithText(message.chatId, "А?")
        }

    private fun startMessage(chatId: Long): SendMessage =
        sendMessageWithText(chatId, "Hello World!")

    private fun kirillMessage(chatId: Long): SendMessage =
        sendMessageWithText(chatId, "Иди учи жабу")

    private fun irinaMessage(chatId: Long): SendMessage =
        sendMessageWithText(chatId, "Иди работай")

    private fun natashaMessage(chatId: Long): SendMessage =
        sendMessageWithText(chatId, "Пупупу")
}