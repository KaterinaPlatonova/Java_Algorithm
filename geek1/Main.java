package geek1;

public class Main {

    public static void main(String[] args) {

        Backpack backpack = new Backpack();

        backpack.fillUpAArray(new Item("pen", 1, 10));
        backpack.fillUpAArray(new Item("book", 2, 60));
        backpack.fillUpAArray(new Item("notebook", 5, 4000));

        Anagramm anagramm = new Anagramm( backpack.getItems(), backpack.getItems().length );
        anagramm.getAnagramm();

//        backpack.checkTheKit( anagramm.getCurrentKit() );
    }
}
