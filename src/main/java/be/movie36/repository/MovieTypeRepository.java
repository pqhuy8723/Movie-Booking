package be.movie36.repository;

import be.movie36.entity.MovieType;

import java.util.Optional;

public interface MovieTypeRepository {
    Optional<MovieType> findByName(String name);
}
