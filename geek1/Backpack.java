package geek1;

public class Backpack {

    private Item[] items = new Item[3];

    private final int weightPack;
    int maxPrice;

    public Backpack() {
        weightPack = 6;
        this.maxPrice = 0;
    }

    protected void fillUpAArray(Item currentItem) {
        for (int i = 0; i < items.length; i++) {
            items[i] = currentItem;
        }
    }

//    void checkTheKit(Item[] currentKit){
//        if (currentKit)
//
//    }


    public Item[] getItems() {
        return items;
    }
}
