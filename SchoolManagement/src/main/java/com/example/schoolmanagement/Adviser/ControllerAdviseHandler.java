package com.example.schoolmanagement.Adviser;

import com.example.schoolmanagement.DTO.API;
import com.example.schoolmanagement.controller.ClassroomController;
import com.example.schoolmanagement.exceptions.InvalidIdException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerAdviseHandler {
    Logger logger= LoggerFactory.getLogger(ControllerAdviseHandler.class);
    @ExceptionHandler(value = InvalidIdException.class)
    public ResponseEntity<API> handleDataIntegrity(InvalidIdException invalidIDException){
        String message=invalidIDException.getMessage();
        logger.info(message);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new API(message,400));
    }


    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<API> handleException(Exception exception){
       // System.out.println(exception.getMessage());
        logger.error(exception.getCause().toString());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new API("SERVER ERROR pleas try again later !",500));
    }
}
