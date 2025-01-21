package com.project.uber.uberApp.advices;

import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

//    @ExceptionHandler(ConfigDataResourceNotFoundException.class)
//    public ResponseEntity<com.main.project.uber.uberApp.advices.ApiResponse<?>> handleResourceNotFound(ConfigDataResourceNotFoundException exception) {
//        com.codingshuttle.project.uber.uberApp.advices.ApiError apiError = com.codingshuttle.project.uber.uberApp.advices.ApiError.builder()
//                .status(HttpStatus.NOT_FOUND)
//                .message(exception.getMessage())
//                .build();
//        return buildErrorResponseEntity(apiError);
//    }
//
//    @ExceptionHandler(RuntimeConflictException.class)
//    public ResponseEntity<com.codingshuttle.project.uber.uberApp.advices.ApiResponse<?>> handleRuntimeConflictException(RuntimeConflictException exception) {
//        com.codingshuttle.project.uber.uberApp.advices.ApiError apiError = com.codingshuttle.project.uber.uberApp.advices.ApiError.builder()
//                .status(HttpStatus.CONFLICT)
//                .message(exception.getMessage())
//                .build();
//        return buildErrorResponseEntity(apiError);
//    }
//
//
//    @ExceptionHandler(Exception.class)
//    public ResponseEntity<com.codingshuttle.project.uber.uberApp.advices.ApiResponse<?>> handleInternalServerError(Exception exception) {
//        com.codingshuttle.project.uber.uberApp.advices.ApiError apiError = com.codingshuttle.project.uber.uberApp.advices.ApiError.builder()
//                .status(HttpStatus.INTERNAL_SERVER_ERROR)
//                .message(exception.getMessage())
//                .build();
//        return buildErrorResponseEntity(apiError);
//    }
//
//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    public ResponseEntity<com.codingshuttle.project.uber.uberApp.advices.ApiResponse<?>> handleInputValidationErrors(MethodArgumentNotValidException exception) {
//        List<String> errors = exception
//                .getBindingResult()
//                .getAllErrors()
//                .stream()
//                .map(error -> error.getDefaultMessage())
//                .collect(Collectors.toList());
//
//        com.codingshuttle.project.uber.uberApp.advices.ApiError apiError = com.codingshuttle.project.uber.uberApp.advices.ApiError.builder()
//                .status(HttpStatus.BAD_REQUEST)
//                .message("Input validation failed")
//                .subErrors(errors)
//                .build();
//        return buildErrorResponseEntity(apiError);
//    }
//
//    private ResponseEntity<com.codingshuttle.project.uber.uberApp.advices.ApiResponse<?>> buildErrorResponseEntity(com.codingshuttle.project.uber.uberApp.advices.ApiError apiError) {
//        return new ResponseEntity<>(new com.codingshuttle.project.uber.uberApp.advices.ApiResponse<>(apiError), apiError.getStatus());
//    }

}














