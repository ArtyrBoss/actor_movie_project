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
@Table(name = "Actor")
public class ActorModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "first_name")
    @NotEmpty(message = "first name shouldn't be empty")
    @Size(min = 2, max = 100, message = "name should be between 2 and 100 characters")
    private String firstName;

    @Column(name = "last_name")
    @NotEmpty(message = "last name shouldn't be empty")
    @Size(min = 2, max = 100, message = "name should be between 2 and 100 characters")
    private String lastName;

    @Column(name = "birth_year")
    @NotNull(message = "The field shouldn't be empty")
    @Positive(message = "the number should be positive")
    @Digits(integer = 4, fraction = 0, message = "birth year should be a for-digit number")
    @Min(value = 1900, message = "should be four-digit number, and not less than 1900")
    private int birthYear;

    @ManyToMany
    @JoinTable(
            name = "actor_movie",
            joinColumns = @JoinColumn(name = "actor_id"),
            inverseJoinColumns = @JoinColumn(name = "movie_id")
    )
    @Cascade({org.hibernate.annotations.CascadeType.ALL})
    private Set<MovieModel> movieList = new HashSet<>();

}