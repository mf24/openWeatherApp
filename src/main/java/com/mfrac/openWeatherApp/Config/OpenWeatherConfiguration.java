package com.mfrac.openWeatherApp.Config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.web.client.RestTemplate;

@Configuration
public class OpenWeatherConfiguration {

    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

    @Bean
    public HttpEntity<String> getHttpEntity() {
      return new HttpEntity<>(new HttpHeaders());
    }

    @Value("${api.key:0d134130d7e9ced3aad099b6893c2edf}")
    private String token;

    public String getToken() {
        return token;
    }

    @Value(("${api.endpoint:http://api.openweathermap.org/data/2.5}"))
    private String url;

    public String getUrl() {
        return url;
    }

}
