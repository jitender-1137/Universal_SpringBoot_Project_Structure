package com.springboot.universal.dto;

import java.util.Collections;
import java.util.List;

import org.slf4j.MDC;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorResponseDto<T> implements ResponseDto<T> {

    private String code = "";
    private T data;
    private List<String> message;
    private long timestamp;
    protected String requestId;

    public ErrorResponseDto() {
    }

    public ErrorResponseDto(String errorMessage) {

        this.message = Collections.singletonList(errorMessage);
        this.timestamp = System.currentTimeMillis();
        this.requestId = MDC.get("requestId");
    }

    public ErrorResponseDto(String errorCode, String errorMessage) {
        this.code = errorCode;
        this.message = Collections.singletonList(errorMessage);
        this.timestamp = System.currentTimeMillis();
        this.requestId = MDC.get("requestId");
    }

    public ErrorResponseDto(String errorCode, String errorMessage, T data) {
        this.data = data;
        this.code = errorCode;
        this.message = Collections.singletonList(errorMessage);
        this.requestId = MDC.get("requestId");
        this.timestamp = System.currentTimeMillis();
    }

    public ErrorResponseDto(String errorCode, List<String> errorMessage) {
        this.code = errorCode;
        this.message = errorMessage;
        this.timestamp = System.currentTimeMillis();
        this.requestId = MDC.get("requestId");
    }

    public ErrorResponseDto(List<String> errorMessage) {
        this.code = "400";
        this.message = errorMessage;
        this.timestamp = System.currentTimeMillis();
        this.requestId = MDC.get("requestId");
    }
}
