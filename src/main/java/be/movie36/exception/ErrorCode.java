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

    WRONG_OLD_PASSWORD(400, "Mật khẩu cũ không đúng"),
    PASSWORD_NOT_MATCH(400, "Mật khẩu mới và xác nhận mật khẩu không khớp"),
    SAME_PASSWORD(400, "Mật khẩu mới không được trùng với mật khẩu cũ"),

    INVALID_INPUT(400, "Dữ liệu không hợp lệ"),
    INVALID_GENDER(400, "Gender không hợp lệ, chỉ chấp nhận: MALE, FEMALE, OTHER"),
    INTERNAL_ERROR(500, "Lỗi hệ thống, vui lòng thử lại sau"),

    OTP_INVALID(400, "OTP không hợp lệ"),
    OTP_EXPIRED(400, "OTP đã hết hạn, vui lòng yêu cầu OTP mới"),
    OTP_USED(400, "OTP đã được sử dụng"),
    EMAIL_SEND_FAILED(500, "Gửi email thất bại, vui lòng thử lại");


    private final int status;
    private final String message;
}
