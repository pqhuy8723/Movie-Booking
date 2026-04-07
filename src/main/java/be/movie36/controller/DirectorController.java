package be.movie36.controller;


import be.movie36.constant.Message;
import be.movie36.dto.request.ActorRequest;
import be.movie36.dto.request.DirectorRequest;
import be.movie36.dto.response.ActorResponse;
import be.movie36.dto.response.ApiResponse;
import be.movie36.dto.response.DirectorResponse;
import be.movie36.dto.response.GenreResponse;
import be.movie36.service.DirectorService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/directors")
@RequiredArgsConstructor
public class DirectorController {
    private final DirectorService directorService;

    // GET /api/directors
    @GetMapping
    public ResponseEntity<ApiResponse<List<DirectorResponse>>> getAll() {
        return ResponseEntity.ok(ApiResponse.success("Thành công", directorService.getAll()));
    }

    // GET /api/directors/active — lấy các genre đang active (PUBLIC)
    @GetMapping("/search")
    public ResponseEntity<ApiResponse<List<DirectorResponse>>> search(@RequestParam String name) {
        return ResponseEntity.ok(ApiResponse.success("Thành công", directorService.search(name)));
    }

    // GET /api/directors/{id}
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<DirectorResponse>> getById(@PathVariable Long id) {
        return ResponseEntity.ok(ApiResponse.success("Thành công", directorService.getById(id)));
    }

    // POST /api/directors (ADMIN)
    @PostMapping
    public ResponseEntity<ApiResponse<DirectorResponse>> create(
            @Valid @RequestBody DirectorRequest request) {
        return ResponseEntity.ok(ApiResponse.success("Tạo diễn viên thành công",
                directorService.create(request)));
    }
    // PUT /api/directors (ADMIN)
    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<DirectorResponse>> update(
            @PathVariable Long id, @Valid @RequestBody DirectorRequest request) {
        return ResponseEntity.ok(ApiResponse.success("Cập nhật thành công",
                directorService.update(id, request)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> delete(@PathVariable Long id) {
        directorService.delete(id);
        return ResponseEntity.ok(ApiResponse.success("Xóa diễn viên thành công"));
    }

}
