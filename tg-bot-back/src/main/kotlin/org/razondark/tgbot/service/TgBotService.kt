package org.razondark.tgbot.service

import org.razondark.tgbot.config.TgBotInitializer
import org.razondark.tgbot.props.TgBotProperties
import org.springframework.stereotype.Service
import org.telegram.telegrambots.bots.TelegramLongPollingBot
import org.telegram.telegrambots.meta.api.methods.send.SendMessage
import org.telegram.telegrambots.meta.api.objects.Update

@Service
class TgBotService(
    private val tgBotProperties: TgBotProperties
) : TelegramLongPollingBot(tgBotProperties.token) {
    override fun onUpdateReceived(update: Update?) {
        val message = update?.message

        val sendMessage = SendMessage(update!!.message.chatId.toString(), "hello, " + message!!.text)
        execute(sendMessage)
    }

    override fun getBotUsername(): String =
        tgBotProperties.name
}