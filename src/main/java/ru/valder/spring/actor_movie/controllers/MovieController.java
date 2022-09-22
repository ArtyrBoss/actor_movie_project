package ru.valder.spring.actor_movie.controllers;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.valder.spring.actor_movie.dto.MovieDTO;
import ru.valder.spring.actor_movie.models.MovieModel;
import ru.valder.spring.actor_movie.services.MovieService;
import ru.valder.spring.actor_movie.utils.Response;

import javax.validation.Valid;
import java.util.stream.Collectors;

import static java.time.LocalDateTime.now;
import static java.util.Map.of;
import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("/movie")
@RequiredArgsConstructor
public class MovieController {

    private final MovieService movieService;
    private final ModelMapper modelMapper;

    @GetMapping()
    public ResponseEntity<Response> getAll() {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .responseData(of("movies", movieService.getAll().stream().
                                map(this::convertToMovieDTO).collect(Collectors.toList())))
                        .messageForClient("Movies retrieved")
                        .httpStatus(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<Response> getById(@PathVariable("id") int id) {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .responseData(of("movie", convertToMovieDTO(movieService.getById(id))))
                        .messageForClient("Movie was retrieved")
                        .httpStatus(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @PostMapping()
    public ResponseEntity<Response> create(@RequestBody @Valid MovieDTO movieDTO) {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .responseData(of("movie", movieService.create(convertToMovie(movieDTO))))
                        .messageForClient("Movie was created")
                        .httpStatus(CREATED)
                        .statusCode(CREATED.value())
                        .build()
        );
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Response> update(@PathVariable("id") int id, @RequestBody @Valid MovieDTO movieDTO) {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .responseData(of("movie", movieService.update(id, convertToMovie(movieDTO))))
                        .messageForClient("Movie was updated")
                        .httpStatus(ACCEPTED)
                        .statusCode(ACCEPTED.value())
                        .build()
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Response> delete(@PathVariable("id") int id, @RequestBody @Valid MovieDTO movieDTO) {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .responseData(of("movie", movieService.delete(id, convertToMovie(movieDTO))))
                        .messageForClient("Movie was deleted")
                        .httpStatus(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    private MovieDTO convertToMovieDTO(MovieModel movieModel) {
        return modelMapper.map(movieModel, MovieDTO.class);
    }

    private MovieModel convertToMovie(MovieDTO movieDTO) {
        return modelMapper.map(movieDTO, MovieModel.class);
    }

}
