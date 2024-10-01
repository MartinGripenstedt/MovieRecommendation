package com.example.movierecommendation;

import com.example.movierecommendation.Service.MovieSeeder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MovieRecommendationApplication {
	@Autowired
	private MovieSeeder movieSeeder;

	public static void main(String[] args) {
		SpringApplication.run(MovieRecommendationApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner() {
		return args -> {
			movieSeeder.seedMovies();
		};
	}
}
