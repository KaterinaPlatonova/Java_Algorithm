package geek;

public class Node {

    private Person person;

    private Node leftChild;
    private Node rightChild;

    public Node(Person person) {
        this.person = person;
    }

    public Person getPerson() {
        return person;
    }

    public Node getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(Node leftChild) {
        this.leftChild = leftChild;
    }

    public Node getRightChild() {
        return rightChild;
    }

    public boolean isLeft(int key) {
        return key < getKey();
    }

    public boolean isRight(int key) {
        return !isLeft(key);
    }

    public boolean isLeaf() {
        return leftChild == null && rightChild == null;
    }

    protected boolean deleteChild(Node child) {
        if (leftChild == child) {
            leftChild = null;
            return true;
        } else if (rightChild == child) {
            rightChild = null;
            return true;
        }
        return false;
    }

    public boolean hasOnlyOneChild() {
        return leftChild != null ^ rightChild != null;
    }

    public void setRightChild(Node rightChild) {
        this.rightChild = rightChild;
    }

    public int getKey() {
        return person.getId(); //метод получающий ключ (id) поступившего объекта
    }

    public void display() {
        System.out.println(person); //метод вывода в одну строку указан в классе Person
    }
}
