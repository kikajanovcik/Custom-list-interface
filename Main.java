public class Main {

    public static void main(String[] args) {

        MyList<String> list = new MyListImpl<String>();
        String zeroIndexNode = "index zero";
        String oneIndexNode = "index one";
        String twoIndexNode = "index two";
        String threeIndexNode = "index three";

        System.out.println("This is an empty list");
        System.out.println("List size: " + list.size());
        System.out.println("Is the list empty? " + list.isEmpty());

        System.out.println("Now we added more nodes");
        list.add(zeroIndexNode);
        list.add(oneIndexNode);
        list.add(twoIndexNode);
        list.add(threeIndexNode);
        System.out.println("Is the list empty? " + list.isEmpty() + ", it has size of: " + list.size());

        System.out.println("\nThis is node with value: " + list.get(1).getValue());
        System.out.println("Now we remove node at index 1 with list.remove(1)");
        list.remove(1);
        System.out.println("New value of node on index one is: " + list.get(1).getValue());

        System.out.println("should print true: " + list.contains("index zero"));
        System.out.println("should print false: " + list.contains("index one"));

        System.out.println("should print 1: " + list.indexOf("index two"));
        System.out.println("should print -1: " + list.indexOf("index one"));
    }
}