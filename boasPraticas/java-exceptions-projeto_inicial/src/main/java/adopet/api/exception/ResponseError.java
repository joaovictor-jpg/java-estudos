package adopet.api.exception;

import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

public record ResponseError(
        String message, HttpStatus status, LocalDateTime date
) {
    public ResponseError(String message, HttpStatus status, LocalDateTime date) {
        this.message = message;
        this.status = status;
        this.date = date;
    }
}
