import com.company.IStack;
import com.company.Queue;
import com.company.QueueImpl;

import javax.swing.text.html.HTMLDocument;
import java.util.Arrays;
import java.util.Iterator;

public class LinkedListMain {

    public static void main(String[] args) {

        /* Связанный список */

        ILinkedList list = new LinkedListImpl();

        list.insertFirst(1); // вставка элементов в Связанный список
        list.insertFirst(2);
        list.insertFirst(3);
        list.insertFirst(4);
        list.insertFirst(5);
//        list.display();
//
//        System.out.println("Find 3 = " + list.find(3)); // поиск элемента
//        System.out.println("Find 13 = " + list.find(13));
//
//        System.out.println("Remove 6 " + list.remove(6)); //удаление элемента из середины
//        list.display();
//
//        System.out.println("*************");
//
//        list.removeFirst(); // удаление первого! элемента из Связанного  списка
//        list.removeFirst();
//        list.display();
//        System.out.println("Show first element = " + list.getFirstElement()); // вывод первого элемента из Связанного списка
//
//        System.out.println("List is empty - " + list.isEmpty()); // проверка на пустоту списка
//
//        list.removeFirst();
//        list.removeFirst();
//        list.removeFirst();
//
//        System.out.println("After deleting all elements. List is empty - " + list.isEmpty());

        /* Связанный Список реализует Стек*/

//        IStack stackTest = new LinkedListStack();
//
//        stackTest.push(1);
//        stackTest.push(2);
//        stackTest.push(3);
//        stackTest.push(4);
//        stackTest.push(5);
//        stackTest.push(6);
//
//
//        System.out.println("Stack is full = " + stackTest.isFull());// проверка на заполненность стэка
//
//        System.out.println("Top element = " + stackTest.peek());
//
//
//        while (!stackTest.isEmpty()) {
//            System.out.println(stackTest.pop());
//        }
//
////        stackTest.pop();

        /* Двусторонний связанный список */
//
//        ITwoWayLinkedList twoWayLinkedList = new TwoWayLinkedListImpl();
//
//        twoWayLinkedList.insertFirst(1);
//        twoWayLinkedList.insertFirst(2);
//        twoWayLinkedList.insertFirst(3);
//        twoWayLinkedList.insertLast(4);
//        twoWayLinkedList.insertFirst(5);
//        twoWayLinkedList.display();

        /* Связанный список реализует Очередь */

//        System.out.println("****************");
//        Queue queueTest = new LinkedListQueue();
//
//        queueTest.insert(1);
//        queueTest.insert(2);
//        queueTest.insert(3);
//        queueTest.insert(4);
//        queueTest.insert(5);
//
//        System.out.println("After insert method. Queue size is " + queueTest.getSize());
//
//        while (!queueTest.isEmpty()) {                      // удаление элементов
//            System.out.println(queueTest.remove());
//        }

        /* Итератор */
//        Iterator<Integer> iterator = list.iterator();
//        while (iterator.hasNext()) {
//            Integer next = iterator.next();
//            System.out.println(next);
//        }

        for (Integer value : list) {
            System.out.println(value);
        }

        /* По методичке */

        LinkImpl testList = new LinkImpl();

        ((LinkImpl) testList).insertFirst("Чак Норис", 70);
        ((LinkImpl) testList).insertFirst("Сильвестр Сталоне", 50);
        ((LinkImpl) testList).insertFirst("Петя", 30);
        ((LinkImpl) testList).insertFirst("Кудряшка Сью", 27);
        testList.display();
        System.out.println("Size is " + testList.getSize());

        System.out.println("Link is empty: " + testList.isEmpty());

        System.out.println("************************");
        System.out.println("Remove first element");
        testList.removeFirst();
        testList.display();

        /*Iterator*/
        System.out.println("Iterator for Link");
        for (LinkImpl link : testList) {
            System.out.println(link);
        }
    }
}
