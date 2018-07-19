package com.company;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class Main {

    static int[] b;

    static long startTime; // время начала сортировки
    static long endTime; // время окончания сортировки
    static long sortTime; // переменная для хранения времени сортировки

    public static void main(String[] args) {

        WorkWithArrays testMyArray = new MyArray(100); // Массив для поиска

        testMyArray.fillUpArray();                        // заполнение массива случайными числами
        testMyArray.showArray();

        b = ((MyArray) testMyArray).copyArray();  // СОЗДАНИЕ КОПИИ МАССИВА В ПЕРЕМЕННУЮ

        System.out.println("Пузырьковая сортировка");

        startTime = System.nanoTime();
        testMyArray.bubbleSort();
        endTime = System.nanoTime();

        System.out.println("Итог пузырьковой сортировки ");
        testMyArray.showArray();
        sortTime = TimeUnit.NANOSECONDS.toMillis(endTime - startTime);// ПОЛУЧЕНИЕ ВРЕМЕНИ СОРТИРОВКИ

        System.out.println("Время выполнения пузырьковой сортировки = " + sortTime); // ВЫВОД В КОНСОЛЬ ВРЕМЕНИ СОРТИРОВКИ


        System.out.println("Сортировка методом выбора");
        System.out.println("Скопированный массив для сортировки " + Arrays.toString(b));

        startTime = System.nanoTime();
        testMyArray.selectSort();
        endTime = System.nanoTime();

        System.out.println("Итог сортировки методом выбора");
        testMyArray.showArray();
        sortTime = TimeUnit.NANOSECONDS.toMillis(endTime - startTime);// ПОЛУЧЕНИЕ ВРЕМЕНИ СОРТИРОВКИ

        System.out.println("Время выполнения сортировки методом выбора = " + sortTime); // ВЫВОД В КОНСОЛЬ ВРЕМЕНИ СОРТИРОВКИ

        System.out.println("Сортировка методом вставки");
        System.out.println("Скопированный массив для сортировки " + Arrays.toString(b));

        startTime = System.nanoTime();
        testMyArray.insertSort();
        endTime = System.nanoTime();

        System.out.println("Итог сортировки методом вставки");
        testMyArray.showArray();
        sortTime = TimeUnit.NANOSECONDS.toMillis(endTime - startTime);// ПОЛУЧЕНИЕ ВРЕМЕНИ СОРТИРОВКИ

        System.out.println("Время выполнения сортировки методом вставки = " + sortTime); // ВЫВОД В КОНСОЛЬ ВРЕМЕНИ СОРТИРОВКИ

        System.out.println("********Удаление элемента**********"); // Удаление элемента из массива

        System.out.println("Удаляемое значение = 3");
        boolean deleteValue = true;
        while (deleteValue) {
            deleteValue = testMyArray.deleteElement(3);
        }
        testMyArray.showArray();

        System.out.println("********Добавление элемента в конец массива**********"); // Добавление элемента в массив

        System.out.println("Добавляемое значение = 9");
        testMyArray.addElement(9);
        testMyArray.showArray();

        System.out.println("*********Линейный поиск элемента в массиве*********"); // Поиск элемента в массиве
        testMyArray.showArray();

        startTime = System.nanoTime();
        testMyArray.findElement(2);
        endTime = System.nanoTime();
        sortTime = endTime - startTime;

        System.out.println("Искомое значение 2 под индексом " + testMyArray.findElement(2));
        System.out.println("Время линейного поиска = " + sortTime);

        System.out.println("********Получение значения из массива и замена значения в массиве**********"); // Использование get/set

        testMyArray.showArray();
        System.out.println("В массиве под индексом №2 находится значение = " + testMyArray.getElement(2));

        System.out.println("Замена значения " + testMyArray.getElement(3) + " в индексе №3 на 8");
        testMyArray.setElement(8, 3);
        testMyArray.showArray();

        /*Создание массива для бинарного поиска и добавления элемента*/

        System.out.println("****************Бинарный поиск*****************");

        WorkWithArrays testMyArrayBinary = new MyArray(100); // Массив для бинарного поиска
        testMyArrayBinary.fillUpArray();
        testMyArrayBinary.showArray();

        System.out.println("Пузырьковая сортировка");
        testMyArrayBinary.bubbleSort();
        testMyArrayBinary.showArray();

//        System.out.println("Сортировка методом выбора");
//        testMyArrayBinary.selectSort();
//        testMyArrayBinary.showArray();
//
//        System.out.println("Сортировка методом вставки");
//        testMyArrayBinary.insertSort();
//        testMyArrayBinary.showArray();

        System.out.println("*********<Бинарный поиск элемента в массиве***********");
        System.out.println("Искомое значение в массиве = 4 ");

        startTime = System.nanoTime();
        testMyArrayBinary.findElement(4);
        endTime = System.nanoTime();
        sortTime = endTime - startTime;

        System.out.println("Элемент 4 под индексом № " + testMyArrayBinary.findElement(4));
        System.out.println("Время бинарного поиска = " + sortTime);

        System.out.println("*******Удаление элемента******");
        System.out.println("Удален элемент 2");

        testMyArrayBinary.deleteElement(2);
        testMyArrayBinary.showArray();

        System.out.println("*********Добавление элемента в массив**********");
        System.out.println("Добавляемое значение 3 ");

        testMyArrayBinary.addElement(3);
        testMyArrayBinary.showArray();
    }
}
