package com;

import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Date;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@ResponseStatus(value = BAD_REQUEST)
public class BadRequestException extends ErrorResponse {

    public BadRequestException() {
        this("Bad Request Exception!");
    }

    public BadRequestException(String message) {
        this("Unauthorized", message);
    }

    public BadRequestException(String error, String message) {
        super(new Date(),400,error,"BadRequestException",message,null);
        setException(getClass().getName());
    }

}
