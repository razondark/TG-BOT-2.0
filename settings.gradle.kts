plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.5.0"
}
rootProject.name = "tg-bot"

include("tg-bot-back")
include("crud-microservice")
