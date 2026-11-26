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

    // Rest Client
    implementation("io.quarkus:quarkus-rest-client-jsonb")
    implementation("io.quarkus:quarkus-rest-client")

    //service Discovery
    implementation("io.smallrye.reactive:smallrye-mutiny-vertx-consul-client")

    //load balancer
    implementation("io.quarkus:quarkus-smallrye-stork")

}

tasks.withType<JavaCompile> {
    options.encoding = "UTF-8"
    options.compilerArgs.add("-parameters")
}