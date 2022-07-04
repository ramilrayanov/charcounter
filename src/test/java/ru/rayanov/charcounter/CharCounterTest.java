package ru.rayanov.charcounter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.rayanov.charcounter.cache.Cache;
import ru.rayanov.charcounter.calculator.Calculator;
import ru.rayanov.charcounter.formatter.Formatter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CharCounterTest {
    private static final String EMPTYSTRINGMESSAGE = "The string cannot be empty";
    private static final String NULLSTRINGMESSAGE = "The string cannot be null";
    private static final String EMPTYSTRING = "";
    private static final String NULLSTRING = null;

    private static String helloWorldActualString = "Hello World!";
    private static String helloWorldExpectedString = "\"h\"-\"1\n"
            + "\"e\"-\"1\n"
            + "\"l\"-\"3\n"
            + "\"o\"-\"2\n"
            + "\" \"-\"1\n"
            + "\"w\"-\"1\n"
            + "\"r\"-\"1\n"
            + "\"d\"-\"1\n"
            + "\"!\"-\"1\n";

    CharCounter charCounter;
    Calculator calculator;
    Formatter formatter;

    @BeforeEach
    void setUp() {
        Calculator calculator = new Calculator();
        Formatter formatter = new Formatter();
        Cache cache = new Cache();
        charCounter = new CharCounter(calculator, formatter, cache);
    }

    @Test
    void TestCharCounterWithHelloWorldString() {
        assertEquals(helloWorldExpectedString, charCounter.countChar(helloWorldActualString));
    }

    @Test
    void TestCharCounterWithEmptyString() {
        IllegalArgumentException countCharIAE = assertThrows(IllegalArgumentException.class,
                () -> charCounter.countChar(EMPTYSTRING));
        assertEquals(EMPTYSTRINGMESSAGE, countCharIAE.getMessage());
    }

    @Test
    void TestCharCounterWithNullString() {
        IllegalArgumentException countCharIAE = assertThrows(IllegalArgumentException.class,
                () -> charCounter.countChar(NULLSTRING));
        assertEquals(NULLSTRINGMESSAGE, countCharIAE.getMessage());
    }
}
