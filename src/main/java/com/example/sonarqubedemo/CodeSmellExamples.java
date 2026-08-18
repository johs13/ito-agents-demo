package com.example.sonarqubedemo;

/**
 * Contains deliberate maintainability issues for SonarQube demonstrations.
 */
public class CodeSmellExamples {

    private String neverUsedField = "unused";

    public void emptyMethod() {
    }

    public void noisyMethod(String name) {
        int neverUsedLocal = 42;
        System.out.println("Processing customer: " + name);
        System.out.println("Processing customer: " + name);
        System.out.println("Processing customer: " + name);
    }

    public String overlyComplexMethod(int age, boolean active, boolean verified,
                                      boolean premium, boolean hasDebt, int score) {
        String result = "REJECTED";

        if (active) {
            if (verified) {
                if (age >= 18) {
                    if (score > 700) {
                        if (!hasDebt) {
                            if (premium) {
                                result = "PREMIUM_APPROVED";
                            } else {
                                result = "APPROVED";
                            }
                        } else if (score > 800) {
                            result = "MANUAL_REVIEW";
                        }
                    } else if (score > 600) {
                        if (premium && !hasDebt) {
                            result = "MANUAL_REVIEW";
                        }
                    }
                }
            }
        }

        return result;
    }
}
