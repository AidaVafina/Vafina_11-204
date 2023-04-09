import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ModifiedTree {
    private int value;
    private ModifiedTree parent;
    private List<ModifiedTree> children;
    Node rootNode; // корневой узел
    public ModifiedTree() { // пустое дерево
        rootNode = null;
    }

    public ModifiedTree(int value, ModifiedTree parent) {
        this.value = value;
        this.parent = parent;
        this.children = new ArrayList<ModifiedTree>();
    }

    public ModifiedTree add(int value) {
        Node newNode = new Node(value);
        if (rootNode == null) {
            rootNode = newNode;
        } else {
            insertNode(rootNode, newNode);
        }
        ModifiedTree tree = new ModifiedTree();
        tree.rootNode = newNode;
        return tree;
    }

    private void insertNode(Node node, Node newNode) {
        if (newNode.value < node.value) {
            if (node.left == null) {
                node.left = newNode;
                newNode.parent = node;
            } else {
                insertNode(node.left, newNode);
            }
        } else {
            if (node.right == null) {
                node.right = newNode;
                newNode.parent = node;
            } else {
                insertNode(node.right, newNode);
            }
        }
    }

    public ModifiedTree get(int value) {
        if (this.value == value) {
            return this;
        }

        for (ModifiedTree child : children) {
            ModifiedTree result = child.get(value);
            if (result != null) {
                return result;
            }
        }

        return null;
    }

    public void addChild(int value) {
        ModifiedTree child = new ModifiedTree(value, this);
        children.add(child);
    }

    public void printTree() {
        Stack globalStack = new Stack();
        globalStack.push(rootNode);
        int gaps = 32;
        boolean isRowEmpty = false;
        String separator = "-----------------------------------------------------------------";
        System.out.println(separator);
        while (isRowEmpty == false) {
            Stack localStack = new Stack();
            isRowEmpty = true;

            for (int j = 0; j < gaps; j++)
                System.out.print(' ');
            while (globalStack.isEmpty() == false) {
                Node temp = (Node) globalStack.pop();
                if (temp != null) {
                    System.out.print(temp.value);
                    localStack.push(temp.left());
                    localStack.push(temp.right());
                    if (temp.left != null ||
                            temp.right != null)
                        isRowEmpty = false;
                }
                else {
                    System.out.print("__");
                    localStack.push(null);
                    localStack.push(null);
                }
                for (int j = 0; j < gaps * 2 - 2; j++)
                    System.out.print(' ');
            }
            System.out.println();
            gaps /= 2;
            while (localStack.isEmpty() == false)
                globalStack.push(localStack.pop());
        }
        System.out.println(separator);
    }

}
