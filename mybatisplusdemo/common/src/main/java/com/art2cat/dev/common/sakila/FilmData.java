package com.art2cat.dev.common.sakila;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import lombok.Data;

@Data
public class FilmData implements Serializable {

    private Integer actorId;
    private String firstName;
    private String lastName;
    private Integer filmId;
    private String title;
    private String description;
    private LocalDate releaseYear;
    private Integer languageId;
    private Integer originalLanguageId;
    private Integer rentalDuration;
    private Integer rentalRate;
    private Integer length;
    private String rating;
    private String specialFeatures;
    private LocalDateTime lastUpdate;
}
