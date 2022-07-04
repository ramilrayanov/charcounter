package ru.rayanov.charcounter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.rayanov.charcounter.cache.Cache;
import ru.rayanov.charcounter.calculator.Calculator;
import ru.rayanov.charcounter.formatter.Formatter;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class CharCounterCallsTests {
    private String helloWorldString = "Hello World!";
    private String secondString = "I like tomatoes";
    private Calculator calculator;
    private Formatter formatter;
    private CharCounter charCounter;
    private Cache cache;
    private Cache cacheMock;

    @BeforeEach
    void setUp() {
        calculator = mock(Calculator.class);
        formatter = mock(Formatter.class);
        cache = new Cache();
        charCounter = new CharCounter(calculator, formatter, cache);
        charCounter.countChar(helloWorldString);
    }

    @Test
    void СalculatorСall() {
        verify(calculator, times(1)).getNumberOfUniqueCharacters(any());
    }

    @Test
    void CalculatieWasNotCalledAgainWhenGivenAStringPreviouslyEncountered() {
        charCounter.countChar(helloWorldString);
        charCounter.countChar(helloWorldString);
        charCounter.countChar(helloWorldString);
        verify(calculator, times(1)).getNumberOfUniqueCharacters(any());
    }

    @Test
    void SecondCalculatorCall() {
        charCounter.countChar(secondString);
        verify(calculator, times(2)).getNumberOfUniqueCharacters(any());
    }

    @Test
    void FormatterСalls() {
        charCounter.countChar(secondString);
        verify(formatter, times(2)).getCountingCharactersString(any());
    }

    @Test
    void CacheCall() {
        cacheMock = mock(Cache.class);
        charCounter = new CharCounter(calculator, formatter, cacheMock);
        charCounter.countChar(secondString);
        verify(cacheMock).get(any());
    }
}
