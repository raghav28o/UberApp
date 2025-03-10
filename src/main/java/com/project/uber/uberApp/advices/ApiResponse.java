package com.project.uber.uberApp.advices;

import lombok.Data;
import org.springframework.web.bind.annotation.ControllerAdvice;

import java.time.LocalDateTime;

@Data
@ControllerAdvice
public class ApiResponse<T> {

    //    @JsonFormat(pattern = "hh:mm:ss dd-MM-yyyy")
    private LocalDateTime timeStamp;
    private T data;
    private ApiError error;

    public ApiResponse() {
        this.timeStamp = LocalDateTime.now();
    }

    public ApiResponse(T data) {
        this();
        this.data = data;
    }

    public ApiResponse(ApiError error) {
        this();
        this.error = error;
    }
}
