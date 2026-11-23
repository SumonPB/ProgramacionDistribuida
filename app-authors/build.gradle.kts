plugins {
    id("java")
    id("io.quarkus") version "3.40.1.1"
    id("io.freefair.lombok") version "9.8.3"
}

group = "org.programacion.distribuida"
version = "unspecified"

repositories {
    mavenCentral()
}

val quarkusVersion = "3.40.1.1"
java {
    sourceCompatibility = JavaVersion.VERSION_25
    targetCompatibility = JavaVersion.VERSION_25
}

dependencies {
    implementation(enforcedPlatform("io.quarkus.platform:quarkus-bom:${quarkusVersion}"))
    //cdi
    implementation("io.quarkus:quarkus-arc")
    //jpa
    implementation("io.quarkus:quarkus-hibernate-orm")
    implementation("io.quarkus:quarkus-hibernate-orm-panache")
    implementation("io.quarkus:quarkus-jdbc-postgresql")
    //REST
    implementation("io.quarkus:quarkus-rest")
    //JSON
    implementation("io.quarkus:quarkus-rest-jsonb")
    //control de cambios
    implementation("io.quarkus:quarkus-flyway")
    runtimeOnly("org.flywaydb:flyway-database-postgresql:13.12.2")
    //service Discovery
    implementation("io.smallrye.reactive:smallrye-mutiny-vertx-consul-client")

}

tasks.withType<JavaCompile> {
    options.encoding = "UTF-8"
    options.compilerArgs.add("-parameters")
}