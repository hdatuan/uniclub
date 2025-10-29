package com.hdatuan.uniclub.exceptions;

import com.hdatuan.uniclub.response.BaseResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CentralException {

    @ExceptionHandler(exception = {RuntimeException.class})
    public ResponseEntity<?> handleExcepion(RuntimeException e){

        BaseResponse response = new BaseResponse();
        response.setCode(500);
        response.setMessage(e.getMessage());

        return ResponseEntity.ok(response);
    }

    @ExceptionHandler(exception = {InsertUpdateException.class})
    public ResponseEntity<?> handleInsertExcepion(InsertUpdateException e){

        BaseResponse response = new BaseResponse();
        response.setCode(400);
        response.setMessage(e.getMessage());

        return ResponseEntity.ok(response);
    }
}
