package com.innocent.chuck.jokes.repository;

import com.innocent.chuck.jokes.dto.Joke;

import java.util.List;

public interface JokeRepository {
    List<String> fetchCategories();
    Joke fetchRandomJoke(String category);
}
