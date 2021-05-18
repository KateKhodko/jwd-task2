package com.epam.jwd;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class AppTest {

    @Test
    void start() {
        assertDoesNotThrow(() -> {
            App app = new App();
            app.start();
        });
    }
}