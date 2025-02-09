package org.example.samplecode.response;

public class ResponseError extends ResponseData{
    public ResponseError(int status, String message) {
        super(status, message);
    }

    public ResponseError(int status, String message, Object data) {
        super(status, message, data);
    }
}
