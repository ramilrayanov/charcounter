package ru.rayanov.charcounter.formatter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FormatterTest {
    private static String helloWorldExcpectedResult = "\"h\"-\"1\n"
            + "\"e\"-\"1\n"
            + "\"l\"-\"3\n"
            + "\"o\"-\"2\n"
            + "\" \"-\"1\n"
            + "\"w\"-\"1\n"
            + "\"r\"-\"1\n"
            + "\"d\"-\"1\n"
            + "\"!\"-\"1\n";

    private Formatter formatter;
    private Map<Character, Integer> helloWorldMap;

    private void setUpMap() {
        helloWorldMap = new LinkedHashMap<>();
        helloWorldMap.put('h', 1);
        helloWorldMap.put('e', 1);
        helloWorldMap.put('l', 3);
        helloWorldMap.put('o', 2);
        helloWorldMap.put(' ', 1);
        helloWorldMap.put('w', 1);
        helloWorldMap.put('r', 1);
        helloWorldMap.put('d', 1);
        helloWorldMap.put('!', 1);
    }

    @BeforeEach
    void setUp() {
        formatter = new Formatter();
        setUpMap();
    }

    @Test
    void сountingCharactersFormattingTest() {
        assertEquals(helloWorldExcpectedResult, formatter.getCountingCharactersString(helloWorldMap));
    }
}
