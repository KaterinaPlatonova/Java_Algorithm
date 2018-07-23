import com.company.IStack;

public class LinkedListStack implements IStack {

    ILinkedList list;

    public LinkedListStack() {
        this.list = new LinkedListImpl();
    }

    @Override
    public int pop() {
        return list.removeFirst();
    }

    @Override
    public void push(int value) {
        list.insertFirst(value);

    }

    @Override
    public int peek() {
        return list.getFirstElement();
    }

    @Override
    public int getSize() {
        return list.getSize();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public boolean isFull() {
        return false;
    }
}
