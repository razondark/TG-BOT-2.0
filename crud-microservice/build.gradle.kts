plugins {
    id("org.springframework.boot")
}

dependencies {
    runtimeOnly("org.postgresql:postgresql")
    implementation("org.liquibase:liquibase-core:4.29.1")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-validation")
}