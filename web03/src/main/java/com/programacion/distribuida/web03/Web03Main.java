package com.programacion.distribuida.web03;

import io.helidon.config.Config;
import io.helidon.dbclient.DbClient;
import io.helidon.http.media.jsonb.JsonbSupport;
import io.helidon.webserver.WebServer;
import io.helidon.webserver.http.ServerRequest;
import io.helidon.webserver.http.ServerResponse;
import jakarta.json.Json;
import jakarta.json.JsonBuilderFactory;

import java.util.Map;

public class Web03Main {

    private static DbClient dbClient;
    static JsonBuilderFactory factory = Json.createBuilderFactory(Map.of());

    public static void handleBooks(ServerRequest req, ServerResponse res) {
        // 1. Obtener la lista de libros desde la base de datos
        var books = dbClient.execute()
                .createQuery("select * from books")
                .execute()
                .map(row -> Book.builder()
                        .title(row.column("title").getString())
                        .isbn(row.column("isbn").getString())
                        .build())
                .toList();

        // 2. Enviar la respuesta una sola vez
        res.send(books);

        /*
         * NOTA: No puedes usar res.send() múltiples veces en una misma petición.
         * Si quieres probar JSON-P o JSON-B individualmente, hazlo en peticiones
         * separadas o endpoints distintos.
         */
    }

    public static void main(String[] args) {
        Config config = Config.create();

        var configDB = config.get("db");
        var configHttp = config.get("server");

        dbClient = DbClient.builder()
                .config(configDB)
                .build();

        WebServer.builder()
                .config(configHttp)
                .mediaContext(ctx->ctx.addMediaSupport(JsonbSupport.create()))
                .routing(it -> it
                        .get("/books", Web03Main::handleBooks)
                )
                .build()
                .start();
    }
}