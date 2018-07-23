import java.util.Iterator;

public class LinkedListIterator implements Iterator<Integer> {

    private ILinkedList list;
    private boolean firstIterate = true;

    private Item current;

    public LinkedListIterator(ILinkedList list) {
        this.list = list;
    }

    @Override
    public boolean hasNext() {
        if (firstIterate) {
            firstIterate = false;
            return list.getFirstElement() != null;
        } else {
            return current.getNextItem() != null;
        }
    }

    @Override
    public Integer next() {
        if (current == null) {
            current = list.getFirstItem();
        }else {
            current = current.getNextItem();
        }
        return current.getData();
    }

    @Override
    public void remove() {
        list.remove(current.getData());
    }
}
