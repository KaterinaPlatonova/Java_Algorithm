import java.awt.*;
import java.util.Iterator;

public class LinkedListImpl implements ILinkedList {

    protected Item firstElement; // переменная для хранения первого элемента Связанного списка
    protected int size;

    public LinkedListImpl() {
        this.size = 0;
    }

    @Override
    public void insertFirst(int data) {     // вставка, В НАЧАЛО, элемента
        Item newElement = new Item(data);   // создание объекта - элемента
        if (isEmpty()) {                    // если список пуст первым элементом добавляется новый, созданный, объект
            firstElement = newElement;
        } else {
            newElement.setNextItem(firstElement);   // устанавливаем, что ПОСЛЕ вставленного НОВОГО элемента, будет идти ранее добавленный ПЕРВЫЙ элемент
            firstElement = newElement;             // теперь в переменную первого элемента устанавливаем ссылку на НОВЫй элемент, чтобы новый элемент считался первым
        }
        size++;
    }

    @Override
    public int removeFirst() {
        if (firstElement == null) { // если Сязанный список пустой, то выводим информацию об этом
            throw new IllegalComponentStateException("Список пуст, удалить элемент невозможно.");
        }
        int data = firstElement.getData();                      // переменная для хранения данных, находящихся в первом элементе
        Item elementAfterRemoved = firstElement.getNextItem();  // переменная для хранения ссылки на элемент, следующий за первым элементом
        firstElement.setNextItem(null);                         // устанавливаем, что за первым элементом null, разрываем связь между ПЕРВЫМ и СЛЕДУЮЩИМ элементом

        firstElement = elementAfterRemoved;                     // записываем в переменную первого элемента ссылку на элемент, который ранее был вторым
        size--;
        return data;                                            // возвращаем информацию по данным, которые были удалены
    }

    @Override
    public boolean isEmpty() {
        return firstElement == null;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void display() {
        Item currentElement = firstElement; // отражение элементов Связанного списка
        while (currentElement != null) {
            System.out.println(currentElement);
            currentElement = currentElement.getNextItem();
        }
    }

    @Override
    public Integer getFirstElement() {
        return firstElement != null ? firstElement.getData() : null; // тернарный оператор, чтобы не выводить ошибки, используем обертку Integer
    }

    @Override
    public boolean find(int value) {
        Item currentItem = firstElement; // изначально в переменной первый элемент, который будет проверяться первым

        while (currentItem != null) {
            if (currentItem.getData() == value) {
                return true;
            }
            currentItem = currentItem.getNextItem(); // если после проверки первого элемента значение не найдено, записываем в переменную следующий за первым элемент
        }
        return false;
    }

    @Override
    public boolean remove(int value) {
        Item currentItem = firstElement; //переменная хранит первый элемент
        Item previousItem = null; // переменная в которой будет сохраняться предыдущий элемент (до удаляемого)

        while (currentItem != null) {
            if (currentItem.getData() == value) { // если значение найдено
                break;
            }
            previousItem = currentItem; // если значение не найдено, записываем ссылку на текущий, проверенный, объект в переменную
            currentItem = currentItem.getNextItem(); // далее записываем в текущую переменную следующий элемент для проверки
        }
        if (currentItem == null) {
            return false;
        }
        if (currentItem == firstElement) { // если удаляемый элемент будет первым
            firstElement = currentItem.getNextItem();
        } else {
            Item nextItem = currentItem.getNextItem(); // переменная для хранения следующего элемента, после найденного для удаления
            previousItem.setNextItem(nextItem);
        }
        return true;
    }

    @Override
    public Item getFirstItem() {
        return firstElement;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new LinkedListIterator(this);
    }
}
