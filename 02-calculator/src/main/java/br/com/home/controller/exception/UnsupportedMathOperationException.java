package br.com.home.controller.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class UnsupportedMathOperationException extends RuntimeException {

    public UnsupportedMathOperationException(String message) {
        super(message);
    }
}
