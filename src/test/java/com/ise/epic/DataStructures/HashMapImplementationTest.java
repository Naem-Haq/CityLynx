package com.ise.epic.DataStructures;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class HashMapImplementationTest {

    @Test
    void size() {
        HashMapImplementation<String, Integer> hashMap = new HashMapImplementation<>();
        assertEquals(0, hashMap.size());

        hashMap.put("One", 1);
        assertEquals(1, hashMap.size());

        hashMap.put("Two", 2);
        assertEquals(2, hashMap.size());
    }

    @Test
    void isEmpty() {
        HashMapImplementation<String, Integer> hashMap = new HashMapImplementation<>();
        assertTrue(hashMap.isEmpty());

        hashMap.put("One", 1);
        assertFalse(hashMap.isEmpty());
    }

    @Test
    void containsKey() {
        HashMapImplementation<String, Integer> hashMap = new HashMapImplementation<>();
        assertFalse(hashMap.containsKey("One"));

        hashMap.put("One", 1);
        assertTrue(hashMap.containsKey("One"));
        assertFalse(hashMap.containsKey("Two"));
    }

    @Test
    void containsValue() {
        HashMapImplementation<String, Integer> hashMap = new HashMapImplementation<>();
        assertFalse(hashMap.containsValue(1));

        hashMap.put("One", 1);
        assertTrue(hashMap.containsValue(1));
        assertFalse(hashMap.containsValue(2));
    }

    @Test
    void get() {
        HashMapImplementation<String, Integer> hashMap = new HashMapImplementation<>();
        assertNull(hashMap.get("One"));

        hashMap.put("One", 1);
        assertEquals(1, hashMap.get("One"));
    }

    @Test
    void remove() {
        HashMapImplementation<String, Integer> hashMap = new HashMapImplementation<>();
        assertNull(hashMap.remove("One"));

        hashMap.put("One", 1);
        assertEquals(1, hashMap.remove("One"));
        assertNull(hashMap.get("One"));
    }

    @Test
    void putAll() {
        HashMapImplementation<String, Integer> hashMap = new HashMapImplementation<>();
        Map<String, Integer> otherMap = new HashMap<>();
        otherMap.put("Two", 2);
        otherMap.put("Three", 3);

        hashMap.putAll(otherMap);
        assertEquals(2, hashMap.size());
        assertEquals(2, hashMap.get("Two"));
        assertEquals(3, hashMap.get("Three"));
    }

    @Test
    void clear() {
        HashMapImplementation<String, Integer> hashMap = new HashMapImplementation<>();
        hashMap.put("One", 1);
        hashMap.put("Two", 2);

        hashMap.clear();
        assertEquals(0, hashMap.size());
        assertNull(hashMap.get("One"));
        assertNull(hashMap.get("Two"));
    }

    @Test
    void keySet() {
        HashMapImplementation<String, Integer> hashMap = new HashMapImplementation<>();
        hashMap.put("One", 1);
        hashMap.put("Two", 2);

        Set<String> keySet = new HashSet<>();
        keySet.add("One");
        keySet.add("Two");

        assertEquals(keySet, hashMap.keySet());
    }

    @Test
    void values() {
        HashMapImplementation<String, Integer> hashMap = new HashMapImplementation<>();
        hashMap.put("One", 1);
        hashMap.put("Two", 2);

        Set<Integer> valuesSet = new HashSet<>();
        valuesSet.add(1);
        valuesSet.add(2);

        assertEquals(valuesSet, new HashSet<>(hashMap.values()));
    }

    @Test
    void entrySet() {
        HashMapImplementation<String, Integer> hashMap = new HashMapImplementation<>();
        hashMap.put("One", 1);
        hashMap.put("Two", 2);

        Set<Map.Entry<String, Integer>> entrySet = new HashSet<>();
        entrySet.add(Map.entry("One", 1));
        entrySet.add(Map.entry("Two", 2));

        assertEquals(entrySet, new HashSet<>(hashMap.entrySet()));
    }

    @Test
    void put() {
        HashMapImplementation<String, Integer> hashMap = new HashMapImplementation<>();

        // Adding an entry
        assertNull(hashMap.put("One", 1));

        // Attempting to add an entry with an existing key
        assertEquals(1, hashMap.put("One", 2));
        assertEquals(2, hashMap.get("One"));
    }
}
