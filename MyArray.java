package com.company;

import java.util.Arrays;
import java.util.Random;

public class MyArray implements WorkWithArrays {

    protected int size;
    public int[] array;

    protected MyArray(int size) {
        this.size = size;
        this.array = new int[size];
    }


    public int[] copyArray() {      // МЕТОД ДЛЯ СОЗДАНИЯ КОПИИ МАССИВА
        return Arrays.copyOf(array, array.length);
    }

    @Override
    public int getElement(int index) {
        return array[index];
    }

    @Override
    public void setElement(int value, int index) {
        array[index] = value;
    }

    @Override
    public void showArray() {
//        for (int i = 0; i < size; i++) { // Чтобы при вызове метода отображались только заполненные ячейки, без пустых с default значением 0!
//         System.out.println(array[i]);  // Если установить i<array.length, то будет выводиться весь массив и с ячейками заполненнми 0.
//        }
        System.out.print(Arrays.toString(array)); // только для удобства просмотра в консоли (т.к. число массива 100), НО! выводит также и "пустые" ячейки массива, которые перезаписаны.
    }

    @Override
    public void fillUpArray() {
        Random rand = new Random();
        int number;
        for (int i = 0; i < array.length; i++) {
            number = rand.nextInt(size);
            array[i] = number;
        }
    }

    @Override
    public boolean deleteElement(int element) {
        int index = findElement(element);
        if (index == -1) {
            System.out.println("Искомый элемент не найден. Удален или его нет в массиве");
            return false;
        } else {
            for (int i = index; i < array.length - 1; i++) {
                array[i] = array[i + 1];
            }
            size--;
            return true;
        }
    }

    @Override
    public void addElement(int element) {
        if (array.length == size) {
            System.out.println("Недостаточно места для добавления. Массив заполнен.");
        } else {
            array[size++] = element; // сокращаем запись size++. Сначала добавит элемент, потом прибавит size
//        size++;
        }
    }

    @Override
    public void bubbleSort() {
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    exchange(j, j + 1);
                }
            }
        }
    }

    protected void exchange(int value1, int value2) {
        int temp = array[value1];
        array[value1] = array[value2];
        array[value2] = temp;
    }

    @Override
    public void selectSort() {
        int minElementIndex;
        for (int i = 0; i < size - 1; i++) {
            minElementIndex = i;
            for (int j = i + 1; j < size; j++) {
                if (array[j] < array[minElementIndex]) {
                    minElementIndex = j;
                }
            }
            if (minElementIndex != i) {
                exchange(i, minElementIndex);
            }
        }
    }

    @Override
    public void insertSort() {
        for (int i = 1; i < size; i++) {
            int value = array[i];
            int index = i;
            while (index > 0 && array[index - 1] >= value) {
                array[index] = array[index - 1];
                index--;
            }
            array[index] = value;
        }
    }

    @Override
    public int findElement(int element) {
        int index = -1;
        for (index = 0; index < size; index++) {
            if (array[index] == element) {
                return index;
            }
        }
        return -1;

    }

}
