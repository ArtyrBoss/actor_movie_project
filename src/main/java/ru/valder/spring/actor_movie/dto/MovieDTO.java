package ru.valder.spring.actor_movie.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import ru.valder.spring.actor_movie.models.ActorModel;

import javax.validation.constraints.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@EqualsAndHashCode
public class MovieDTO {

    @NotEmpty(message = "first name shouldn't be empty")
    @Size(min = 2, max = 100, message = "name should be between 2 and 100 characters")
    private String name;

    @NotNull(message = "The field shouldn't be empty")
    @Positive(message = "the number should be positive")
    @Digits(integer = 4, fraction = 0, message = "year should be a for-digit number")
    @Min(value = 1900, message = "should be four-digit number, and not less than 1900")
    private int year;

    private Set<ActorModel> actorsList = new HashSet<>();

}
