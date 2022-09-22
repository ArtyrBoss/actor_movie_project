package ru.valder.spring.actor_movie.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import ru.valder.spring.actor_movie.models.MovieModel;

public interface MovieRepository extends JpaRepository<MovieModel, Integer> { }
