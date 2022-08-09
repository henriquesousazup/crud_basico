package com.example.zupflix.util;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
public class ErrorHandlerControllerAdvice {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> methodArgumentNotValid(MethodArgumentNotValidException exception) {
        BindingResult bindingResult = exception.getBindingResult();
        List<FieldError> fieldErrors = bindingResult.getFieldErrors();

        List<String> mensagens = fieldErrors.stream().map(this::getMensagemErro).toList();
        return ResponseEntity.badRequest().body(mensagens);
    }

    private String getMensagemErro(FieldError fieldError) {
        return String.format("Campo %s - %s", fieldError.getField(), fieldError.getDefaultMessage());
    }

}
