package com.arindam;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {
	@Value("${product.service.url}")
private String baseUrl;
	@Bean
WebClient webClient()
{
	return WebClient.builder().baseUrl(baseUrl).build();
}
}
