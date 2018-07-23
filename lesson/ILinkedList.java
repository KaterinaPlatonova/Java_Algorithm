public interface ILinkedList extends Iterable<Integer>{

    void insertFirst(int data);

    int removeFirst();

    boolean isEmpty();

    int getSize();

    void display();

    Integer getFirstElement();

    Item getFirstItem();

    boolean find(int value);

    boolean remove(int value);
}
