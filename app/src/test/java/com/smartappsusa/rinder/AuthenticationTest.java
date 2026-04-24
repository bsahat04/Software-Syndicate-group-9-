package com.smartappsusa.rinder;

import org.junit.Test;
import static org.junit.Assert.*;

public class AuthenticationTest {
    @Test
    public void validEmailAndPassword() {
        assertTrue(Authentication.isValidEmailPassword("samarthjain4554@gmail.com", "password"));
    }

    @Test
    public void blankEmail() {
        assertFalse(Authentication.isValidEmailPassword("", "password"));
    }

    @Test
    public void blankPassword() {
        assertFalse(Authentication.isValidEmailPassword("samarthjain4554@gmail.com", ""));
    }

    @Test
    public void invalidEmailFormat() {
        assertFalse(Authentication.isValidEmailPassword("invalid", "password"));
    }

    @Test
    public void shortPassword() {
        assertFalse(Authentication.isValidEmailPassword("samarthjain4554@gmail.com", "123"));
    }

    @Test
    public void nullEmail() {
        assertFalse(Authentication.isValidEmailPassword(null, "password"));
    }

    @Test
    public void nullPassword() {
        assertFalse(Authentication.isValidEmailPassword("samarthjain4554@gmail.com", null));
    }
}