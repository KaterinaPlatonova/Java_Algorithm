package geek1;

import java.util.ArrayList;
import java.util.List;

public class Backpack {

    private Item[] items;
    private int weightBackpack; // вместимость рюкзака

    private int maxPrice; // максимальная цена по набору
    private List<Item> bestSet;

    public Backpack(Item[] items, int weightBackpack) {
        this.weightBackpack = weightBackpack;
        this.items = items;
    }

    public List<Item> getBestSet() {
        return this.bestSet;
    }

    public void calculateBestSetOfItems() {
        doCalculate(items.length);
    }

    private void doCalculate(int currentSize) {
        if (currentSize == 1) {
            return;
        }

        for (int i = 0; i < currentSize; i++) {
            doCalculate(currentSize - 1);
            display();
            checkSet(currentSize);
            rotate(currentSize);
        }
    }

    private List<Item> checkSet(int currentSize) {
        List<Item> setCopy = new ArrayList<>(currentSize);
        for (int i = 0; i < currentSize; i++) {
            setCopy.add(items[i]);
        }

        int price1 = checkPriceSet(setCopy);
        int weight = checkWeightSet(setCopy);

        if (price1 > maxPrice && weight <= weightBackpack){
            maxPrice = price1;
            bestSet = setCopy;
        }
        return bestSet;
    }

    private int checkWeightSet(List<Item> setCopy) {
        int weight = 0;
        for (Item item: setCopy) {
            weight += item.getWeight();
        }
        return weight;
    }

    private int checkPriceSet(List<Item> setCopy) {
        int price = 0;
        for (Item item : setCopy) {
            price += item.getPrice();
        }
        return price;
    }

    private void rotate(int size) {
        int pos = items.length - size;
        Item temp = items[pos];
        for (int i = pos + 1; i < size; i++) {
            items[i - 1] = items[i];
        }
        items[pos - 1] = temp;
    }

    private void display() {
        for (int i = 0; i < items.length; i++) {
            System.out.print(items[i].getName() + " " + items[i].getWeight() + " " + items[i].getPrice());
        }
        System.out.println(" ");
    }
}
