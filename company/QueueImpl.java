package com.company;

public class QueueImpl implements Queue {

    public static final int REAR_DEFAULT = -1;
    public static final int FRONT_DEFAULT = 0;
    private int[] arrayForQueue;
    private int currentSize;

    private int front;
    private int rear;

    public QueueImpl(int currentSize) {
        this.currentSize = 0;
        this.front = FRONT_DEFAULT;
        this.rear = REAR_DEFAULT;
        this.arrayForQueue = new int[currentSize];
    }

    public int getCurrentSize() {
        return currentSize;
    }

    public int[] getArrayForQueue() {
        return arrayForQueue;
    }

    @Override
    public int remove() {
        int removedElement = arrayForQueue[front++];
        if (front == arrayForQueue.length) {
            front = FRONT_DEFAULT;
        }
        currentSize--;
        return removedElement;
    }

    @Override
    public void insert(int value) {
        if (rear == arrayForQueue.length - 1) {
            rear = REAR_DEFAULT;

        }
        arrayForQueue[++rear] = value;
        currentSize++;
    }

    @Override
    public int getSize() {
        return currentSize;
    }

    @Override
    public boolean isEmpty() {
        return currentSize == 0;
    }

    @Override
    public boolean isFull() {
        return currentSize == arrayForQueue.length;
    }
}
