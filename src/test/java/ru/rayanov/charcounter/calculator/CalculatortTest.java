package ru.rayanov.charcounter.calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CalculatortTest {
    private static final String EMPTYSTRINGMESSAGE = "The string cannot be empty";
    private static final String NULLSTRINGMESSAGE = "The string cannot be null";
    private static final String EMPTYSTRING = "";
    private static final String NULLSTRING = null;

    private Calculator calculator;
    private Map<Character, Integer> helloWorldExcpectedMap;
    private static String helloWorldString = "Hello world!";

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
        helloWorldExcpectedMap = new LinkedHashMap<>();
        helloWorldExcpectedMap.put('h', 1);
        helloWorldExcpectedMap.put('e', 1);
        helloWorldExcpectedMap.put('l', 3);
        helloWorldExcpectedMap.put('o', 2);
        helloWorldExcpectedMap.put(' ', 1);
        helloWorldExcpectedMap.put('w', 1);
        helloWorldExcpectedMap.put('r', 1);
        helloWorldExcpectedMap.put('d', 1);
        helloWorldExcpectedMap.put('!', 1);
    }

    @Test
    void shouldReturnsTheNumberOfUniqueCharactersInTheString() {
        assertEquals(helloWorldExcpectedMap, calculator.getNumberOfUniqueCharacters(helloWorldString));
    }

    @Test
    void TestCalculatorWithEmptyString() {
        IllegalArgumentException countCharIAE = assertThrows(IllegalArgumentException.class,
                () -> calculator.getNumberOfUniqueCharacters(EMPTYSTRING));
        assertEquals(EMPTYSTRINGMESSAGE, countCharIAE.getMessage());
    }

    @Test
    void TestCalculatorWithNullString() {
        IllegalArgumentException countCharIAE = assertThrows(IllegalArgumentException.class,
                () -> calculator.getNumberOfUniqueCharacters(NULLSTRING));
        assertEquals(NULLSTRINGMESSAGE, countCharIAE.getMessage());
    }

}
