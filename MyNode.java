public class MyNode<T> {

    private int index;
    private MyNode prev;
    private MyNode next;

    public MyNode() {
        this.prev = null;
        this.next = null;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getIndex() {
        return index;
    }

    public void setPrev(MyNode prev) {
        this.prev = prev;
    }

    public MyNode getPrev() {
        return prev;
    }

    public void setNext(MyNode next) {
        this.next = next;
    }

    public MyNode getNext() {
        return next;
    }
}
