package com.company;

public class MyArrayBinary extends MyArray {

    public MyArrayBinary(int size) {
        super(size);
    }

    @Override
    public void fillUpArray() {
        super.fillUpArray();
    }

    @Override
    public void bubbleSort() {
        super.bubbleSort();
    }

    @Override
    public void selectSort() {
        super.selectSort();
    }

    @Override
    public void insertSort() {
        super.insertSort();
    }

    @Override
    public void setElement(int value, int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void addElement(int element) {
        int index = 0;
        for (index = 0; index < size; index++) {
            if (array[index] >= element) {
                break;
            }
        }
        for (int i = size; i > index; i--) {
            array[i] = array[i - 1];
        }
        array[index] = element;
        size++;
    }

    @Override
    public int findElement(int element) {
        int low = 0;
        int high = size;
        int mid;

        while (low <= high){
            mid = (low + high) / 2;
            if (array[mid] == element){
                return mid;
            }

            if (array[mid] < element){
                low = mid++;
            }else {
                high = mid;
            }
        }
        return -1;
    }
}
