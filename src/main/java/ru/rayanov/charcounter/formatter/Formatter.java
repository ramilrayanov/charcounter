package ru.rayanov.charcounter.formatter;

import java.util.Map;

public class Formatter {
    private static final String QUOTE = "\"";
    private static final String DASH = "-";
    private static final String NEWLINE = "\n";

    public String getCountingCharactersString(Map<Character, Integer> input) {
        StringBuilder output = new StringBuilder();
        for (Map.Entry<Character, Integer> pair : input.entrySet()) {
            output.append(QUOTE);
            output.append(pair.getKey());
            output.append(QUOTE);
            output.append(DASH);
            output.append(QUOTE);
            output.append(pair.getValue());
            output.append(NEWLINE);
        }
        return output.toString();
    }
}
