package com.innocent.chuck.jokes.configuration;

import com.innocent.chuck.jokes.repository.JokeRepository;
import com.innocent.chuck.jokes.repository.JokeRepositoryImp;
import com.innocent.chuck.jokes.service.JokeService;
import com.innocent.chuck.jokes.service.JokeServiceImpl;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfiguration {

    @Bean
    public JokeRepository jokeRepository(){
        return new JokeRepositoryImp();
    }

    @Bean
    public JokeService jokeService(){
        return new JokeServiceImpl();
    }

    @Bean
    public RestTemplate restTemplate(){
        CloseableHttpClient httpClient = HttpClients.custom()
                .setSSLHostnameVerifier(new NoopHostnameVerifier())
                .build();
        HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory();
        requestFactory.setHttpClient(httpClient);
        requestFactory.setConnectTimeout(10000);
        return new RestTemplate(requestFactory);
    }

}
