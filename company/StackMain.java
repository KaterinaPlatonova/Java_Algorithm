package com.company;

import java.util.Arrays;
import java.util.Random;

public class StackMain {
    static Random rand = new Random();

    public static void main(String[] args) {

/*
        Стек
*/
        StackImpl stackTest = new StackImpl(5);

        while (!stackTest.isFull()) {
            int randomNumber = rand.nextInt(stackTest.getCurrentSize() + 1);
            stackTest.push(randomNumber);
        }
        System.out.println("After push method. Stack size is " + stackTest.getSize());

        System.out.println("Stack is full = " + stackTest.isFull());// проверка на заполненность стэка

        System.out.println("Top element = " + stackTest.peek());


        while (!stackTest.isEmpty()) {
            System.out.println(stackTest.pop());
        }

        System.out.println("After pop method. Stack size is " + stackTest.getSize());

/*
        Очередь
*/
        System.out.println("****************");
        QueueImpl queueTest = new QueueImpl(5);

        while (!queueTest.isFull()) {
            int randomNumber = rand.nextInt(queueTest.getCurrentSize() + 1);
            queueTest.insert(randomNumber);
        }

        System.out.println(Arrays.toString(queueTest.getArrayForQueue()));

        System.out.println("After insert method. Queue size is " + queueTest.getSize());

        System.out.println("Stack is full = " + queueTest.isFull());// проверка на заполненность очереди

        while (!queueTest.isEmpty()) {                      // удаление элементов
            System.out.println(queueTest.remove());
        }

    }
}
