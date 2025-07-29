package com.tuandev.app.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<Object> handleRuntimeException(RuntimeException e){
        Map<String, Object> body = new HashMap<>();
        body.put("message", e.getMessage());
        return new ResponseEntity<>(body, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler
    public ResponseEntity<Object> handleValidationException(MethodArgumentNotValidException e){
        Map<String, String> body = new HashMap<>();
        e.getBindingResult().getFieldErrors().forEach(
                err -> body.put(err.getField(), err.getDefaultMessage())
        );
        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
    }
}
