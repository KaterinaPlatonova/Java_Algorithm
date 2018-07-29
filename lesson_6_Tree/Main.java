package geek;

import java.util.Random;

public class Main {
    static Random rand = new Random();

    public static void main(String[] args) {
        int x;
        for (int i = 0; i < 20; i++) {
           Tree tree = new TreeImpl();

            for (int j = 0; j < 15; j++) {
                x = rand.nextInt(21);
                addNode(tree, x);
            }
            tree.traverse(Tree.TraverseMode.PRE_ORDER);
            System.out.println("*************************");
        }
    }

    private static void addNode(Tree tree, int id) {
        Person person = new Person("Person", id);
        tree.insert(person);
    }

}
