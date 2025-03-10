package com.project.uber.uberApp.advices;

import org.springframework.core.MethodParameter;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.util.List;

@RestControllerAdvice
public class GlobalResponseHandler implements ResponseBodyAdvice<Object> {
    @Override
    public boolean supports(MethodParameter returnType, Class converterType) {
        // Only wrap responses if they are not already wrapped in ApiResponse
        return !returnType.getParameterType().equals(ApiResponse.class);
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, org.springframework.http.MediaType contentType,
                                  Class converterType, org.springframework.http.server.ServerHttpRequest request,
                                  org.springframework.http.server.ServerHttpResponse response) {

        // If body is null (like empty responses), return an empty ApiResponse
        if (body == null) {
            return new ApiResponse<>(null);
        }

        // If response is already an instance of ResponseEntity, extract body and status
        if (body instanceof ResponseEntity) {
            ResponseEntity<?> responseEntity = (ResponseEntity<?>) body;
            Object responseBody = responseEntity.getBody();
            HttpStatus status = (HttpStatus) responseEntity.getStatusCode();

            return new ResponseEntity<>(new ApiResponse<>(responseBody), status);
        }

        // Otherwise, wrap the response in ApiResponse
        return new ApiResponse<>(body);
    }

//    @Override
//    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
//        return true;
//    }
//
//    @Override
//    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
//        if(body instanceof com.codingshuttle.project.uber.uberApp.advices.ApiResponse<?>) {
//            return body;
//        }
//
//        return new com.codingshuttle.project.uber.uberApp.advices.ApiResponse<>(body);
//    }
}
