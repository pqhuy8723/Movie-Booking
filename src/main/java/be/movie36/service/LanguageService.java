package be.movie36.service;

import be.movie36.dto.request.GenreRequest;
import be.movie36.dto.request.LanguageRequest;
import be.movie36.dto.response.GenreResponse;
import be.movie36.dto.response.LanguageResonse;
import be.movie36.entity.Genre;
import be.movie36.entity.Language;
import be.movie36.enums.Status;
import be.movie36.exception.AppException;
import be.movie36.exception.ErrorCode;
import be.movie36.repository.LanguageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LanguageService {
    private final LanguageRepository languageRepository;

    // tao moi
    public LanguageResonse create(LanguageRequest request) {
        if (languageRepository.findByName(request.getName()).isPresent()) {
            throw new AppException(ErrorCode.LANGUAGE_EXISTED);
        }
        Language language = Language.builder()
                .name(request.getName())
                .status(parseStatus(request.getStatus()))
                .build();
        return toResponse(languageRepository.save(language));
    }

    // lay ra tat ca
    public List<LanguageResonse> getAll() {
        return languageRepository.findAll().stream().map(this::toResponse).toList();
    }

    // lay tat ca dang o trang thai active
    public List<LanguageResonse> getAllActive() {
        return languageRepository.findByStatus(Status.ACTIVE).stream().map(this::toResponse).toList();
    }

    // lay theo id
    public LanguageResonse getById(Long id) {
        return toResponse(findById(id));
    }

    // cap nhat

    public LanguageResonse update(Long id, LanguageRequest request) {
        Language language = findById(id);

        // Kiểm tra tên mới có bị trùng với genre khác không
        languageRepository.findByName(request.getName())
                .ifPresent(existing -> {
                    if (!existing.getId().equals(id)) {
                        throw new AppException(ErrorCode.GENRE_EXISTED);
                    }
                });

        language.setName(request.getName());
        language.setStatus(parseStatus(request.getStatus()));

        return toResponse(languageRepository.save(language));
    }

    // xoa
    public void delete(Long id) {
        Language language = findById(id);
        language.setStatus(Status.INACTIVE);
        languageRepository.save(language);
    }

    // chuyen inactive sang active
    public  void restore(Long id){
        Language language = findById(id);
        language.setStatus(Status.ACTIVE);
        languageRepository.save(language);
    }

    // helper

    private Language findById(Long id) {
        return languageRepository.findById(id)
                .orElseThrow(() -> new AppException(ErrorCode.LANGUAGE_NOT_FOUND));
    }

    private Status parseStatus(String status) {
        if (status == null || status.isBlank()) {
            return Status.ACTIVE;
        }
        try {
            return Status.valueOf(status.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new AppException(ErrorCode.INVALID_STATUS);
        }
    }

    private LanguageResonse toResponse(Language language) {
        return LanguageResonse.builder()
                .id(language.getId())
                .name(language.getName())
                .status(language.getStatus().name())
                .build();
    }
}
