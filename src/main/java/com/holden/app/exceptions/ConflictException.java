package com.holden.app.exceptions;

public class ConflictException extends Exception {
    public ConflictException(String type, String id) {
        super("Resource of type " + type + " already exists with Id " + id + ".");
    }
}
