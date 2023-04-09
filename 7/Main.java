public class Main {
    public static void main(String[] args) {
        ModifiedTree modifiedTree = new ModifiedTree();
        modifiedTree.add(8);
        modifiedTree.add(3);
        modifiedTree.add(32);
        modifiedTree.add(9);
        modifiedTree.add(10);
        modifiedTree.add(5);
        modifiedTree.add(20);
        modifiedTree.printTree();
        modifiedTree.get(25);
    }
}
