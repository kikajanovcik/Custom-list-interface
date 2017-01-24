
public class MyListImpl<T> implements MyList<T> {

    private MyNode<T> firstNode;
    private MyNode<T> lastNode;
    private int size = 0;

    public  MyListImpl() {}

    public int size() {
        return size;
    }

    public void add(T elem) {
        MyNode<T> newNode = new MyNode<T>(elem);

        if (size == 0) {
            firstNode = newNode;
        } else {
            MyNode<T> prevNode = lastNode;
            prevNode.setNext(newNode);
        }
        lastNode = newNode;
        size++;
    }

    public MyNode<T> get(int index) {

        MyNode<T> myNode = null;

        if (index >= 0 && index < size) {
            myNode = firstNode;
            for (int i = 0 ; i < index; i++) {
                myNode = myNode.getNext();
            }
        }
        return myNode;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void remove(int index) {
        if (index >= 0 && index < size) {
            // if node to be removed has a previous node and a node afterwards, fill the gap
            if (hasPrevious(index) && hasNext(index)) {
                MyNode<T> prevNode = get(index - 1);
                MyNode<T> nextNode = get(index + 1);
                prevNode.setNext(nextNode);
            } else {
                // if node to be removed has index 0 and a node afterwards, set that node as the first node
                if (hasNext(index)) {
                    firstNode = get(1);
                }
            }
            size--;
        }
    }

    public boolean contains(T elem) {

        MyNode<T> newNode = new MyNode<T>(elem);
        MyNode<T> myNode = firstNode;
        boolean nodeIsPresent = false;

        while (myNode.getNext() != null) {
            myNode = myNode.getNext();
            if (newNode.equals(myNode)) {
                nodeIsPresent = true;
            }
        }
        if (newNode.equals(firstNode)){
            nodeIsPresent = true;
        }
        return nodeIsPresent;
    }

    public int indexOf(T elem) {
        int index = 0;
        MyNode<T> myNode = firstNode;

        for(int i = 0; i < size; i++) {
            if (!(myNode.getValue().equals(elem))) {
                index++;
                if (myNode.getNext() != null) {
                    myNode = myNode.getNext();
                }
            }
        }
        if (index == size ) { index = -1; }

        return index;
    }

    private boolean hasPrevious(int index) {
        return get(index - 1) != null;
    }

    private boolean hasNext(int index) {
        return get(index + 1) != null;
    }

    //TODO more methods to add
    // reverse order
    // filtering if int by number?
    // sort if String by alphabet?
    // show duplicates & boolean containsDuplicates
    // count occurencies of T elem
    // return list [start, end]
}
