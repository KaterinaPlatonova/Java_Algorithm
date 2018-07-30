package geek;

public interface Tree {

    enum TraverseMode {
        PRE_ORDER, //прямой обход
        POST_ORDER, //обратный обход
        IN_ORDER, isBalanced, //симметричный обход
    }

    void insert(Person person);

    boolean remove(int key);

    Person find(int key);

    int getSize();

    boolean isEmpty();

    Person getRoot();

    boolean traverse(TraverseMode traverseMode);

    boolean isBalanced(Node node);

}
