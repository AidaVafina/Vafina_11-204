import lombok.*;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Tree {

    private int value;
    private Tree parent;
    private Tree left;
    private Tree right;


    public Tree(Collection<Integer> c) {
        for (Integer e : c) {
            add(e);
        }
    }

    public Tree add(int value) {
        if (this.value == 0 && left == null && right == null) {
            this.value = value;
            return this;
        }
        if (this.value > value) {
            return left == null ? left = Tree.builder().parent(this).value(value).build() : left.add(value);
        }
        else {
            return right == null ? right = Tree.builder().parent(this).value(value).build() : right.add(value);
        }
    }

    public Tree get(int value) {
        if (this.value == value) {
            return this;
        }
        else if (this.value > value) {
            return left == null ? null : left.get(value);
        }
        else {
            return right == null ? null : right.get(value);
        }
    }

    public boolean contains(int value) {
        return !(get(value) == null);
    }

    public static int sumDeep(Tree root) {
        Stack<Tree> stack = new Stack<>();
        stack.push(root);

        int summ = 0;

        while (!stack.isEmpty()) {
            Tree node = stack.pop();
            summ = summ + node.value;
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        return summ;
    }

    public static int sumWide(Tree root) {
        Queue<Tree> queue = new ArrayDeque<>();
        queue.add(root);
        int summ = 0;
        while (!queue.isEmpty()) {
            Tree node = queue.remove();
            summ += node.value;
            if (node.left != null) {
                queue.add(node.left);
            }

            if (node.right != null) {
                queue.add(node.right);
            }
        }
        return summ;
    }

    @Override
    public String toString() {
        Queue<Tree> queue = new ArrayDeque<>();
        queue.add(this);
        StringBuilder s = new StringBuilder();

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Tree node = queue.remove();

                if (node.parent == null || node.parent.parent == null) s.append(node.value).append(" ");
                else s.append(node.value).append("(").append(node.parent.value).append(") ");

                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            s.append("\n");
        }
        return s.toString();
    }

    public void printToFile(File file) {
        try {
            RandomAccessFile raf = new RandomAccessFile(file, "rw");
            raf.write(toString().getBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Tree remove(int value) {
        Tree node = get(value);

        if (node == null) return null;
        else if (node.left != null && node.right != null) {
            Tree replacing = node.right;
            while (replacing.left != null) replacing = replacing.left;
            node.value = replacing.value;
            return replacing.remove(replacing.value);
        }
        else if (node.left != null) {
            if (node.parent.left == node) node.parent.left = node.left;
            else node.parent.right = node.left;
            node.left.parent = node.parent;
            return node;
        }
        else if (node.right != null) {
            if (node.parent.left == node) node.parent.left = node.right;
            else node.parent.right = node.right;
            node.right.parent = node.parent;
            return node;
        }
        else {
            if (node.parent.left == node) node.parent.left = null;
            else node.parent.right = null;
            return node;
        }
    }

    public static void main(String[] args) {
        List<Integer> l = Arrays.asList(3, 1, 9, 7, 10, 1, 6, 8);
        Tree tree = new Tree(l);
        System.out.println(tree);
        System.out.println(tree.remove(3));
        System.out.println(tree);
    }
}