package main.Map;

public class TaxiHashMap<K, V> {
    private Entry<K, V>[] table;
    private static final int INITIAL_CAPACITY = 16;

    public TaxiHashMap() {
        table = new Entry[INITIAL_CAPACITY];
    }

    public void put(K key, V value) {
        int hash = key.hashCode() % INITIAL_CAPACITY;
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
    }

    public V get(K key) {
        int hash = key.hashCode() % INITIAL_CAPACITY;
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
