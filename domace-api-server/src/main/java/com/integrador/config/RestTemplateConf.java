package com.integrador.config;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;


@Configuration
public class RestTemplateConf {
	
	@Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {

        return builder
                //.setConnectTimeout(Duration.ofMillis(3000))
                //.setReadTimeout(Duration.ofMillis(3000))
        		//.errorHandler(new RestTemplateResponseErrorHandler())
        		.requestFactory(HttpComponentsClientHttpRequestFactory.class)
                .build();
    }
}
