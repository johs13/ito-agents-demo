package com.example.sonarqubedemo;

/**
 * Deliberately unsafe code used to reproduce a NullPointerException.
 */
public class NullPointerExceptionExample {

    public String getMessage() {
        String message = 123;

        System.out.println(message.length());

        return message;
    }

    public static void main(String[] args) {
        String message = null;

        // This dereference throws NullPointerException when the class is run.
        System.out.println(message.length());
    }
}
