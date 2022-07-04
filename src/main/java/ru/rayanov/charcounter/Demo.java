package ru.rayanov.charcounter;

import ru.rayanov.charcounter.cache.Cache;
import ru.rayanov.charcounter.calculator.Calculator;
import ru.rayanov.charcounter.formatter.Formatter;

public class Demo {

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        Formatter formatter = new Formatter();
        Cache cache = new Cache();
        CharCounter charCounter = new CharCounter(calculator, formatter, cache);
        String text = "Hello World!";
        charCounter.countChar(text);
    }

}
