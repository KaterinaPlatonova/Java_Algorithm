public class BackpackMain {

    public static void main(String[] args) {
        Anagramm anagramm = new Anagramm();

        Item item1 = new Item("pen", 1, 10);
        Item item2 = new Item("book", 2, 60);
        Item item3 = new Item("notebook", 5, 4000);

        anagramm.fillUpAArray(item1);
        anagramm.fillUpAArray(item2);
        anagramm.fillUpAArray(item3);

        anagramm.getAnagramm();
    }

}
