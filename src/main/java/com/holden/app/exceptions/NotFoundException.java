package com.holden.app.exceptions;

public class NotFoundException extends Exception {
    public NotFoundException(String type, String id) {
        super("Resource of type " + type + " was not found with Id " + id + ".");
    }
}
