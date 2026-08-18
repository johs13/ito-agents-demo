package com.example.sonarqubedemo;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

/**
 * Contains deliberately unsafe patterns for SonarQube demonstrations only.
 */
public class SecurityExamples {

    private static final String DATABASE_PASSWORD = "admin1234";

    public ResultSet findUser(Connection connection, String userName) throws SQLException {
        Statement statement = connection.createStatement();
        String sql = "SELECT * FROM users WHERE username = '" + userName + "'";
        return statement.executeQuery(sql);
    }

    public byte[] weakPasswordHash(String password)
            throws NoSuchAlgorithmException {
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        return md5.digest(password.getBytes(StandardCharsets.UTF_8));
    }

    public String insecureResetToken() {
        Random random = new Random();
        return Long.toHexString(random.nextLong());
    }

    public String readArbitraryFile(String fileName) throws IOException {
        return Files.readString(Path.of(fileName));
    }

    public String databasePassword() {
        return DATABASE_PASSWORD;
    }
}
