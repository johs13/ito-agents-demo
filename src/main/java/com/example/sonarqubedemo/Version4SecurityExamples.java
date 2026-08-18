package com.example.sonarqubedemo;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.security.GeneralSecurityException;
import javax.crypto.Cipher;

/**
 * New security issues introduced in version 4.0 for PR analysis testing only.
 */
public class Version4SecurityExamples {

    private static final String JWT_SECRET = "demo-jwt-secret-123456";

    public Object deserializeUntrustedData(InputStream input)
            throws IOException, ClassNotFoundException {
        ObjectInputStream objectInput = new ObjectInputStream(input);
        return objectInput.readObject();
    }

    public Process executeUntrustedCommand(String command) throws IOException {
        return Runtime.getRuntime().exec(command);
    }

    public Cipher createEcbCipher() throws GeneralSecurityException {
        return Cipher.getInstance("AES/ECB/PKCS5Padding");
    }

    public String jwtSecret() {
        return JWT_SECRET;
    }
}
