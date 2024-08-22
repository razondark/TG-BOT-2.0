package org.razondark.tgbot.ext

import org.telegram.telegrambots.meta.api.methods.send.SendMessage

fun sendMessageWithText(
    chatId: Long,
    text: String
): SendMessage = SendMessage.builder()
    .chatId(chatId)
    .text(text)
    .build()

fun sendReplyMessageWithText(
    chatId: Long,
    messageId: Int,
    text: String,
): SendMessage = SendMessage.builder()
    .chatId(chatId)
    .text(text)
    .replyToMessageId(messageId)
    .build()