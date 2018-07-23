import java.awt.*;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

public class LinkImpl implements Iterable<Link> {

    private Link firstElement;
    protected int size;

    public LinkImpl() {
        this.size = 0;
    }


    public void insertFirst(String name, int age) {
        Link newElement = new Link(name, age);
        if (isEmpty()) {                        // если список пуст первым элементом добавляется новый, созданный, объект
            firstElement = newElement;
        } else {
            newElement.setNextItem(firstElement);   // устанавливаем, что ПОСЛЕ вставленного НОВОГО элемента, будет идти ранее добавленный ПЕРВЫЙ элемент
            firstElement = newElement;             // теперь в переменную первого элемента устанавливаем ссылку на НОВЫй элемент, чтобы новый элемент считался первым
        }
        size++;


    }

    public int removeFirst() {
        if (firstElement == null) { // если Сязанный список пустой, то выводим информацию об этом
            throw new IllegalComponentStateException("Список пуст, удалить элемент невозможно.");
        }
        Link data = firstElement;                      // переменная для хранения данных, находящихся в первом элементе
        Link elementAfterRemoved = firstElement.getNextItem();  // переменная для хранения ссылки на элемент, следующий за первым элементом
        firstElement.setNextItem(null);                         // устанавливаем, что за первым элементом null, разрываем связь между ПЕРВЫМ и СЛЕДУЮЩИМ элементом

        firstElement = elementAfterRemoved;                     // записываем в переменную первого элемента ссылку на элемент, который ранее был вторым
        size--;
        return data.getAge();
    }

    public boolean isEmpty() {
        return firstElement == null;
    }

    public int getSize() {
        return this.size;
    }

    public void display() {
        Link currentElement = firstElement; // отражение элементов Связанного списка
        while (currentElement != null) {
            System.out.println(currentElement.getName() + " " + currentElement.getAge());
            currentElement = currentElement.getNextItem();
        }
    }

    public Link getFirstElement() {
        return firstElement;
    }

    @Override
    public Iterator<Link> iterator() {
        return null;
    }

    @Override
    public void forEach(Consumer<? super Link> action) {

    }

    @Override
    public Spliterator<Link> spliterator() {
        return null;
    }


}
