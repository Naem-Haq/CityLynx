package com.ise.epic.DataStructures;

import java.util.*;

public class HashMapImplementation<K, V> implements Map<K, V> {
    private Entry<K, V>[] table;
    private static final int INITIAL_CAPACITY = 16;
    private static final float LOAD_FACTOR_THRESHOLD = 0.75f;
    private int size;

    public HashMapImplementation() {
        table = new Entry[INITIAL_CAPACITY];
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean containsKey(Object key) {
        int hash = key.hashCode() % table.length;
        Entry<K, V> current = table[hash];
        while (current != null) {
            if (current.key.equals(key)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    @Override
    public boolean containsValue(Object value) {
        for (Entry<K, V> entry : table) {
            Entry<K, V> current = entry;
            while (current != null) {
                if (Objects.equals(current.value, value)) {
                    return true;
                }
                current = current.next;
            }
        }
        return false;
    }

    @Override
    public V get(Object key) {
        int hash = key.hashCode() % table.length;
        Entry<K, V> current = table[hash];
        while (current != null) {
            if (current.key.equals(key)) {
                return current.value;
            }
            current = current.next;
        }
        return null;
    }

    @Override
    public V remove(Object key) {
        int hash = key.hashCode() % table.length;
        Entry<K, V> current = table[hash];
        Entry<K, V> prev = null;

        while (current != null) {
            if (current.key.equals(key)) {
                if (prev == null) {
                    table[hash] = current.next;
                } else {
                    prev.next = current.next;
                }
                size--;
                return current.value;
            }
            prev = current;
            current = current.next;
        }

        return null;
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> m) {
        for (Map.Entry<? extends K, ? extends V> entry : m.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    @Override
    public void clear() {
        Arrays.fill(table, null);
        size = 0;
    }

    @Override
    public Set<K> keySet() {
        Set<K> keySet = new HashSet<>();
        for (Entry<K, V> entry : table) {
            Entry<K, V> current = entry;
            while (current != null) {
                keySet.add(current.key);
                current = current.next;
            }
        }
        return keySet;
    }

    @Override
    public Collection<V> values() {
        List<V> valuesList = new ArrayList<>();
        for (Entry<K, V> entry : table) {
            Entry<K, V> current = entry;
            while (current != null) {
                valuesList.add(current.value);
                current = current.next;
            }
        }
        return valuesList;
    }

    @Override
    public Set<Map.Entry<K, V>> entrySet() {
        Set<Map.Entry<K, V>> entrySet = new HashSet<>();
        for (Entry<K, V> entry : table) {
            Entry<K, V> current = entry;
            while (current != null) {
                entrySet.add(current);
                current = current.next;
            }
        }
        return entrySet;
    }

    @Override
    public V put(K key, V value) {
        if (shouldResize()) {
            resize();
        }

        int hash = key.hashCode() % table.length;
        Entry<K, V> newEntry = new Entry<>(key, value, null);

        if (table[hash] == null) {
            table[hash] = newEntry;
        } else {
            Entry<K, V> current = table[hash];
            while (current.next != null) {
                current = current.next;
            }
            current.next = newEntry;
        }

        size++;
        return value;
    }

    private boolean shouldResize() {
        return (float) size / table.length >= LOAD_FACTOR_THRESHOLD;
    }

    private void resize() {
        Entry<K, V>[] newTable = new Entry[table.length * 2];
        for (Entry<K, V> entry : table) {
            while (entry != null) {
                Entry<K, V> next = entry.next;
                int hash = entry.key.hashCode() % newTable.length;
                entry.next = newTable[hash];
                newTable[hash] = entry;
                entry = next;
            }
        }
        table = newTable;
    }

    private static class Entry<K, V> implements Map.Entry<K, V> {
        K key;
        V value;
        Entry<K, V> next;

        Entry(K key, V value, Entry<K, V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public V getValue() {
            return value;
        }

        @Override
        public V setValue(V value) {
            V oldValue = this.value;
            this.value = value;
            return oldValue;
        }
    }
}
