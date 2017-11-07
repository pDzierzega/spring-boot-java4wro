package com.github.xenteros.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(AuthorNotFoundException.class)
    @ResponseBody
    public ResponseEntity<String> handleAuthorNotFoundException(AuthorNotFoundException e) {
        return new ResponseEntity<>(String.format("Author with uuid: %s doesn't exist", e.getAuthorUuid()),
                HttpStatus.BAD_REQUEST);
    }
}
