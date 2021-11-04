import java.util.LinkedList;

public class Driver {
    public static void main(String[] args) {
        // Creating an empty LinkedList
        MyLinkedList<String> list = new MyLinkedList<String>();
        // Use add() method to add elements in the list
        list.add(0,"Geeks");
        list.add(1,"for");
        list.add(2,"10000");
        list.add(3,"10");
        list.add(4,"20");
      //  list.add(5,"YA");

        // Displaying the list
        System.out.println("LinkedList:" + list);

        // Remove the tail using removeLast()
        System.out.println("The first element is removed: " + list.removeFirst());
        System.out.println("The first element is removed: " + list.removeFirst());
        System.out.println("The last element is removed: " + list.removeLast());
        System.out.println("The last element is removed: " + list.removeLast());

        // Displaying the final list       System.out.println("Final LinkedList:" + list);

        // Remove the tail using removeLast()
        //System.out.println("The last element is removed: " + list.removeFirst());

        // Displaying the final list
        System.out.println("Final LinkedList:" + list);

    }
}
