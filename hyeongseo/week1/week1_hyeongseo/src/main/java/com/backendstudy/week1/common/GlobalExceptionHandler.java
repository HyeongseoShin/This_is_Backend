package com.backendstudy.week1.common;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

// Validation 실패를 처리하기 위한 글로벌 예외 처리 코드

@RestControllerAdvice // 모든 Controller에서 발생하는 예외를 전역적으로 처리함
public class GlobalExceptionHandler {

    // Validation (@Valid) 오류 처리
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleValidation(MethodArgumentNotValidException e) {
        List<ApiError> errors = e.getBindingResult().getFieldErrors()
                .stream()
                .map(fieldError -> ApiError.builder()
                        .field(fieldError.getField())
                        .rejectedValue(String.valueOf(fieldError.getRejectedValue()))
                        .reason(fieldError.getDefaultMessage()) // getDefaultMessage() : MemberResDTO의 필드 값의 어노테이션에 설정한 메시지 출력
                        .build())
                .toList();

        return ResponseEntity.badRequest()
                .body(ApiResponse.fail(
                        400,
                        "유효성 검증 실패",
                        errors
                ));
    }
}
