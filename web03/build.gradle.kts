plugins {
    id("java")
    id("io.freefair.lombok") version "9.8.3"
    id("com.gradleup.shadow") version "9.6.1"
}

group = "org.example"
version = "unspecified"

repositories {
    mavenCentral()
}
val helidonversion = "4.5.6"
dependencies {
// Source: https://mvnrepository.com/artifact/io.helidon.webserver/helidon-webserver
    //servidor http
    implementation("io.helidon.webserver:helidon-webserver:$helidonversion")

    //json
    implementation("io.helidon.http.media:helidon-http-media-jsonb:$helidonversion")
    implementation("io.helidon.http.media:helidon-http-media-jsonp:$helidonversion")

    //configuracion
    implementation("io.helidon.config:helidon-config-yaml:${helidonversion}")

    //acceso a datos
    implementation("io.helidon.dbclient:helidon-dbclient:${helidonversion}")
    implementation("io.helidon.dbclient:helidon-dbclient-jdbc:${helidonversion}")
    implementation("io.helidon.dbclient:helidon-dbclient-hikari:${helidonversion}")
    // Source: https://mvnrepository.com/artifact/org.postgresql/postgresql
    implementation("org.postgresql:postgresql:42.7.14")
}

tasks.shadowJar{
    mergeServiceFiles()
}

tasks.jar{
    manifest {
        attributes["Main-Class"] = "com.programacion.distribuida.web03.Web03Main"
    }
}
