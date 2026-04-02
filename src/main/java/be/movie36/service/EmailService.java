package be.movie36.service;

import be.movie36.exception.AppException;
import be.movie36.exception.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailService {
    private final JavaMailSender mailSender;

    @Value("${spring.mail.username}")
    private String fromEmail;

    public void sendOtpEmail(String toEmail, String otp) {
        try {

            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom(fromEmail);
            message.setTo(toEmail);
            message.setSubject("[Movie36] Mã OTP đặt lại mật khẩu");
            message.setText(
                    "Xin chào!\n\n" +
                            "Mã OTP của bạn là: " + otp + "\n\n" +
                            "Mã có hiệu lực trong 10 phút.\n" +
                            "Nếu bạn không yêu cầu đặt lại mật khẩu, hãy bỏ qua email này.\n\n" +
                            "Movie36 Team");
            mailSender.send(message);
        } catch (Exception e) {
            throw new AppException(ErrorCode.EMAIL_SEND_FAILED);
        }
    }
}
