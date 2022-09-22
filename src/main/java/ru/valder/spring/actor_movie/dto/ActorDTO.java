package ru.valder.spring.actor_movie.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import ru.valder.spring.actor_movie.models.MovieModel;

import javax.validation.constraints.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@EqualsAndHashCode
public class ActorDTO {

    @NotEmpty(message = "first name shouldn't be empty")
    @Size(min = 2, max = 100, message = "name should be between 2 and 100 characters")
    private String firstName;

    @NotEmpty(message = "last name shouldn't be empty")
    @Size(min = 2, max = 100, message = "name should be between 2 and 100 characters")
    private String lastName;

    @NotNull(message = "The field shouldn't be empty")
    @Positive(message = "the number should be positive")
    @Digits(integer = 4, fraction = 0, message = "birth year should be a for-digit number")
    @Min(value = 1900, message = "should be a four-digit number, and not less than 1900")
    private int birthYear;

    private Set<MovieModel> movieList = new HashSet<>();

}
