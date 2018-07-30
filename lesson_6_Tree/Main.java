package geek;

import java.util.Random;

public class Main {
    
    static Random rand = new Random();
    static Tree[] treeArray = new Tree[20];

    public static void main(String[] args) {
        int x;
        for (int i = 0; i < treeArray.length; i++) {
            Tree tree = new TreeImpl();

            for (int j = 0; j < 4; j++) {
                x = rand.nextInt(31) - 10;
                addNode(tree, x);
            }
            treeArray[i] = tree;
            System.out.println("---Дерево " + (i + 1) + " ---");
            treeArray[i].traverse(Tree.TraverseMode.IN_ORDER); // СИММЕТРИЧНЫЙ ОБХОД

//            tree.traverse(Tree.TraverseMode.PRE_ORDER); // ПРЯМОЙ ОБХОД
//            tree.traverse(Tree.TraverseMode.POST_ORDER); // ОБРАТНЫЙ ОБХОД
        }
        System.out.println("---Результаты сбалансированности деревьев в массиве---");
        for (int i = 0; i < treeArray.length; i++) {
            boolean n = treeArray[i].traverse(Tree.TraverseMode.isBalanced);
            System.out.println("Дерево " + (i + 1) + " сбалансировано: " + n);
        }
    }

    private static void addNode(Tree tree, int id) {
        Person person = new Person("Person", id);
        tree.insert(person);
    }
}
