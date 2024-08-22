package org.razondark.tgbot.props

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties(prefix = "tg-bot")
data class TgBotProperties(
    val name: String,
    val token: String
)