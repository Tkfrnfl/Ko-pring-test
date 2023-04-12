import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("org.springframework.boot") version "3.0.2"
	id("io.spring.dependency-management") version "1.1.0"
	kotlin("jvm") version "1.7.22"
	kotlin("plugin.spring") version "1.7.22"

	kotlin("plugin.jpa")version "1.7.22"
	// allOpen에서 지정한 어노테이션으로 만든 클래스에 open 키워드 적용
	kotlin("plugin.allopen") version "1.7.22"

	// 인자 없는 기본 생성자를 자동 생성
	// - Hibernate가 사용하는 Reflection API에서 Entity를 만들기 위해 인자 없는 기본 생성자가 필요함
	kotlin("plugin.noarg") version "1.7.22"
}

allOpen {
	annotation("javax.persistence.Entity")
}
noArg {
	annotation("javax.persistence.Entity")
}

group = "com.example"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_17

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	// https://mvnrepository.com/artifact/org.postgresql/postgresql
	implementation("org.postgresql:postgresql:42.5.0")
	// https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-log4j2
	//implementation("org.springframework.boot:spring-boot-starter-log4j2:3.0.2")
	implementation("org.springframework.boot:spring-boot-starter-data-jpa:3.0.4")

	//graphql
	//implementation("com.graphql-java-kickstart:graphql-spring-boot-starter:15.0.0")
	implementation("org.springframework.boot:spring-boot-starter-graphql")
	//implementation("com.expediagroup:graphql-kotlin-spring-server:7.0.0-alpha.4")

	testImplementation("io.mockk:mockk:1.13.4")

	testImplementation("io.kotest:kotest-runner-junit5:5.5.5")
	testImplementation("io.kotest:kotest-assertions-core:5.5.5")
	testImplementation("com.ninja-squad:springmockk:3.0.1")
	testImplementation("org.springframework.graphql:spring-graphql-test")

}



tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs = listOf("-Xjsr305=strict")
		jvmTarget = "17"
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}
