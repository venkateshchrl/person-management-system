package com.demo.pms.exceptions;

import lombok.Data;

@Data
public class RecordNotFoundException extends RuntimeException{
    private String code;
    private String message;

    public RecordNotFoundException(String code, String message){
        super();
        this.code = code;
        this.message = message;
    }
}
