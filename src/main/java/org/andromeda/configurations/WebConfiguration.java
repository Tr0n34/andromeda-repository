package org.andromeda.configurations;

import io.netty.channel.ChannelOption;
import io.netty.handler.timeout.ReadTimeoutHandler;
import io.netty.handler.timeout.WriteTimeoutHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.netty.http.client.HttpClient;

import java.time.Duration;
import java.util.concurrent.TimeUnit;


@Configuration
public class WebConfiguration {

    private static final Logger logger = LoggerFactory.getLogger(WebConfiguration.class);

    @Value("http.client.timeout.connection:5000")
    private int connectionTimeout;
    @Value("http.client.timeout.response:5000")
    private int responseTimeout;
    @Value("http.client.timeout.read:5000")
    private int readTimeout;
    @Value("http.client.timeout.write:5000")
    private int writeTimeout;

    public WebClient webClient() {
        HttpClient httpClient = HttpClient.create()
                .option(ChannelOption.CONNECT_TIMEOUT_MILLIS, this.connectionTimeout)
                .responseTimeout(Duration.ofMillis(this.responseTimeout))
                .doOnConnected(conn -> {
                    conn.addHandlerLast(new ReadTimeoutHandler(this.readTimeout, TimeUnit.MILLISECONDS))
                            .addHandlerLast(new WriteTimeoutHandler(this.writeTimeout, TimeUnit.MILLISECONDS));
                });
        logger.debug("{}", httpClient.toString());
        WebClient webclient = WebClient.builder()
                .defaultCookie("", "")
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .clientConnector(new ReactorClientHttpConnector(httpClient))
                .build();
        logger.debug("{}", webclient.toString());
        return webclient;
    }





}
