package org.razondark.tgbot.handler

import org.telegram.telegrambots.meta.api.methods.send.SendMessage
import org.telegram.telegrambots.meta.api.objects.Message

interface MessageHandler {
    fun buildCommandQuery(message: Message): SendMessage?
}