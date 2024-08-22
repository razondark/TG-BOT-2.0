package org.razondark.tgbot.enums

enum class TgBotCommands(val command: String) {

    START("/start"),
    KIRILL("/kirill"),
    IRINA("/irina"),
    NATASHA("/natasha");

    companion object {
        fun get(command: String): TgBotCommands? {
            return entries.find { it.command == command }
        }
    }
}