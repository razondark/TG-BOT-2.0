package org.razondark.tgbot.service

import org.springframework.web.client.RestTemplate

class TgBotCommandService(
    private val restTemplate: RestTemplate,
) {

    fun registerUser(userId: Long, username: String) {
        restTemplate
    }
}