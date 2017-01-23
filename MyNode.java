public class MyNode<T> {

    private T value;
    private MyNode<T> next;

    public MyNode(T value) {
        this.next = null;
        this.value = value;
    }

    public void setNext(MyNode<T> next) {
        this.next = next;
    }

    public MyNode<T> getNext() {
        return next;
    }

    public T getValue() {
        return value;
    }

    @Override
    public boolean equals(Object obj) {
        MyNode<T> nodeObject = (MyNode) obj;
        return this.getValue().equals(nodeObject.getValue());
    }

    @Override
    public int hashCode() {
        return getValue().hashCode();
    }
}