package com.rafaelmgr12.challengeb2w.config;


import com.rafaelmgr12.challengeb2w.entity.Product;
import com.rafaelmgr12.challengeb2w.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Configuration
public class DbInit {

    final String URL_MOCK_PRODUCT = "http://www.mocky.io/v2/5817803a1000007d01cc7fc9";

    @Autowired
    private ProductRepository repository;

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }


    @Bean
    public boolean instantiateDatabase(){
        final RestTemplate restTemplate = new RestTemplate();
        final ResponseEntity<List<Product>> response = restTemplate.exchange(
                URL_MOCK_PRODUCT,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<>(){});
        List<Product> productMock = response.getBody();


        if (productMock != null && !productMock.isEmpty()) repository.saveAll(productMock);
        return true;
    }
}
