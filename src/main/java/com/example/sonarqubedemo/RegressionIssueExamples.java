package com.example.sonarqubedemo;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

/**
 * Issues added in version 2.0 to demonstrate SonarQube analysis history.
 * This class is intentionally defective and must not be used in production.
 */
public class RegressionIssueExamples {

    public boolean compareNames(String firstName, String secondName) {
        return firstName == secondName;
    }

    public String readFirstLine(Path file) throws IOException {
        BufferedReader reader = Files.newBufferedReader(file);
        return reader.readLine();
    }

    public void runWorkerOnWrongThread() {
        Thread worker = new Thread(() -> System.out.println("background work"));
        worker.run();
    }

    public void silentlyIgnoreFailure(String value) {
        try {
            Integer.parseInt(value);
        } catch (NumberFormatException exception) {
        }
    }

    @SuppressWarnings("rawtypes")
    public List createRawList() {
        List values = new ArrayList();
        values.add("unsafe value");
        return values;
    }

    public String duplicatedBranches(boolean administrator) {
        if (administrator) {
            return "ACCESS_GRANTED";
        } else {
            return "ACCESS_GRANTED";
        }
    }

    public int impossibleCondition(int value) {
        if (value > 100 && value < 10) {
            return 1;
        }
        return 0;
    }
}
