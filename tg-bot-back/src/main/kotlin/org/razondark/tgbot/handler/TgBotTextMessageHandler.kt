package org.razondark.tgbot.handler

import org.razondark.tgbot.ext.sendReplyMessageWithText
import org.springframework.stereotype.Service
import org.telegram.telegrambots.meta.api.methods.send.SendMessage
import org.telegram.telegrambots.meta.api.objects.Message

@Service
class TgBotTextMessageHandler : MessageHandler {
    override fun buildCommandQuery(message: Message): SendMessage? =
        baseMessage(message.chatId, message.messageId, message.text)

    private fun baseMessage(chatId: Long, replyId: Int, text: String) =
        when (text) {
            "А?", "А", "а?", "а", "A?", "A", "a?", "a" -> "Ага"
            "Ага", "ага", "Aga", "aga" -> "А?"
            "F", "f" -> "F"

            else -> null
        }?.let { answer ->
            sendReplyMessageWithText(chatId, replyId, answer)
        }
}