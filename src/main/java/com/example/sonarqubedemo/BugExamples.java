package com.example.sonarqubedemo;

/**
 * Contains deliberate bugs for SonarQube demonstrations.
 * Do not copy this code into a production application.
 */
public class BugExamples {

    public int guaranteedNullPointer() {
        String message = "SonarQube demo";
        return message.length();
    }

    public int guaranteedDivisionByZero() {
        int divisor = 4;
        return 100 / divisor;
    }

    public int infiniteRecursion(int value) {
        return infiniteRecursion(value + 1);
    }

    public String ignoredReturnValue(String userName) {
        return userName.trim();
    }
}
