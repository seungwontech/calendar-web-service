package com.goos.calendar.config.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.logging.LogLevel;

@Getter
@RequiredArgsConstructor
public enum ErrorType {
    BOARD_NOT_FOUND(ErrorCode.NOT_FOUND, "잔액을 찾을 수 없습니다.", LogLevel.WARN);

    private final ErrorCode errorCode;
    private final String message;
    private final LogLevel logLevel;

    public ErrorCode getErrorCode() {
        return errorCode;
    }

    public String getMessage() {
        return message;
    }

    public LogLevel getLogLevel() {
        return logLevel;
    }
}
