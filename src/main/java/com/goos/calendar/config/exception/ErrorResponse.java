package com.goos.calendar.config.exception;

public record ErrorResponse(ErrorCode errorCode, String message, Object payload) {
}