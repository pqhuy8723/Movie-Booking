package be.movie36.controller;


import be.movie36.dto.request.ActorRequest;
import be.movie36.dto.response.ActorResponse;
import be.movie36.dto.response.ApiResponse;
import be.movie36.service.ActorService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/actors")
@RequiredArgsConstructor
public class ActorController {
    private final ActorService actorService;

    @GetMapping
    public ResponseEntity<ApiResponse<List<ActorResponse>>> getAll() {
        return ResponseEntity.ok(ApiResponse.success("Thành công", actorService.getAll()));
    }

    @GetMapping("/search")
    public ResponseEntity<ApiResponse<List<ActorResponse>>> search(@RequestParam String name) {
        return ResponseEntity.ok(ApiResponse.success("Thành công", actorService.search(name)));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<ActorResponse>> getById(@PathVariable Long id) {
        return ResponseEntity.ok(ApiResponse.success("Thành công", actorService.getById(id)));
    }

    @PostMapping
    public ResponseEntity<ApiResponse<ActorResponse>> create(
            @Valid @RequestBody ActorRequest request) {
        return ResponseEntity.ok(ApiResponse.success("Tạo diễn viên thành công",
                actorService.create(request)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<ActorResponse>> update(
            @PathVariable Long id, @Valid @RequestBody ActorRequest request) {
        return ResponseEntity.ok(ApiResponse.success("Cập nhật thành công",
                actorService.update(id, request)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> delete(@PathVariable Long id) {
        actorService.delete(id);
        return ResponseEntity.ok(ApiResponse.success("Xóa diễn viên thành công"));
    }
}
