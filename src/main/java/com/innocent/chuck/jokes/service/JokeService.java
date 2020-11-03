package com.innocent.chuck.jokes.service;

import com.innocent.chuck.jokes.dto.Joke;
import java.util.List;

public interface JokeService {
    List<String> getCategories();
    Joke randomJokeByCategory(String category);
}