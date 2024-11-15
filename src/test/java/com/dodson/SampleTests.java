package com.dodson;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class SampleTests {

    @Test
    void successfulTest() {
        Assertions.assertTrue(true);
    }

    @Test
    void failedTest() {
        Assertions.fail("This test is designed to fail");
    }

    @Test
    @Disabled("Disabled for demonstration purposes")
    void skippedTest() {
        Assertions.assertTrue(true);
    }
}
