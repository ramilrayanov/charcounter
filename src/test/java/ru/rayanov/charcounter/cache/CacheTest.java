package ru.rayanov.charcounter.cache;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class CacheTest {
    private static String helloWorldKey = "Hello World!";
    private static String helloWorldValue = "\"h\"-\"1\n"
                                          + "\"e\"-\"1\n"
                                          + "\"l\"-\"3\n"
                                          + "\"o\"-\"2\n"
                                          + "\" \"-\"1\n"
                                          + "\"w\"-\"1\n"
                                          + "\"r\"-\"1\n"
                                          + "\"d\"-\"1\n"
                                          + "\"!\"-\"1\n";
    
    private static String anotherStringKey = "I like tomatoes";
    private static String anotherStringValue = "\"i\"-\"2\r\n"
                                             + "\" \"-\"2\r\n"
                                             + "\"l\"-\"1\r\n"
                                             + "\"k\"-\"1\r\n"
                                             + "\"e\"-\"2\r\n"
                                             + "\"t\"-\"2\r\n"
                                             + "\"o\"-\"2\r\n"
                                             + "\"m\"-\"1\r\n"
                                             + "\"a\"-\"1\r\n"
                                             + "\"s\"-\"1";

    private Map<String, String> cacheMap;
    private Cache cache;

    @BeforeEach
    void setUp() {
        cache = new Cache();
        cacheMap = new HashMap<>();
        cacheMap.put(helloWorldKey, helloWorldValue);
        cache.put(helloWorldKey, helloWorldValue);
    }

    @Test
    void getShouldReturnValueFromCache() {
        assertEquals(helloWorldValue, cache.get(helloWorldKey));
    }

    @Test
    void shouldReturnNullWhenPutNewPair() {
        assertNull(cache.put(anotherStringKey, anotherStringValue));
    }

    @Test
    void isPresentShouldReturnTrueWhenTheKeyIsPresent() {
        assertTrue(cache.isPresent(helloWorldKey));
    }

    @Test
    void isPresentShouldReturnFalseWhenTheKeyIsNotPresent() {
        assertFalse(cache.isPresent(anotherStringKey));
    }
}
