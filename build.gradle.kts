plugins {
    java
    id("org.springframework.boot") version "3.3.4"
    id("io.spring.dependency-management") version "1.1.6"
}

group = "ua.goit"
version = "0.0.1-SNAPSHOT"

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(23)
    }
}

configurations {
    compileOnly {
        extendsFrom(configurations.annotationProcessor.get())
    }
}

repositories {
    mavenCentral()
}

dependencies {

    // Spring Boot dependencies
    implementation("org.springframework.boot:spring-boot-starter-jdbc")
    implementation("org.springframework.boot:spring-boot-starter-data-jdbc")
    implementation("org.springframework.boot:spring-boot-starter-jdbc")
    implementation("org.springframework.boot:spring-boot-starter-thymeleaf")
    implementation("org.springframework.boot:spring-boot-starter-web")


    // Database migrations from Flyway
    implementation("org.flywaydb:flyway-core")

    // Lombok to simplify code writing
    compileOnly("org.projectlombok:lombok")
    annotationProcessor("org.projectlombok:lombok")

    // H2 database for testing
    runtimeOnly("com.h2database:h2")

    // Зависимости для тестирования
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")

    // DataFaker library for random data generation
    implementation("net.datafaker:datafaker:2.3.1")

    // https://mvnrepository.com/artifact/com.maxmind.geoip2/geoip2
    implementation("com.maxmind.geoip2:geoip2:4.2.1")

}

tasks.withType<Test> {
    useJUnitPlatform()
}
