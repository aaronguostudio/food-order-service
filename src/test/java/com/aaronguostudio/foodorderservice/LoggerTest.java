package com.aaronguostudio.foodorderservice;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class LoggerTest {

    private final Logger logger = LoggerFactory.getLogger(LoggerTest.class);

    @Test
    public void test () {
        logger.debug("Debug: {}, {}", 1, 2);
        logger.info("Info {}, {}", "a", "b");
        logger.error("Error");
    }
}
