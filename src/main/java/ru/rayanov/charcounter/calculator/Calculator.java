package ru.rayanov.charcounter.calculator;

import java.util.LinkedHashMap;
import java.util.Map;

public class Calculator {
    public Map<Character, Integer> getNumberOfUniqueCharacters(String input) {
        if (input == null)
            throw new IllegalArgumentException("The string cannot be null");
        if (input.isEmpty())
            throw new IllegalArgumentException("The string cannot be empty");

        input = input.toLowerCase();
        char[] charArray = input.toCharArray();
        Map<Character, Integer> charMap = new LinkedHashMap<>();
        for (int i = 0; i < charArray.length; i++) {
            if (charMap.containsKey(charArray[i]))
                charMap.replace(charArray[i], charMap.get(charArray[i]) + 1);
            else
                charMap.put(charArray[i], 1);
        }
        return charMap;
    }
}
