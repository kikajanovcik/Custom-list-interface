
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

            get(index).setValue(null);
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
        if (size > 0 ) {
            MyNode<T> newNode = new MyNode<T>(elem);
            MyNode<T> myNode = firstNode;

            while (myNode.getNext() != null) {
                myNode = myNode.getNext();
                if (newNode.equals(myNode)) {
                    return true;
                }
            }
            if (newNode.equals(firstNode)) {
                return true;
            }
        }
        return false;
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

    public int countRepetition(T elem) {
        int count = 0;

        MyNode<T> node = new MyNode<T>(elem);
        MyNode<T> myNode = firstNode;

        while (myNode.getNext() != null) {
            myNode = myNode.getNext();
            if (node.equals(myNode)) {
                count++;
            }
        }
        if (node.equals(firstNode)) {
            count++;
        }

        return count;
    }

    public boolean hasDuplicates() {
        MyListImpl<T> duplicates = listDuplicates();
        return listDuplicates().size() > 0;
    }

    public MyListImpl<T> listDuplicates() {
        MyListImpl<T> duplicates = new MyListImpl<T>();
        if(size > 0) {
            MyNode<T> myNode = firstNode;

            int count = countRepetition(firstNode.getValue());
            if (count >= 2) {
               duplicates.add(firstNode.getValue());
            }

            while (myNode.getNext() != null) {
                myNode = myNode.getNext();
                count = countRepetition(myNode.getValue());

                if (count >= 2 && !(duplicates.contains(myNode.getValue()))) {
                    duplicates.add(myNode.getValue());
                }
            }
        }
        return duplicates;
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
    // return list [start, end]
}
