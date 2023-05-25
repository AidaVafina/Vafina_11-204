import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> l = Arrays.asList(4,2,6,11,8,5,23,5);
        Tree tree = new Tree(l);
        System.out.println(tree);
        System.out.println(tree.remove(4));
        System.out.println(tree);
    }
}
