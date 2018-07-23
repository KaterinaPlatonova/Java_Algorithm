public class TwoWayLinkedListImpl extends LinkedListImpl implements ITwoWayLinkedList{

    protected Item lastElement;

    public TwoWayLinkedListImpl() {
        super();
    }

    @Override
    public void insertFirst(int data) {
        Item newElement = new Item(data);   // создание объекта - элемента
        if (isEmpty()) {                    // если список пуст первым элементом добавляется новый, созданный, объект
           lastElement = newElement;
        }
        newElement.setNextItem(firstElement);   // устанавливаем, что ПОСЛЕ вставленного НОВОГО элемента, будет идти ранее добавленный ПЕРВЫЙ элемент
        firstElement = newElement; // теперь в переменную первого элемента устанавливаем ссылку на НОВЫй элемент, чтобы новый элемент считался первым
        size++;
    }

    @Override
    public void insertLast(int value) {
        Item newItem = new Item(value);
        if ( isEmpty() ){
            firstElement = newItem;
        }else {
            lastElement.setNextItem(newItem);
        }
        lastElement = newItem;
        size++;
    }

    @Override
    public int removeFirst() {
        int value = super.removeFirst();
        if ( isEmpty() ){
            lastElement = null;
        }
        return value;
    }

    @Override
    public Integer getLastElement() {
        return lastElement != null ? lastElement.getData() : null;
    }
}
