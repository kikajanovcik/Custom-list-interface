
public interface MyList<T> {

    int size();

    void add(MyNode node);

    MyNode get(int index);

    boolean isEmpty();

    void remove(int index);

    boolean contains(MyNode node);
}
