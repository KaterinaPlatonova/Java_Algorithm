package geek1;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        Item[] items = {new Item("pen", 1, 10),
                new Item("book", 2, 60),
                new Item("notebook", 5, 4000)
        };

        Backpack backpack = new Backpack(items, 6);
        System.out.println("Best set is: " + backpack.getBestSet());

    }
}
