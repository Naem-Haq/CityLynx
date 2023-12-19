package com.ise.epic.DataStructures;

public class HashMapImplementation<K, V> {
    private Entry<K, V>[] table;
    private static final int INITIAL_CAPACITY = 16;
    private static final float LOAD_FACTOR_THRESHOLD = 0.75f;
    private int size;

    public HashMapImplementation() {
        table = new Entry[INITIAL_CAPACITY];
        size = 0;
    }

    public void put(K key, V value) {
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
    }

    public V get(K key) {
        int hash = key.hashCode() % table.length;
        if (table[hash] == null) {
            return null;
        } else {
            Entry<K, V> current = table[hash];
            while (current != null) {
                if (current.key.equals(key)) {
                    return current.value;
                }
                current = current.next;
            }
            return null;
        }
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

    private static class Entry<K, V> {
        K key;
        V value;
        Entry<K, V> next;

        Entry(K key, V value, Entry<K, V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }
}