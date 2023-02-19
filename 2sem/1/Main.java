import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Node<String> node1 = new Node<>();
        Node<String> node2 = new Node<>();
        Node<String> node3 = new Node<>();
        MyLinkedList<String> list1 = new MyLinkedList<>(node1);
        MyLinkedList<String> list2 = new MyLinkedList<>(node2);
        MyLinkedList<String> list3 = new MyLinkedList<>(node3);

        list1.add("hi");
        list1.add("hello");
        list1.add("bonjour");
        list2.add("bye");
        list2.add("adios");

        System.out.println(list1.toString());
        System.out.println(list2.toString());

        list1.addAll(list2);
        System.out.println(list1);

        System.out.println(list1.contains("hi"));

        System.out.println(list1.indexOf("hello"));

        System.out.println(list1.remove(5));
        System.out.println(list1.toString());

        list2.clear();
        System.out.println(list2);

        System.out.println(list1.set(5,"popopo"));
        System.out.println(list1.toString());

        Object[] a = list1.toArray();
        System.out.println(Arrays.toString(a));

        list1.add("hi");
        System.out.println(list1);
        System.out.println(list1.lastIndexOf("hi"));
    }
}


