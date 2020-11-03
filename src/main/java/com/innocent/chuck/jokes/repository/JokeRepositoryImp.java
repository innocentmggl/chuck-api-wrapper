package com.innocent.chuck.jokes.repository;

import com.innocent.chuck.jokes.dto.Joke;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

public class JokeRepositoryImp implements JokeRepository {

    @Autowired
    private RestTemplate restTemplate;

    private static final Logger logger = LoggerFactory.getLogger(JokeRepositoryImp.class);
    private final String categoriesUrl = "https://api.chucknorris.io/jokes/categories";
    private final String jokeByCategory = "https://api.chucknorris.io/jokes/random?category=";

    @Override
    public List<String> fetchCategories() {
        logger.info("fetching categories from api");
        String[] response = restTemplate.getForObject(categoriesUrl, String[].class);
        return Arrays.asList(response);
    }

    @Override
    public Joke fetchRandomJoke(String category) {
        logger.info("fetching random jokes by category");
        return restTemplate.getForObject(jokeByCategory + category, Joke.class);
    }
}
