package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AppTest {

    @Test
    void testAdd() {
        int result = App.add(2, 3);
        assertEquals(5, result, "2 + 3 should equal 5");
    }

    @Test
    void testAddNegative() {
        int result = App.add(-1, -4);
        assertEquals(-5, result, "-1 + -4 should equal -5");
    }
}

