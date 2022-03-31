package com.example.webservice.error;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class Error {
    private String uri;
    private String message;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private Date timestamp;

    public Error() {
        timestamp = new Date();
    }

    public Error(String uri, String message) {
        this();
        this.uri = uri;
        this.message = message;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }
}
