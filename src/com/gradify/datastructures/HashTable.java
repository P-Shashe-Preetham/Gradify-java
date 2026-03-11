package com.gradify.datastructures;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class HashTable<K, V> {
    
    // Separate chaining via a basic Node structure
    private class HashNode<K, V> {
        K key;
        V value;
        HashNode<K, V> next;

        public HashNode(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private ArrayList<HashNode<K, V>> buckets;
    private int numBuckets;
    private int size;

    public HashTable() {
        this.numBuckets = 10;
        this.buckets = new ArrayList<>(numBuckets);
        for (int i = 0; i < numBuckets; i++) {
            buckets.add(null);
        }
    }

    private int getBucketIndex(K key) {
        int hashCode = key.hashCode();
        int index = hashCode % numBuckets;
        // Hash code can be negative
        return index < 0 ? index * -1 : index;
    }

    public void put(K key, V value) {
        int bucketIndex = getBucketIndex(key);
        HashNode<K, V> head = buckets.get(bucketIndex);

        // Check if key already exists
        while (head != null) {
            if (head.key.equals(key)) {
                head.value = value;
                return;
            }
            head = head.next;
        }

        // Insert at head
        size++;
        head = buckets.get(bucketIndex);
        HashNode<K, V> newNode = new HashNode<>(key, value);
        newNode.next = head;
        buckets.set(bucketIndex, newNode);
    }

    public V get(K key) {
        int bucketIndex = getBucketIndex(key);
        HashNode<K, V> head = buckets.get(bucketIndex);

        while (head != null) {
            if (head.key.equals(key)) {
                return head.value;
            }
            head = head.next;
        }
        return null;
    }

    public boolean containsKey(K key) {
        return get(key) != null;
    }

    public int size() {
        return size;
    }

    // Helper to extract all values for Leaderboard sorting
    public Collection<V> values() {
        List<V> allValues = new ArrayList<>();
        for (HashNode<K, V> headNode : buckets) {
            HashNode<K, V> current = headNode;
            while (current != null) {
                allValues.add(current.value);
                current = current.next;
            }
        }
        return allValues;
    }
}
