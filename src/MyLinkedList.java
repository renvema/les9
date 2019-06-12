import org.w3c.dom.Node;

import java.util.LinkedList;

public class MyLinkedList<E> implements List<E> {

    private Node<E> firstNode;
    private Node<E> lastNode;
    private int size = 0;


    @Override
    public void add(E value) {
        Node<E> node = new Node(value, null, null);
        if (isEmpty()) {
            firstNode = node;
            lastNode = node;
        } else {
            node.prev = lastNode;
            lastNode.next = node;
            lastNode = node;
        }
        size++;
    }

    @Override
    public void add(E value, int index) {
        Node<E> node = new Node(value, null, null);
        if (isEmpty() || index == size) {
            add(value);
        } else {
            Node<E> temp = findIndex(index);
            node.prev = temp.next;
            temp.prev.next = node;
            node.next = temp;
            temp.next.prev = node;

//            node.prev=findIndex(index+1);
//            findIndex(index-1).next=node;
//
//            node.next=findIndex(index);
//            findIndex(index+1).prev=node;

        }
        size++;
    }

    @Override
    public void addAll(List<E> list) {
        for (int i = 0; i < list.size(); i++) {
            add(list.get(i));
        }
    }


    private Node<E> findIndex(int index) {
        checkSize(index);
        Node<E> node = firstNode;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }

    public E get(int index) {
        return findIndex(index).item;

    }

    @Override
    public void set(E value, int index) {
        findIndex(index).item = value;
    }

    @Override
    public E remove(int index) {
        findIndex(index).item = null;
        if (index == size()) {
            lastNode = findIndex(index - 1);
        } else if (index == 0) {
            firstNode = findIndex(index + 1);
        } else {
            findIndex(index - 1).next = findIndex(index + 1);
        }
        size--;
        return null;
    }

    @Override
    public E remove(E t) {
        for (int i = 0; i < size; i++) {
            if (get(i).equals(t)) {
                remove(i);
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    public void checkSize(int index) {
        if ((index > size) || (index < 0)) {
            throw new IllegalArgumentException();
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private class Node<E> {
        protected E item;
        protected Node<E> next;
        protected Node<E> prev;

        private Node(E item, Node<E> prev, Node<E> next) {
            this.item = item;
            this.next = next;
            this.prev = prev;
        }
    }
}
