package com.hurricane.mindmap.conf;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Path;
import java.time.Duration;


@Configuration
@Slf4j
public class WorkerConfig {

    @EventListener
    public void contextRefreshedEventListener(ContextRefreshedEvent event) {
        /*log.info("Doing some important job on app startup!");

        HttpClient client = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_2)
                .build();

        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create("https://openjdk.java.net/groups/net/httpclient/intro.html"))
                .timeout(Duration.ofMinutes(1))
                .build();


        client.sendAsync(request, HttpResponse.BodyHandlers.ofFile(Path.of("page.html")))
                .thenApplyAsync(resp -> {
                    System.out.println(resp.statusCode());
                    return resp;
                }).thenApplyAsync(HttpResponse::body)
                .thenAcceptAsync(System.out::println);*/
    }
}
