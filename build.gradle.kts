plugins {
	id("org.springframework.boot") version "3.3.2" apply false
	id("io.spring.dependency-management") version "1.1.6" apply false
	kotlin("jvm") version "1.9.23" apply false
	kotlin("plugin.spring") version "1.9.23" apply false
	//id("io.gitlab.arturbosch.detekt") version "1.23.6" apply false
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
	//apply(plugin = "io.gitlab.arturbosch.detekt")
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

//	tasks.withType<io.gitlab.arturbosch.detekt.Detekt> {
//		parallel = true
//		autoCorrect = true
//	}

	dependencies {
		//implementation("org.springframework.boot:spring-boot-configuration-processor")
		//runtimeOnly("org.springframework.boot:spring-boot-devtools")
		implementation("org.springframework.boot:spring-boot-starter")
		implementation("org.springframework.boot:spring-boot-starter-web")
		implementation("org.jetbrains.kotlin:kotlin-reflect")
		testImplementation("org.springframework.boot:spring-boot-starter-test")
		testImplementation("org.jetbrains.kotlin:kotlin-test-junit5")
		testRuntimeOnly("org.junit.platform:junit-platform-launcher")
		implementation("io.github.microutils:kotlin-logging-jvm:3.0.5")

		runtimeOnly("io.gitlab.arturbosch.detekt:detekt-formatting:1.23.6")
		implementation("io.gitlab.arturbosch.detekt:detekt-gradle-plugin:1.23.6")
	}

	tasks.withType<Test> {
		useJUnitPlatform()
	}
}