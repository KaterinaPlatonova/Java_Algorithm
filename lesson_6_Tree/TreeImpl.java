package geek;

public class TreeImpl implements Tree {

    private Node root;
    private int currentSize;

    private class RemovedElementAndParent {
        Node removedElement;
        Node parent;
    }


    @Override
    public void insert(Person person) {
        Node newNode = new Node(person);
        int key = newNode.getKey();

        Node parent = findParentForInsert(key);

        if (parent == null) {
            root = newNode;
        } else {
            if (parent.isLeft(key)) {
                parent.setLeftChild(newNode);
            } else {
                parent.setRightChild(newNode);
            }
        }
        currentSize++;
    }


    public Node findParentForInsert(int key) { // метод для поиска родительского узла
        Node currentNode = root;
        Node parent = null;

        RemovedElementAndParent elementAndParent = new RemovedElementAndParent();
        elementAndParent.removedElement = currentNode;
        elementAndParent.parent = parent;

        while (currentNode != null) {
            parent = currentNode;
            if (currentNode.isRight(key)) {
                currentNode = currentNode.getRightChild();
            } else {
                currentNode = currentNode.getLeftChild();
            }
        }
        return parent;
    }

    private RemovedElementAndParent findRemovedElementAndParent(int key) {
        RemovedElementAndParent elementAndParent = new RemovedElementAndParent();
        elementAndParent.removedElement = root;
        elementAndParent.parent = null;

        while (elementAndParent.removedElement != null) {
            if (elementAndParent.removedElement.getKey() == key) {
                break;
            }

            elementAndParent.parent = elementAndParent.removedElement;
            if (elementAndParent.removedElement.isRight(key)) {
                elementAndParent.removedElement = elementAndParent.removedElement.getRightChild();
            } else {
                elementAndParent.removedElement = elementAndParent.removedElement.getLeftChild();
            }
        }
        return elementAndParent;
    }

    @Override
    public boolean remove(int key) {
        RemovedElementAndParent elementAndParent = findRemovedElementAndParent(key);

        if (elementAndParent.removedElement == null) {
            return false;//Элемент не найден, удалять нечего
        }

        Node removedNode = elementAndParent.removedElement;
        Node parent = elementAndParent.parent;

        if (removedNode.isLeaf()) {
            removeLeafNode(removedNode, parent);
        } else if (removedNode.hasOnlyOneChild()) {
            removeNodeWithOnlyOneChild(removedNode, parent);
        } else {
            removeNodeWithBothChild(removedNode, parent);
        }

        currentSize--;
        return true;
    }

    private void removeNodeWithBothChild(Node removedNode, Node parent) {
        Node successor = getSuccessor(removedNode);
        if (removedNode == root) {
            root = successor;
        } else if (parent.getLeftChild() == removedNode) {
            parent.setLeftChild(successor);
        } else {
            parent.setRightChild(successor);
        }
        successor.setLeftChild(removedNode.getLeftChild());
        if (successor != removedNode.getRightChild()) {
            successor.setRightChild(removedNode.getRightChild());
        }
    }

    private void removeNodeWithOnlyOneChild(Node removedNode, Node parent) {
        Node removeChildNode = getSingleChildNode(removedNode);

        if (removedNode == root) {
            root = removeChildNode;
        } else if (parent.getLeftChild() == removedNode) {
            parent.setLeftChild(removeChildNode);
        } else {
            parent.setRightChild(removeChildNode);
        }
    }

    private Node getSingleChildNode(Node removedNode) {
        return removedNode.getLeftChild() != null ? removedNode.getLeftChild() : removedNode.getRightChild();
    }

    private void removeLeafNode(Node removedNode, Node parent) {
        if (removedNode == root) {
            root = null;
        } else {
            parent.deleteChild(removedNode);
        }
    }

    private Node getSuccessor(Node node) {
        Node successorParent = null;// родитель элемента, который пойдет под замену удаляемому
        Node successor = node; // элемент, который пойдет под замену удаляемому
        Node current = node.getRightChild();//начальный элемент для навигации

        while (current != null) {
            successorParent = successor;
            successor = current;
            current = current.getLeftChild();
        }

        if (successor != node.getRightChild()) {
            //Дочерние элементы successor, отдаем его родителю
            successorParent.setLeftChild(successor.getRightChild());
        }

        return successor;
    }

    @Override
    public Person find(int key) {
        Node currentNode = root; //создаем переменную для хранения стартового элемента

        while (currentNode != null) {
            if (currentNode.getKey() == key) {
                return currentNode.getPerson(); // если сразу нашли искомый элемент, выводим его
            }
            if (currentNode.isRight(key)) { // движение по дереву Если искомый ключ БОЛЬШЕ ключа узла, то двигаться - ВПРАВО
                currentNode = currentNode.getRightChild();
            } else {
                currentNode = currentNode.getLeftChild(); //движение по дереву Если искомый ключ МЕНЬШЕ ключа узла, то двигаться - ВЛЕВО
            }
        }
        return null;
    }

    @Override
    public int getSize() {
        return currentSize;
    }

    @Override
    public boolean isEmpty() {
        return root == null;
    }

    @Override
    public Person getRoot() {
        return root.getPerson();
    }

    @Override
    public boolean traverse(TraverseMode traverseMode) {
        switch (traverseMode) {
            case PRE_ORDER: // ПРЯМОЙ ОБХОД
                preOrder(root);
                break;
            case POST_ORDER: // ОБРАТНЫЙ ОБХОД
                postOrder(root);
                break;
            case IN_ORDER: // СИММЕТРИЧНЫЙ ОБХОД
                inOrder(root);
                break;
            case isBalanced:
                isBalanced(root);
                break;
            default:
                throw new IllegalArgumentException("Unknown traverse mode: " + traverseMode);
        }
        return false;
    }

    private void preOrder(Node node) { // ПРЯМОЙ ОБХОД
        if (node != null) {
            node.display();
            preOrder(node.getLeftChild());
            preOrder(node.getRightChild());
        }
    }

    private void postOrder(Node node) { // ОБРАТНЫЙ ОБХОД
        if (node != null) {
            preOrder(node.getLeftChild());
            preOrder(node.getRightChild());
            node.display();
        }
    }

    private void inOrder(Node node) { // СИММЕТРИЧНЫЙ ОБХОД
        if (node != null) {
            preOrder(node.getLeftChild());
            node.display();
            preOrder(node.getRightChild());
        }
    }

    @Override
    public boolean isBalanced(Node node) {
        return (node == null) ||
                isBalanced(node.getLeftChild()) &&
                        isBalanced(node.getRightChild()) &&
                        Math.abs(height(node.getLeftChild()) - height(node.getRightChild())) <= 1;
    }

    private int height(Node node) {
        return node == null ? 0 : 1 + Math.max(height(node.getLeftChild()), height(node.getRightChild()));
    }

}
