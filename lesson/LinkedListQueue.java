import com.company.Queue;

public class LinkedListQueue implements Queue {

    private ITwoWayLinkedList linkedList;

    public LinkedListQueue() {
        this.linkedList = new TwoWayLinkedListImpl();
    }

    @Override
    public int remove() {
        return linkedList.removeFirst();
    }

    @Override
    public void insert(int value) {
        linkedList.insertLast(value);
    }

    @Override
    public int getSize() {
        return linkedList.getSize();
    }

    @Override
    public boolean isEmpty() {
        return linkedList.isEmpty();
    }

    @Override
    public boolean isFull() {
        return false;
    }
}
