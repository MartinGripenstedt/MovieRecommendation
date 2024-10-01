package com.example.movierecommendation.Controller;

import com.example.movierecommendation.Model.Movie;
import com.example.movierecommendation.Service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MovieController {
    @Autowired
    private MovieService movieService;

    @GetMapping("/")
    public String index(Model model) {
        Movie randomMovie = movieService.getRandomMovie();
        model.addAttribute("movie", randomMovie);
        return "index";
    }


    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("movie", new Movie());
        return "add-movie";
    }

    @PostMapping("/add")
    public String addMovie(@ModelAttribute Movie movie) {
        movieService.addMovie(movie);
        return "redirect:/";
    }
}
