package com.progamacion.distribuida.books.config;

import com.progamacion.distribuida.books.clients.AuthorRestClient;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Produces;
import jakarta.inject.Inject;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.rest.client.RestClientBuilder;

@ApplicationScoped
public class RestClientConfig {

//    @Inject
//    @ConfigProperty(name = "app.authors.url")
//    private String authorsUrl;
//
//    @Produces
//    @ApplicationScoped
//    public AuthorRestClient authorRestClient() {
//     return  RestClientBuilder.newBuilder()
//             .baseUri(authorsUrl)
//             .build(AuthorRestClient.class);
//    }


}
