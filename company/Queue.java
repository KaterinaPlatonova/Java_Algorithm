package com.company;

public interface Queue {

    int remove();

    void insert(int value);

    int getSize();

    boolean isEmpty();

    boolean isFull();
}
