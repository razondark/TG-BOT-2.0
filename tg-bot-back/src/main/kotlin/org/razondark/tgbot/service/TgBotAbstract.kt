package org.razondark.tgbot.service

import org.razondark.tgbot.props.TgBotProperties
import org.telegram.telegrambots.bots.TelegramLongPollingBot
import org.telegram.telegrambots.meta.api.objects.Update

abstract class TgBotAbstract(
    private val tgBotProperties: TgBotProperties
) : TelegramLongPollingBot(tgBotProperties.token) {

    abstract override fun onUpdateReceived(update: Update?)

    override fun getBotUsername(): String = tgBotProperties.name
}