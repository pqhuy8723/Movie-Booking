package be.movie36.controller;


import be.movie36.constant.Message;
import be.movie36.dto.request.LoginRequest;
import be.movie36.dto.request.RefreshTokenRequest;
import be.movie36.dto.request.RegisterRequest;
import be.movie36.dto.response.ApiResponse;
import be.movie36.dto.response.AuthResponse;
import be.movie36.service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    // POST /api/auth/register
    @PostMapping("/register")
    public ResponseEntity<ApiResponse<Void>> register(
            @Valid @RequestBody RegisterRequest request) {

        authService.register(request);
        return ResponseEntity.ok(ApiResponse.success(Message.REGISTER_SUCESS));
    }

    // POST /api/auth/login
    @PostMapping("/login")
    public ResponseEntity<ApiResponse<AuthResponse>> login(@Valid @RequestBody LoginRequest request) {
        AuthResponse data = authService.login(request);
        return ResponseEntity.ok(ApiResponse.success(Message.LOGIN_SUCESS, data));
    }

    // POST /api/auth/logout
    @PostMapping("/logout")
    public ResponseEntity<ApiResponse<Void>> logout(
            @AuthenticationPrincipal UserDetails userDetails) {

        authService.logout(userDetails.getUsername()); // username = email
        return ResponseEntity.ok(ApiResponse.success(Message.LOGOUT_SUCESS));
    }

    // POST /api/auth/refresh
    @PostMapping("/refresh")
    public ResponseEntity<ApiResponse<AuthResponse>> refresh(
            @Valid @RequestBody RefreshTokenRequest request) {

        AuthResponse data = authService.refreshToken(request);
        return ResponseEntity.ok(ApiResponse.success(Message.REFRESH_SUCESS, data));
    }

}
