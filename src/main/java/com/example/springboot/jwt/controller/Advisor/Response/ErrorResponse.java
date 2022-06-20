package com.example.springboot.jwt.controller.Advisor.Response;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.http.HttpStatus;
import java.util.Date;

public class ErrorResponse {
    // customizing timestamp serialization format
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private Date timestamp;

    private int code;

    private String status;

    private String message;

    private String stackTrace;

    private Object data;

    public ErrorResponse() {
        timestamp = new Date();
    }

    public ErrorResponse(
            HttpStatus httpStatus,
            String message
    ) {
        this();
    
        this.code = httpStatus.value();
        this.status = httpStatus.name();
        this.message = message;
    }

    public ErrorResponse(
            HttpStatus httpStatus,
            String message,
            String stackTrace
    ) {
        this(
                httpStatus,
                message        
        );

        this.stackTrace = stackTrace;
    }

    public ErrorResponse(
            HttpStatus httpStatus,
            String message,
        String stackTrace,
            Object data
    ) {
        this(
                httpStatus,
                message,
        stackTrace
        );

        this.data = data;
    }

    /**
     * @return Date return the timestamp
     */
    public Date getTimestamp() {
        return timestamp;
    }

    /**
     * @param timestamp the timestamp to set
     */
    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    /**
     * @return int return the code
     */
    public int getCode() {
        return code;
    }

    /**
     * @param code the code to set
     */
    public void setCode(int code) {
        this.code = code;
    }

    /**
     * @return String return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * @return String return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * @param message the message to set
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * @return String return the stackTrace
     */
    public String getStackTrace() {
        return stackTrace;
    }

    /**
     * @param stackTrace the stackTrace to set
     */
    public void setStackTrace(String stackTrace) {
        this.stackTrace = stackTrace;
    }

    /**
     * @return Object return the data
     */
    public Object getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(Object data) {
        this.data = data;
    }

}