package geek1;

import java.util.Arrays;

public class Anagramm {

    protected int size;
    protected Item[] items;
    private Item[] currentKit;

    public Anagramm(Item[] items, int size) {
        this.items = items;
        this.size = size;
    }

    public Item[] getCurrentKit() {
        return currentKit;
    }

    public void getAnagramm() {
        getAnagramm(items);
    }

    private void getAnagramm(Item[] items) { //int currentSize
        if (items.length == 1) {
            return;
        }

        for (int i = 0; i < size; i++) {
            getAnagramm(items[i -1]);
            display();
            rotate(items);
        }
    }

    private void rotate(Item[] items) {//int currentSize
        int pos = items.length - size;// ??
        Item temp = items[pos];
        for (int i = pos + 1; i < size; i++) {
            items[i - 1] = items[i];
        }
        items[pos - 1] = temp;

    }

    private void display() {
        for (int i = 0; i < size; i++) {
            System.out.print(items[i].getName() + " " + items[i].getWeight() + " " + items[i].getPrice());
        }
        System.out.println(" ");
    }
}
