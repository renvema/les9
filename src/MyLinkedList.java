import org.w3c.dom.Node;

import java.util.LinkedList;

public class MyLinkedList<E> implements List<E> {

    public static void main(String[] args) {
        MyLinkedList food = new MyLinkedList();
        food.addLast("pizza");
        food.addLast("tiramisu");
        food.addLast("pasta");
        food.addLast("frittura mista");
        food.addLast("ice cream");
        food.addFist("chicheti");
        System.out.println(food.size);
        System.out.println(food.getIndex(0));
    }

    private Node<E> firstNode;
    private Node<E> lastNode;
    private int size = 0;

    public MyLinkedList() {
        lastNode = new Node<E>(null, firstNode, null);
        firstNode = new Node<E>(null, null, lastNode);
    }

    @Override
    public void addLast(E value) {
        Node<E> prev = lastNode;
        prev.setItem(value);
        lastNode = new Node<E>(null, prev, null);
        prev.setNext(firstNode);
        size++;
    }
    @Override
    public void addFist(E value) {
        Node<E> next = firstNode;
        next.setItem(value);
        firstNode = new Node<E>(null, null, next);
        next.setNext(firstNode);
        size++;
    }

    @Override
    public E getIndex(int index) {
        Node<E> target = firstNode.getNext();
        for (int i = 0; i < index; i++) {
            target = get(target);
        }
        return target.getItem();
    }


    private Node<E> get(Node<E> current) {
        return current.getNext();
    }

    private class Node<E> {
        private E item;
        private Node<E> next;
        private Node<E> prev;

        private Node(E element, Node<E> prev, Node<E> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }

        public E getItem() {
            return item;
        }

        public void setItem(E item) {
            this.item = item;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setNext(Node<E> next) {
            this.next = next;
        }

        public Node<E> getPrev() {
            return prev;
        }

        public void setPrev(Node<E> prev) {
            this.prev = prev;
        }
    }

}
