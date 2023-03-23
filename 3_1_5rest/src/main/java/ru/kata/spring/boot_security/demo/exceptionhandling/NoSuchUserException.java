package ru.kata.spring.boot_security.demo.exceptionhandling;

public class NoSuchUserException extends RuntimeException {

    public NoSuchUserException(String message) {
        super(message);
    }
}