import java.util.Arrays;

public class Anagramm {

    protected Item currentItem;
    protected int size;
    public Item[] items = new Item[3];


    public Anagramm() {
    }

    protected void fillUpAArray(Item currentItem) {
        for (int i = 0; i < items.length; i++) {
            items[i] = currentItem;
        }
    }

    public void getAnagramm() {
        for (int i = 0; i < items.length; i++) {
            getAnagramm(items[i]); // передавать массив и убрать цикл
        }
    }

    private void getAnagramm(Item currentItem) {
        if (currentItem == items.length) { // передавать массив?
            return;
        }

        for (int i = items.length; i >= 0; i++) {
            getAnagramm(items[i - 1]);
            display();
            rotate();
        }
    }

    private void rotate() { // я запуталась!!!!
        int pos = items.length - 1;
        Item temp = items[pos];
        for (int i = pos + 1; i >= 0; i++) {
            items[i - 1] = items[i];
        }
        items[pos - 1] = temp;

    }

    private void display() {
        for (int i = 0; i < items.length; i++) {
            System.out.println(Arrays.toString(items));
        }
        System.out.println(" ");
    }
}
