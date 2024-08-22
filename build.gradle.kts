plugins {
	id("org.springframework.boot") version "3.3.2" apply false
	id("io.spring.dependency-management") version "1.1.6" apply false
	kotlin("jvm") version "1.9.23" apply false
	kotlin("plugin.spring") version "1.9.23" apply false
	id("java")
}

allprojects {
	group = "org.razondark"
	version = "0.1"

	repositories {
		mavenCentral()
	}
}

subprojects {
	apply(plugin = "org.springframework.boot")
	apply(plugin = "io.spring.dependency-management")
	apply(plugin = "org.jetbrains.kotlin.jvm")
	apply(plugin = "org.jetbrains.kotlin.plugin.spring")

	java {
		sourceCompatibility = JavaVersion.VERSION_17
		targetCompatibility = JavaVersion.VERSION_17
	}

	tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
		kotlinOptions.jvmTarget = "17"
		kotlinOptions.freeCompilerArgs += "-Xjsr305=strict"
	}

	dependencies {
		//implementation("org.springframework.boot:spring-boot-configuration-processor")
		//runtimeOnly("org.springframework.boot:spring-boot-devtools")
		implementation("org.springframework.boot:spring-boot-starter")
		implementation("org.jetbrains.kotlin:kotlin-reflect")
		testImplementation("org.springframework.boot:spring-boot-starter-test")
		testImplementation("org.jetbrains.kotlin:kotlin-test-junit5")
		testRuntimeOnly("org.junit.platform:junit-platform-launcher")
		implementation("io.github.microutils:kotlin-logging-jvm:3.0.5")
	}

	tasks.withType<Test> {
		useJUnitPlatform()
	}
}