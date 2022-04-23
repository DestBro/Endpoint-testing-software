package org.example.service.impl;

import java.util.Collections;
import java.util.List;

import org.example.domain.User;
import org.example.interceptor.LoggingRequestInterceptor;
import org.example.service.TypicodeService;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.BufferingClientHttpRequestFactory;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class TypicodeServiceImpl implements TypicodeService, InitializingBean {
  RestTemplate restTemplate;

  @Override
  public ResponseEntity<List<User>> fetchUsers() {
    ResponseEntity<List<User>> rateResponse =
        restTemplate.exchange("https://jsonplaceholder.typicode.com/users",
            HttpMethod.GET, null, new ParameterizedTypeReference<List<User>>() {});

    return rateResponse;
  }

  @Override
  public void afterPropertiesSet() throws Exception {
    ClientHttpRequestFactory factory =
        new BufferingClientHttpRequestFactory(new SimpleClientHttpRequestFactory());

    restTemplate = new RestTemplate(factory);
    restTemplate.setInterceptors(Collections.singletonList(new LoggingRequestInterceptor()));
  }
}
