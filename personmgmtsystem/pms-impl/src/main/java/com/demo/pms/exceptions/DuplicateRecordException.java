package com.demo.pms.exceptions;

import lombok.Data;

@Data
public class DuplicateRecordException extends RuntimeException{
    private String code;
    private String message;

    public DuplicateRecordException(String code, String message){
        super();
        this.code = code;
        this.message = message;
    }
}
