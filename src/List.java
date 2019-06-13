import org.w3c.dom.Node;

public interface List<E> {
    void add(E value);

    void add(E value, int index);

    void addAll(List<E> list);

    E get(int index);

    void set(E value, int index);

    E remove(int index);

    E remove(E t);

    int size();

    boolean isEmpty();
}
