
public interface MyList<T> {

    int size();

    void add(T elem);

    MyNode<T> get(int index);

    boolean isEmpty();

    void remove(int index);

    boolean contains(T elem);

    int indexOf(T elem);
}
