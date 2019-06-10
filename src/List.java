import org.w3c.dom.Node;

public interface List<E> {
    void addLast(E value);
    void addFist(E value);
    E getIndex(int index);
}

//
//        food1.next=food2;
//        food2.prev=food1;
//        food2.next=food3;
//        food3.prev=food2;

//        Node currentNode = food1;
//        while (currentNode != null) {
//            System.out.println(currentNode.item);
//            currentNode = currentNode.next;


