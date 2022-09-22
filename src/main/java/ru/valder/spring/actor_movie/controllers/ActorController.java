package ru.valder.spring.actor_movie.controllers;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.valder.spring.actor_movie.dto.ActorDTO;
import ru.valder.spring.actor_movie.models.ActorModel;
import ru.valder.spring.actor_movie.services.ActorService;
import ru.valder.spring.actor_movie.utils.Response;

import javax.validation.Valid;
import java.util.stream.Collectors;

import static java.time.LocalDateTime.now;
import static java.util.Map.of;
import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("/actor")
@RequiredArgsConstructor
public class ActorController {

    private final ActorService actorService;

    private final ModelMapper modelMapper;

    @GetMapping()
    public ResponseEntity<Response> getAll() {

        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .responseData(of("actors", actorService.getAll().stream().
                                map(this::convertToActorDTO).collect(Collectors.toList())))
                        .messageForClient("Actors retrieved")
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
                        .responseData(of("actors", convertToActorDTO(actorService.getById(id))))
                        .messageForClient("Actor was retrieved")
                        .httpStatus(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @PostMapping()
    public ResponseEntity<Response> create(@RequestBody @Valid ActorDTO actorDTO) {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .responseData(of("actor", actorService.create(convertToActor(actorDTO))))
                        .messageForClient("Actor was created")
                        .httpStatus(CREATED)
                        .statusCode(CREATED.value())
                        .build()
        );
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Response> update(@PathVariable("id") int id, @RequestBody @Valid ActorDTO actorDTO) {

        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .responseData(of("actor", actorService.update(id, convertToActor(actorDTO))))
                        .messageForClient("Actor was updated")
                        .httpStatus(ACCEPTED)
                        .statusCode(ACCEPTED.value())
                        .build()
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Response> delete(@PathVariable("id") int id) {

        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .responseData(of("actor", actorService.delete(id)))
                        .messageForClient("Actor was deleted")
                        .httpStatus(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    private ActorModel convertToActor(ActorDTO actorDTO) {
        return modelMapper.map(actorDTO, ActorModel.class);
    }

    private ActorDTO convertToActorDTO(ActorModel actorModel) {
        return modelMapper.map(actorModel, ActorDTO.class);
    }

}
