package com.smartappsusa.rinder;

public class Authentication {
    public static boolean isValidEmailPassword(String email, String password) {
        return email != null
                && password != null
                && !email.isBlank()
                && !password.isBlank()
                && email.contains("@")
                && email.contains(".")
                && password.length() >= 5;
    }
}