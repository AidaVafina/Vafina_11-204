import java.util.ArrayList;
import java.util.Collection;

public class Main {
    public static void main(String[] args) {
        Collection<Integer> trees = new ArrayList<>();
        trees.add(1);
        trees.add(2);
        trees.add(3);
        trees.add(9);
        trees.add(6);
        Tree tree = new Tree(trees);
        System.out.println(tree.get(2).toString());
    }
}
