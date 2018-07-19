package com.company;

public class Stack_Impl implements Stack_Interface {

    private int[] arrayForStack;
    private int currentSize;

    protected Stack_Impl(int arraySize) {
        this.currentSize = 0;
        arrayForStack = new int[arraySize];
    }

    public int getCurrentSize() {
        return currentSize;
    }

    @Override
    public int pop() {
        try{
            return this.arrayForStack[--currentSize];
        }catch (IndexOutOfBoundsException e){
            throw new IllegalArgumentException("Стек пуст. Невозможно выполнить ужаление. " + currentSize, e);
        }

    }

    @Override
    public void push(int value) {
        try {
            this.arrayForStack[currentSize++] = value;
        }catch (IndexOutOfBoundsException e){
            throw new IllegalArgumentException("Стек заполнен. Невозможно выполнить добавление. " + currentSize, e);
        }


    }

    @Override
    public int peek() {
        return this.arrayForStack[currentSize - 1]; // change
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
        return currentSize >= arrayForStack.length;
    }
}
