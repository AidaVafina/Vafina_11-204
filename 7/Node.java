class Node{
    int value;
    Node left;
    Node right;
    Node parent;
    public Node(int value){
        this.value = value;
        this.left = null;
        this.right = null;
        Node parent = null;
    }

    public Object left() {
        return left;
    }

    public Object right() {
        return right;
    }
}