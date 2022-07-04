package ru.rayanov.charcounter.cache;

import java.util.HashMap;
import java.util.Map;

public class Cache {
    private Map<String, String> cacheMap = new HashMap<>();

    public String put(String key, String value) {
        return cacheMap.put(key, value);
    }

    public String get(String key) {
        return cacheMap.get(key);
    }

    public boolean isPresent(String key) {
        return cacheMap.containsKey(key);
    }
}
