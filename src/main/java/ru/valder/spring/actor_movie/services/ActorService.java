package ru.valder.spring.actor_movie.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.valder.spring.actor_movie.models.ActorModel;
import ru.valder.spring.actor_movie.repositories.ActorRepository;

import java.util.Collection;


@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
@Slf4j
public class ActorService {

    private final ActorRepository actorRepository;

    public Collection<ActorModel> getAll() {
        return actorRepository.findAll();
    }

    public ActorModel getById(int id) {
        log.info("Getting Actor by id: {}" + id);
        return actorRepository.findById(id).orElseThrow();
    }

    @Transactional
    public ActorModel create(ActorModel newActor) {
        log.info("Updating Actor id: {}" + newActor.getFirstName());
        return actorRepository.save(newActor);
    }

    @Transactional
    public ActorModel update(int id, ActorModel updatedActor) {
        log.info("Updating Actor id: {}" + updatedActor.getFirstName());

        updatedActor.setId(actorRepository.findById(id).orElseThrow().getId());

        return actorRepository.save(updatedActor);
    }

    @Transactional
    public Boolean delete(int id) {
        log.info("Deleting Actor by id: {}" + id);

        actorRepository.deleteById(id);

        return Boolean.TRUE;
    }

}