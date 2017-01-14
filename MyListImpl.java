
public class MyListImpl<T> implements MyList<T> {

    private MyNode node;
    private int size = 0;

    public  MyListImpl() {}

    public int size() {
        return size;
    }

    public void add(MyNode newNode) {
        if (size > 0) {
            MyNode prevNode = this.node;
            newNode.setPrev(prevNode);
            prevNode.setNext(newNode);
        }
        newNode.setIndex(size);
        this.node = newNode;
        size++;
    }

    public MyNode get(int index) {
        if (index > 0) {
            MyNode current = this.node;
            MyNode myNode = null;
            for (int i = 0 ; i < size; i++) {
                if (current != null) {

                    // tried it with equals but Java didnt let me do it :(
                    // this way it still returns object though ?

                    if (current.getIndex() == index) {
                        myNode = current;
                    }
                }
                current = current.getPrev();
            }
            return myNode;
        } else {
            return null;
        }
    }

    public boolean isEmpty() {
        if (size == 0) {
            return true;
        } else {
            return false;
        }
    }

    public void remove(int index) {
        if (index > 0 && index < size) {

            MyNode nodeToRemove = get(index);

            if (nodeToRemove.getNext() != null) {

                MyNode nextNode = nodeToRemove.getNext();
                if (nodeToRemove.getPrev() != null) {
                    nextNode.setPrev(nodeToRemove.getPrev());
                }

                //is there a way to set it otherwise?
                //on the other hand, I always check is something is in an array by checking if index is < 0 ...
                nodeToRemove.setIndex(-1);
                nextNode.setIndex(index);

                for (int i = index ; i < (size - 1) ; i++) {
                    if (nextNode.getNext() != null) {
                        index++;
                        nextNode.getNext().setIndex(index);
                    }
                    nextNode = nextNode.getNext();
                }
            }
            size--;
        }
    }

    public boolean contains(MyNode myNode) {
        int myNodeIndex = myNode.getIndex();
        if (get(myNodeIndex) != null) {
            return true;
        } else {
            return false;
        }
    }
}
