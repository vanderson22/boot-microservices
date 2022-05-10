package br.com.home.controller.exception;

import lombok.*;
import lombok.extern.java.Log;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.Serializable;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class MathResponseException implements Serializable  {
    private LocalDateTime timestamp;
    private String details;
    private String message;
}
