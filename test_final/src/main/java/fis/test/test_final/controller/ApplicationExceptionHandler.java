package fis.test.test_final.controller;

import fis.test.test_final.exception.ExceptionMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ApplicationExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ExceptionMessage> handleNotFoundException() {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(ExceptionMessage.builder().code("NOT_FOUND")
                        .message("cannot found")
                        .build());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionMessage> handleErrorException(Exception e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(ExceptionMessage.builder().code("SERVER_ERROR)")
                        .message(e.getMessage()).build());
    }

}
