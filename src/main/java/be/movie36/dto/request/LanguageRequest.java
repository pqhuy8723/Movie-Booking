package be.movie36.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class LanguageRequest {
    @NotBlank(message = "Tên ngôn ngữ không được để trống")
    @Size(max = 50, message = "Tên ngon ngữ không quá 50 ký tự")
    private String name;

    private String status;
}
