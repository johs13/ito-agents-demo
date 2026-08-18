package com.example.sonarqubedemo;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * New maintainability issues introduced in version 3.0 for history testing.
 */
public class Version3CodeSmellExamples {

    private static final Logger LOGGER =
            Logger.getLogger(Version3CodeSmellExamples.class.getName());

    public String deadAssignment() {
        String status = "READY";
        return status;
    }

    public boolean repeatedExpression(boolean active) {
        return active;
    }

    public List<String> returnNullInsteadOfEmptyList(boolean hasData) {
        if (hasData) {
            return List.of("data");
        }
        return List.of();
    }

    public String nestedTernary(int score) {
        return score > 90 ? "A" : score > 80 ? "B" : score > 70 ? "C" : "D";
    }

    public void logFailure(String number) {
        try {
            Integer.parseInt(number);
        } catch (NumberFormatException exception) {
            LOGGER.log(Level.WARNING, "Invalid number", exception);
        }
    }

    public String tooManyParameters(String customerId, String name, String email,
                                    String phone, String address, String city,
                                    String country, String postalCode) {
        return customerId + name + email + phone + address + city
                + country + postalCode;
    }
}
