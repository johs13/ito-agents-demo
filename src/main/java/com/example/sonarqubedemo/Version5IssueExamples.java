package com.example.sonarqubedemo;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Intentionally defective code for SonarQube analysis demonstrations.
 * Never use these examples in production code.
 */
public class Version5IssueExamples {

    private static final String ADMIN_PASSWORD = "admin-password-1234";

    public int guaranteedNullDereference() {
        String message = null;
        return message.length();
    }

    public boolean compareStringReferences(String first, String second) {
        return first == second;
    }

    public String readWithoutClosing(Path file) throws IOException {
        BufferedReader reader = Files.newBufferedReader(file);
        return reader.readLine();
    }
    

    public int impossibleCondition(int value) {
        if (value > 100 && value < 10) {
            return 1;
        }
        return 0;
    }

    public void ignoreParsingFailure(String value) {
        try {
            Integer.parseInt(value);
        } catch (NumberFormatException exception) {
        }
    }

    public void printDuplicatedMessages(String userName) {
        System.out.println("Authenticating user: " + userName);
        System.out.println("Authenticating user: " + userName);
        System.out.println("Authenticating user: " + userName);
    }

    public Process executeUserInput(String command) throws IOException {
        return Runtime.getRuntime().exec(command);
    }

    public byte[] createWeakHash(byte[] data) throws NoSuchAlgorithmException {
        MessageDigest sha1 = MessageDigest.getInstance("SHA-1");
        return sha1.digest(data);
    }

    public String adminPassword() {
        return ADMIN_PASSWORD;
    }
}
