package com.goos.calendar.config.exception;

public enum ErrorCode {
    NOT_FOUND("404: 리소스를 찾을 수 없음"),
    DB_ERROR("500: 데이터베이스 오류 발생"),
    CLIENT_ERROR("400: 클라이언트 요청 오류");

    private final String desc;

    ErrorCode(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }
}