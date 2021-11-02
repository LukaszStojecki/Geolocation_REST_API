package pl.stojeckilukasz.geolocation.error;

import java.time.LocalDateTime;

public class ErrorDetails {

    private String reason;
    private LocalDateTime time = LocalDateTime.now();

    public ErrorDetails(String reason) {
        this.reason = reason;
    }

    public String getReason() {
        return reason;
    }

    public LocalDateTime getTime() {
        return time;
    }
}

