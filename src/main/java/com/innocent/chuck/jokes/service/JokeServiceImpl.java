package com.innocent.chuck.jokes.service;

import com.innocent.chuck.jokes.dto.Joke;
import com.innocent.chuck.jokes.repository.JokeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;

public class JokeServiceImpl implements JokeService {

    private static final Logger logger = LoggerFactory.getLogger(JokeServiceImpl.class);

    @Autowired
    private JokeRepository jokeRepository;

    @Override
    @Cacheable(cacheNames = "categories", key = "")
    public List<String> getCategories() {
        logger.info("fetching categories from repository");
        return this.fetchCategories();
    }

    @CachePut(cacheNames = "categories", key = "")
    private List<String> fetchCategories(){
        return jokeRepository.fetchCategories();
    }

    @Override
    public Joke randomJokeByCategory(String category) {
        logger.info("fetching random joke with category: ", category);
        return jokeRepository.fetchRandomJoke(category);
    }
}
