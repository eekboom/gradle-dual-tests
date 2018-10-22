package de.eekboom.dualtests;

import org.junit.Test;

import static org.junit.Assert.*;

public class JunitTest {
    @Test
    public void testAppHasAGreeting() {
        App classUnderTest = new App();
        assertNotNull("app should have a greeting", classUnderTest.getGreeting());
    }

    @Test
    public void testAppHasNoGreeting() {
        App classUnderTest = new App();
        assertNull("app should not have a greeting", classUnderTest.getGreeting());
    }
}
