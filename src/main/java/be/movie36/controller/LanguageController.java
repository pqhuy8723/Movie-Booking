package be.movie36.controller;


import be.movie36.constant.Message;
import be.movie36.dto.request.LanguageRequest;
import be.movie36.dto.response.ApiResponse;
import be.movie36.dto.response.LanguageResonse;
import be.movie36.service.LanguageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/language")
@RequiredArgsConstructor
public class LanguageController {
    private final LanguageService service;

    // GET /api/language — lấy tất cả (ADMIN)
    @GetMapping
    public ResponseEntity<ApiResponse<List<LanguageResonse>>> getAll() {
        return ResponseEntity.ok(
                ApiResponse.success(Message.GET_LANGUAGE_SUCESS, service.getAll()));
    }

    // GET /api/language/active — lấy các genre đang active (PUBLIC)
    @GetMapping("/active")
    public ResponseEntity<ApiResponse<List<LanguageResonse>>> getAllActive() {
        return ResponseEntity.ok(
                ApiResponse.success(Message.GET_LANGUAGE_SUCESS, service.getAllActive()));
    }

    // GET /api/language/{id}
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<LanguageResonse>> getById(@PathVariable Long id) {
        return ResponseEntity.ok(
                ApiResponse.success(Message.GET_LANGUAGE_BYID, service.getById(id)));
    }

    // POST /api/language (ADMIN)
    @PostMapping
    public ResponseEntity<ApiResponse<LanguageResonse>> create(
            @Valid @RequestBody LanguageRequest request) {
        return ResponseEntity.ok(
                ApiResponse.success(Message.CREATE_LANGUAGE_SUCESS, service.create(request)));
    }

    // PUT /api/language/{id} (ADMIN)
    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<LanguageResonse>> update(
            @PathVariable Long id,
            @Valid @RequestBody LanguageRequest request) {
        return ResponseEntity.ok(
                ApiResponse.success(Message.UPDATE_LANGUAGE_SUCESS, service.update(id, request)));
    }

    // DELETE /api/language/{id} (ADMIN)
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.ok(ApiResponse.success(Message.DELETE_LANGUAGE_SUCESS));
    }

}
