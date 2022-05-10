package br.com.home.controller.exception;

import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@RestController
@ControllerAdvice
@Slf4j
public class ResponseExceptionHandler extends ResponseEntityExceptionHandler {

    /**
     * Handle all exceptions
     */
    @ExceptionHandler(Exception.class)
    public final ResponseEntity<MathResponseException> handleAllExceptions(Exception ex, WebRequest request) {
        return new ResponseEntity<>(new MathResponseException(LocalDateTime.now(),
                ex.getLocalizedMessage(),
                ex.getMessage()),
                HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(UnsupportedMathOperationException.class)
    public final ResponseEntity<MathResponseException> handleBadRequestExceptions(Exception ex, WebRequest request) {
        log.info(ex.getMessage());
        return new ResponseEntity<>(new MathResponseException(LocalDateTime.now(),
                ex.getLocalizedMessage(),
                ex.getMessage()),
                HttpStatus.BAD_REQUEST);
    }


}
