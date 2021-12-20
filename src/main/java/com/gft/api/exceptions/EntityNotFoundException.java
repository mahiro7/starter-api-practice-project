package com.gft.api.exceptions;

public class EntityNotFoundException extends RestaurantException {
    public EntityNotFoundException(String message) {
        super(message);
    }
}
