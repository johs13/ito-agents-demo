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

        // This line cannot be reached because the assignment above does not compile.
        System.out.println(message.length());
    }
}
