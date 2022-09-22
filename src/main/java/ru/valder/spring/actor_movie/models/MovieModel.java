package ru.valder.spring.actor_movie.models;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@EqualsAndHashCode

@Entity
@Table(name = "Movie")
public class MovieModel {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    @NotEmpty(message = "first name shouldn't be empty")
    @Size(min = 2, max = 100, message = "name should be between 2 and 100 characters")
    private String name;

    @Column(name = "year")
    @NotNull(message = "The field shouldn't be empty")
    @Positive(message = "the number should be positive")
    @Digits(integer = 4, fraction = 0, message = "year should be a for-digit number")
    @Min(value = 1900, message = "should be four-digit number, and not less than 1900")
    private int year;

    @ManyToMany(mappedBy = "movieList")
    @Cascade({org.hibernate.annotations.CascadeType.ALL})
    private Set<ActorModel> actorsList = new HashSet<>();

}
