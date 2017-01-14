public class Main {

    public static void main(String[] args) {

        MyListImpl<MyNode> list = new MyListImpl<MyNode>();
        MyNode zeroIndexNode = new MyNode();
        MyNode oneIndexNode = new MyNode();
        MyNode twoIndexNode = new MyNode();
        MyNode threeIndexNode = new MyNode();

        System.out.println("This is an empty list");
        System.out.println("List size: " + list.size());
        System.out.println("Is the list empty? " + list.isEmpty());

        System.out.println("Now we added more nodes");
        list.add(zeroIndexNode);
        list.add(oneIndexNode);
        list.add(twoIndexNode);
        list.add(threeIndexNode);
        System.out.println("Is the list empty? " + list.isEmpty() + ", it has size of: " + list.size());

        System.out.println("\nThis is 'twoIndexNode' " + twoIndexNode + " with index of " + twoIndexNode.getIndex());
        System.out.print("This node we got by calling list.get(2): ");
        System.out.println(list.get(2) + " with index of " + list.get(2).getIndex());

        list.remove(1);
        System.out.println("\nThis is threeIndexNode's new index after removing one node: " + threeIndexNode.getIndex());
        list.remove(1);
        System.out.println("This is threeIndexNode's new index after removing another node: " + threeIndexNode.getIndex());

        System.out.println("\nDoes list contain a oneIndexNode? (should be false) " + list.contains(oneIndexNode));
        System.out.println("Does list contain a threeIndexNode? (should be true) " + list.contains(threeIndexNode));
    }
}