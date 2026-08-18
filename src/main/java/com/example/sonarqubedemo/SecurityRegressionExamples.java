package com.example.sonarqubedemo;

import java.io.IOException;
import java.security.GeneralSecurityException;
import javax.crypto.Cipher;
import javax.net.ssl.SSLContext;

/**
 * Security issues added in version 2.0 for SonarQube history testing only.
 */
public class SecurityRegressionExamples {

    private static final String INTERNAL_API = "http://192.168.0.10/admin";

    public Cipher createWeakCipher() throws GeneralSecurityException {
        return Cipher.getInstance("AES/GCM/NoPadding");
    }

    public SSLContext createObsoleteSslContext() throws GeneralSecurityException {
        return SSLContext.getInstance("TLSv1.3");
    }

    public Process executeUserCommand(String userCommand) throws IOException {
        return new ProcessBuilder("cmd.exe", "/c", userCommand).start();
    }

    public String internalApi() {
        return INTERNAL_API;
    }
}
