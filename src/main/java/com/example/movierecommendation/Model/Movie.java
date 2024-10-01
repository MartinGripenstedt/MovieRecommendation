package com.example.movierecommendation.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.*;
import org.springframework.data.annotation.Id;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Movie {
    @jakarta.persistence.Id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String genre;
    private int releaseYear;
    private String description;

  //  public Movie(String theDarkKnight, String action, int i, String s) {
   // }
}
