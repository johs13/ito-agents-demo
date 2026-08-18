package com.example.sonarqubedemo;

import java.util.List;
import java.util.Optional;

/**
 * New bugs and code smells introduced in version 4.0 for PR analysis testing.
 * Every defect in this class is intentional.
 */
public class Version4IssueExamples {

    public int dereferenceOnlyWhenNull(String value) {
        if (value == null) {
            return value.length();
        }
        return 0;
    }

    public int divideByCalculatedZero(int value) {
        int divisor = value - value;
        return value / divisor;
    }

    public String optionalValueWithoutCheck(Optional<String> value) {
        return value.get();
    }

    public void removeWhileIterating(List<String> names) {
        for (String name : names) {
            if (name.isBlank()) {
                names.remove(name);
            }
        }
    }

    public boolean equals(Version4IssueExamples other) {
        return other != null;
    }

    public void synchronizeOnSharedString(Runnable task) {
        synchronized ("GLOBAL_LOCK") {
            task.run();
        }
    }
}
