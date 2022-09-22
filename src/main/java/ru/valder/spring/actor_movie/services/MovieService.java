package ru.valder.spring.actor_movie.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.valder.spring.actor_movie.models.MovieModel;
import ru.valder.spring.actor_movie.repositories.MovieRepository;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
@Slf4j
public class MovieService {

    private final MovieRepository movieRepository;

    public List<MovieModel> getAll() {
        return movieRepository.findAll();
    }

    public MovieModel getById(int id) {
        log.info("Getting Movie by id: {}" + id);

        return movieRepository.findById(id).orElseThrow();
    }

    @Transactional
    public MovieModel create(MovieModel newMovie) {
        return movieRepository.save(newMovie);
    }

    @Transactional
    public MovieModel update(int id, MovieModel updatedMovie) {
        log.info("Updating movie id: {}" + updatedMovie.getName());

        updatedMovie.setId(movieRepository.findById(id).orElseThrow().getId());

        return movieRepository.save(updatedMovie);
    }

    @Transactional
    public MovieModel delete(int id, MovieModel deletedMovie) {
        log.info("Deleting Movie by id: {}" + id);

        deletedMovie.setId(movieRepository.findById(id).orElseThrow().getId());
        movieRepository.delete(deletedMovie);

        return deletedMovie;

    }

}
