package com.example.movierecommendation.Service;

import com.example.movierecommendation.Model.Movie;
import com.example.movierecommendation.Repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieSeeder {
    @Autowired
    private MovieRepository movieRepository;

    public void seedMovies() {
        List<Movie> movies = List.of(
                new Movie(1L,"Inception", "Sci-Fi", 2010, "A thief who steals corporate secrets using dream-sharing technology."),
                new Movie(2L,"The Dark Knight", "Action", 2008, "Batman sets out to dismantle the remaining criminal organizations in Gotham."),
                new Movie(3L,"Interstellar", "Sci-Fi", 2014, "A group of astronauts travel through a wormhole in search of a new home for humanity."),
                new Movie(4L,"The Matrix", "Sci-Fi", 1999, "A computer hacker learns about the true nature of reality and his role in the war against its controllers."),
                new Movie(5L,"Pulp Fiction", "Crime", 1994, "The lives of two mob hitmen, a boxer, and a pair of bandits intertwine.")
        );

        for (Movie movie : movies) {
            if (!isMovieAlreadySeeded(movie)) {
                movieRepository.save(movie);
            }
        }
    }

    private boolean isMovieAlreadySeeded(Movie movie) {
        return movieRepository.findByTitleAndReleaseYear(movie.getTitle(), movie.getReleaseYear()).isPresent();
    }

}
