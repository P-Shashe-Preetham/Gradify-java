package com.gradify.datastructures;

import java.util.Iterator;

public class CircularQueue<T> implements Iterable<T> {
    private Object[] array;
    private int head;
    private int tail;
    private int size;
    private int capacity;

    public CircularQueue(int capacity) {
        this.capacity = capacity;
        this.array = new Object[capacity];
        this.head = 0;
        this.tail = -1;
        this.size = 0;
    }

    public void enqueue(T item) {
        tail = (tail + 1) % capacity;
        array[tail] = item;
        
        if (size < capacity) {
            size++;
        } else {
            // Overwriting the oldest element, so move head forward
            head = (head + 1) % capacity;
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int current = head;
            private int count = 0;

            @Override
            public boolean hasNext() {
                return count < size;
            }

            @Override
            @SuppressWarnings("unchecked")
            public T next() {
                T item = (T) array[current];
                current = (current + 1) % capacity;
                count++;
                return item;
            }
        };
    }
}
