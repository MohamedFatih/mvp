package com.example.springboot.jwt.controller.Advisor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.springboot.jwt.controller.Advisor.Response.ErrorResponse;

import java.io.PrintWriter;
import java.io.StringWriter;

@ControllerAdvice
public class ControllerAdvisor {

    @ExceptionHandler(NullPointerException.class) // exception handled
    public ResponseEntity<ErrorResponse> handleNullPointerExceptions(
        Exception e
    ) {
        HttpStatus status = HttpStatus.NOT_FOUND; // 404

        return new ResponseEntity<>(
            new ErrorResponse(
              status, 
              e.getMessage()
            ),
            status
        );
    }
    
    @ExceptionHandler(Exception.class) // exception handled
    public ResponseEntity<ErrorResponse> handleExceptions(
        Exception e
    ) {
        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR; // 500

    // converting the stack trace to String
    StringWriter stringWriter = new StringWriter();
    PrintWriter printWriter = new PrintWriter(stringWriter);
    e.printStackTrace(printWriter);
    String stackTrace = stringWriter.toString();

        return new ResponseEntity<>(
            new ErrorResponse(
              status, 
              e.getMessage(), 
              stackTrace // specifying the stack trace in case of 500s
            ),
            status
        );
    }
    
    @ExceptionHandler({ AccessDeniedException.class })
    public ResponseEntity<ErrorResponse> handleAccessDeniedException(
      Exception ex) {
        HttpStatus status = HttpStatus.FORBIDDEN; // 403
        
        return new ResponseEntity<>(
            new ErrorResponse(
              status, 
              ex.getMessage()
            ),
            status
        );

    }

}