package org.razondark.tgbot.config

import org.springframework.boot.web.client.RestTemplateBuilder
import org.springframework.context.annotation.Configuration
import org.springframework.web.client.DefaultResponseErrorHandler
import org.springframework.web.client.RestTemplate

@Configuration
class RestTemplateConfig {

    fun restTemplate(): RestTemplate {
        return RestTemplateBuilder()
            //.errorHandler()
            .build()
    }
}