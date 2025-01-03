package dev.keith;

import java.util.List;
import java.util.Map;

public class Pair<K, V> {
    private K key;
    private V value;
    private Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public static <K, V> Pair<K, V> of(K key, V value) {
        return new Pair<>(key, value);
    }
    public static <K, V> Pair<K, V> of(Map.Entry<K, V> entry) {
        return Pair.of(entry.getKey(), entry.getValue());
    }
    public static <K, V> List<Pair<K, V>> of(Map<K, V> map) {
        return map
                .entrySet()
                .stream()
                .map(Pair::of)
                .toList();
    }

    public V value() {
        return value;
    }

    public K key() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public void setValue(V value) {
        this.value = value;
    }
}
