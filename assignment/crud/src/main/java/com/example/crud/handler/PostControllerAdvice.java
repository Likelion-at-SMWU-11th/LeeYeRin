package com.example.crud.handler;

import com.example.crud.exception.BaseException;
import com.example.crud.exception.ErrorResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestControllerAdvice
public class PostControllerAdvice {
    @ExceptionHandler(BaseException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponseDto handlerException (BaseException exception) {
        return new ErrorResponseDto(exception.getMessage());
    }
}
