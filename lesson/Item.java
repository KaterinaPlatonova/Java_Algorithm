public class Item {

    private final int data; // переменная для хранения данных

    private Item nextItem; // переменная для хранения ссылки на следующий элемент Связанного списка

    public Item(int data) { // при создании объекта типа Item будут переданы данные, которые будут храниться в переменной
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public Item getNextItem() {
        return nextItem;
    }

    public void setNextItem(Item nextItem) {
        this.nextItem = nextItem;
    }

    @Override
    public String toString() {
        return String.valueOf(data); // вывод
    }
}
