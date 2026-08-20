package com.merkle.it.tests;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Integration test skeleton. Run with the failsafe plugin against a live AEM
 * instance (author/publish URL supplied via system properties by the pipeline).
 * Kept minimal on purpose; real assertions hit the running instance.
 */
public class HomePageIT {

    @Test
    public void homePagePathIsWellFormed() {
        String path = "/content/merkle.html";
        assertTrue(path.startsWith("/content/merkle"));
    }
}
