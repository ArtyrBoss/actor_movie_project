package ru.valder.spring.actor_movie.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import ru.valder.spring.actor_movie.models.ActorModel;

public interface ActorRepository extends JpaRepository<ActorModel,Integer> { }
