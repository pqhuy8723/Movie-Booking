package be.movie36.service;

import be.movie36.dto.request.ActorRequest;
import be.movie36.dto.response.ActorResponse;
import be.movie36.entity.Actor;
import be.movie36.exception.AppException;
import be.movie36.exception.ErrorCode;
import be.movie36.repository.ActorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ActorService {
    private final ActorRepository actorRepository;

    // tao actor
    public ActorResponse create(ActorRequest request) {
        if (actorRepository.findByName(request.getName()).isPresent()) {
            throw new AppException(ErrorCode.ACTOR_EXISTED);
        }
        return toResponse(actorRepository.save(
                Actor.builder().name(request.getName()).build()));
    }

    // lay danh sach actor
    public List<ActorResponse> getAll() {
        return actorRepository.findAll().stream().map(this::toResponse).toList();
    }

    // tim kiem danh sach actor
    public List<ActorResponse> search(String name) {
        return actorRepository.findByNameContainingIgnoreCase(name)
                .stream().map(this::toResponse).toList();
    }

    // lat actor theo id
    public ActorResponse getById(Long id) {
        return toResponse(findById(id));
    }
    // update

    public ActorResponse update(Long id, ActorRequest request) {
        Actor actor = findById(id);

        actorRepository.findByName(request.getName())
                .ifPresent(existing -> {
                    if (!existing.getId().equals(id)) {
                        throw new AppException(ErrorCode.ACTOR_EXISTED);
                    }
                });

        actor.setName(request.getName());
        return toResponse(actorRepository.save(actor));
    }

    // xoa
    public void delete(Long id) {
        actorRepository.delete(findById(id));
    }


    // helper
    public Actor findById(Long id) {
        return actorRepository.findById(id)
                .orElseThrow(() -> new AppException(ErrorCode.ACTOR_NOT_FOUND));
    }

    private ActorResponse toResponse(Actor actor) {
        return ActorResponse.builder()
                .id(actor.getId())
                .name(actor.getName())
                .build();
    }

}
