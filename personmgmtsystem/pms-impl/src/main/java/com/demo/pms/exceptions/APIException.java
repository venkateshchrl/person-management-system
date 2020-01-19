package com.demo.pms.exceptions;

import lombok.Data;

@Data
public class APIException extends RuntimeException{
    private String code;
    private String message;

    public APIException(String code, String message){
        super();
        this.code = code;
        this.message = message;
    }
}
