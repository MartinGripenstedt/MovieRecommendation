package com.example.movierecommendation.Repository;

import com.example.movierecommendation.Model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MovieRepository extends JpaRepository <Movie, Long>{
    Optional<Movie> findByTitleAndReleaseYear(String title, int releaseYear);
}
