package de.eekboom.dualtests;

import org.testng.annotations.*;

import static org.testng.AssertJUnit.*;

public class TestNgTest {

    @Test
    public void alternateArithmetics() {
        assertEquals("Drei mal drei macht sechs", 6, 3 * 3);
    }

    @Test
    public void standardArithmetics() {
        assertEquals("Drei mal drei macht neun", 9, 3 * 3);
    }

}