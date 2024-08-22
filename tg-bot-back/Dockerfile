FROM gradle:7.6.4-jdk17-focal AS build

WORKDIR /app

COPY build.gradle.kts build.gradle.kts
COPY settings.gradle.kts settings.gradle.kts

COPY tg-bot-back/src tg-bot-back/src
COPY tg-bot-back/build.gradle.kts tg-bot-back/build.gradle.kts

RUN gradle tg-bot-back:build --no-daemon

FROM openjdk:17-jdk

WORKDIR /app

COPY --from=build /app/tg-bot-back/build/libs/tg-bot-back-0.1.jar /app/tg-bot-back/app.jar

CMD ["java", "-jar", "tg-bot-back/app.jar"]