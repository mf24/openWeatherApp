package com.mfrac.openWeatherApp.Controller;

import com.mfrac.openWeatherApp.Config.OpenWeatherConfiguration;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class OpenWeatherControllerTest {

    @Mock
    RestTemplate restTemplate;
    @Mock
    HttpEntity<String> httpEntity;
    @Mock
    OpenWeatherConfiguration openWeatherConfiguration;

    @InjectMocks
    OpenWeatherController openWeatherController;

    @Test
    public void shouldReturnHttpStatusOk() {
        //given
        when(openWeatherConfiguration.getToken()).thenReturn("token");
        when(openWeatherConfiguration.getUrl()).thenReturn("url");
        when(restTemplate.exchange("url/weather?id={id}&appid={appid}&lang={lang}&mode={mode}", HttpMethod.GET, httpEntity, String.class, "756135", "token", "pl", "json"))
                .thenReturn(new ResponseEntity<>(HttpStatus.OK));
        //when
        ResponseEntity<String> byCityId = openWeatherController.getByCityId("756135", "pl", "json");
        //then
        assertThat(byCityId.getStatusCode().value()).isEqualTo(200);
    }
}