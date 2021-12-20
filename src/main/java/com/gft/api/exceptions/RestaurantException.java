package com.gft.api.exceptions;

public class RestaurantException extends RuntimeException {

    private String message;

    public RestaurantException(String message) {
        super(message);
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
