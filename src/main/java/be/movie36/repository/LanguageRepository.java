package be.movie36.repository;

import be.movie36.entity.Language;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LanguageRepository {
    Optional<Language> findByName(String name);
}
