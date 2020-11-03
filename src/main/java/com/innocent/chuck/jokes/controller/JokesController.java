package com.innocent.chuck.jokes.controller;

import com.innocent.chuck.jokes.dto.Joke;
import com.innocent.chuck.jokes.service.JokeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController()
@RequestMapping("/api/v1/jokes")
public class JokesController {

    @Autowired
    private JokeService jokeService;

    @GetMapping("/categories")
    public List<String> getCategories() {
        return jokeService.getCategories();
    }

    @GetMapping("/random/{category}")
    public Joke randomJokeByCategory(@PathVariable String category) {
        return jokeService.randomJokeByCategory(category);
    }
}
