package com.shop.core.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseBody
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BackRequestException extends RuntimeException {
    public BackRequestException(String message) {
        super(message);
    }

    public String getMessage() {
        return super.getMessage();
    }
}
