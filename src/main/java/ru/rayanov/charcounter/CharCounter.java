package ru.rayanov.charcounter;


import ru.rayanov.charcounter.cache.Cache;
import ru.rayanov.charcounter.calculator.Calculator;
import ru.rayanov.charcounter.formatter.Formatter;

public class CharCounter {
    private Calculator calculator;
    private Formatter formatter;
    private Cache cache;

    public CharCounter(Calculator calculator, Formatter formatter, Cache cache) {
        this.calculator = calculator;
        this.formatter = formatter;
        this.cache = cache;
    }

    public String countChar(String input) {
        if (input == null)
            throw new IllegalArgumentException("The string cannot be null");
        if (input.isEmpty())
            throw new IllegalArgumentException("The string cannot be empty");

        if (!cache.isPresent(input)) {
            cache.put(input, formatter.getCountingCharactersString(calculator.getNumberOfUniqueCharacters(input)));
        }
        return cache.get(input);
    }
}
