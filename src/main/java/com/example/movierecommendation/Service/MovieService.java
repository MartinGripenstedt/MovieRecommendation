package com.example.movierecommendation.Service;

import com.example.movierecommendation.Model.Movie;
import com.example.movierecommendation.Repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class MovieService {
    @Autowired
    private MovieRepository movieRepository;

    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    public Movie getRandomMovie() {
        List<Movie> movies = movieRepository.findAll();
        if (movies.isEmpty()) {
            return null;
        }
        Random rand = new Random();
        return movies.get(rand.nextInt(movies.size()));
    }

    public void addMovie(Movie movie) {
        movieRepository.save(movie);
    }
}
