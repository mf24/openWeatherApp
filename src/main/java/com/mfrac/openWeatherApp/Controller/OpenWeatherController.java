package com.mfrac.openWeatherApp.Controller;

import com.mfrac.openWeatherApp.Config.OpenWeatherConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/weather")
@PropertySource(value = "classpath:application.yaml")
public class OpenWeatherController {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    HttpEntity<String> httpEntity;

    @Autowired
    OpenWeatherConfiguration openWeatherConfiguration;

    @GetMapping("/city/{id}")
    public ResponseEntity<String> getByCityId(@PathVariable String id, @RequestParam(required = false, defaultValue = "en") String lang,
                                              @RequestParam(required = false, defaultValue = "html") String mode) {

        ResponseEntity<String> response = restTemplate.exchange(openWeatherConfiguration.getUrl() + "/weather?id={id}&appid={appid}&lang={lang}&mode={mode}",
                    HttpMethod.GET, httpEntity, String.class, id, openWeatherConfiguration.getToken(), lang, mode);


        //TODO: response validation and mapping

        return response.getStatusCode() == HttpStatus.OK ? response : null;
    }

    @PostMapping("/alert")
    public void getByCityId() {
        //TODO: notification maintenance
    }
}
