package com.labo.prueba.controllers;

import com.labo.prueba.exception.BadRequestException;
import com.labo.prueba.exception.ErrorMessage;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ExceptionHandlerController {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({BadRequestException.class,
            org.springframework.web.bind.MethodArgumentNotValidException.class,
            org.springframework.web.bind.MissingRequestHeaderException.class,
            org.springframework.web.bind.MissingServletRequestParameterException.class,
            org.springframework.web.method.annotation.MethodArgumentTypeMismatchException.class,
            org.springframework.http.converter.HttpMessageNotReadableException.class})
    @ResponseBody

    public ErrorMessage handleBadRequestException(HttpServletRequest request, Exception exception) {
        return ErrorMessage.builder()
                .httpStatus(HttpStatus.BAD_REQUEST)
                .errorText(exception.getMessage())
                .requestURL(request.getRequestURL().toString())
                .build();
    }
}
