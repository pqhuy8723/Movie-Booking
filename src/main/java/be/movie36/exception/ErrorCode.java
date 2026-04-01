package be.movie36.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {

    EMAIL_EXISTED(400, "Email đã được sử dụng"),
    WRONG_CREDENTIALS(401, "Email hoặc mật khẩu không đúng"),
    TOKEN_EXPIRED(401, "Token đã hết hạn, vui lòng đăng nhập lại"),
    TOKEN_INVALID(401, "Token không hợp lệ"),
    TOKEN_REVOKED(401, "Token đã bị thu hồi"),
    UNAUTHORIZED(403, "Không có quyền truy cập"),
    LOGIN_FAILED(401, "Email hoặc mật khẩu không chính xác"),
    USER_NOT_FOUND(404, "Không tìm thấy người dùng"),

    INVALID_INPUT(400, "Dữ liệu không hợp lệ"),
    INVALID_GENDER(400, "Gender không hợp lệ, chỉ chấp nhận: MALE, FEMALE, OTHER"),
    INTERNAL_ERROR(500, "Lỗi hệ thống, vui lòng thử lại sau");

    private final int status;
    private final String message;
}
