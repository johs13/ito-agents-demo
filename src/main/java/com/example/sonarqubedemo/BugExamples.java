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

    // ---- Compile-time error examples (javac build fails) ----

    public void missingSemicolon() {
        String text = "missing semicolon"
        System.out.println(text);
    }

    public int undefinedVariable() {
        return undefinedValue + 1;
    }

    public int typeMismatch() {
        return "not an int";
    }

    public int missingReturn(int value) {
        if (value > 0) {
            return value;
        }
    }
}
