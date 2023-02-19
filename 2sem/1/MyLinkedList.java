import java.util.Arrays;

public class MyLinkedList<T> {
    private Node<T> firstNode;
    public int size;

    public MyLinkedList(Node<T> firstNode) {
        this.firstNode = firstNode;
    }

    public boolean add(T elem) {
        Node<T> currentNode = firstNode;
        Node<T> newNode = new Node<>();
        newNode.setValue(elem);
        if (currentNode == null) {
            currentNode = newNode;
        } else {
            while (currentNode.getNext() != null) {
                currentNode = currentNode.getNext();
            }
            newNode.setValue(elem);
            currentNode.setNext(newNode);
        }
        size++;
        return true;
    }

    public Object[] toArray() {
        Object[] array = new Object[size()];
        Node<T> currentNode = firstNode;
        for (int i = 0; i < size(); i++) {
            array[i] = currentNode.getValue();
            currentNode = currentNode.getNext();
        }
        return array;
    }

    public boolean addAll(MyLinkedList<T> otherList) {
        Node<T> currentNode = firstNode;
        for (currentNode = otherList.firstNode; currentNode != null; currentNode = currentNode.getNext()) {
            add(currentNode.getValue());
        }
        return true;
    }

    public void clear() {
        firstNode = new Node<>();
    }

    public boolean contains(T s) {
        Node<T> currentNode = firstNode;
        while (currentNode.getNext() != null) {
            if (currentNode.getValue() == s) {
                return true;
            } else {
                currentNode = currentNode.getNext();
            }
        }
        return false;
    }

    public int indexOf(T s) {
        int ind = 0;
        Node<T> currentNode = firstNode;
        while (currentNode.getNext() != null) {
            if (currentNode.getValue() == s) {
                return ind;
            } else {
                ind++;
                currentNode = currentNode.getNext();
            }
        }
        return 0;
    }

    public T remove(int index) {
        T elem = firstNode.getValue();
        if (index == 0) {
            firstNode = firstNode.getNext();
            return elem;
        } else if (index > 0 && index < size()) {
            elem = getNode(index).getValue();
            getNode(index - 1).setNext(getNode(index + 1));
            return elem;
        } else {
            return null;
        }
    }

    public Node<T> getNode(int index) {
        Node<T> iterator = firstNode;
        if (index < 0) {
            System.out.println("не подходит");
        } else {
            for (int i = 0; i < index; ++i) {
                iterator = iterator.getNext();
            }
        }
        return iterator;
    }

    public T set(int index, T elem) {
        int ind = 0;
        Node<T> currentNode = firstNode;
        while (currentNode.getNext() != null) {
            if (ind == index) {
                T elem1 = currentNode.getValue();
                currentNode.setValue(elem);
                return elem1;
            } else {
                ind++;
                currentNode = currentNode.getNext();
            }
        }
        return elem;
    }



    public int lastIndexOf(T elem) {
        int index = -1;
        int ind = 0;
        Node<T> currentNode = firstNode;
        while (currentNode.getNext() != null) {
            if (currentNode.getValue() == elem) {
                index = ind;
            }
            currentNode = currentNode.getNext();
            ind ++;
        }
        return index;
    }

    public int size() {
        int size = 0;
        Node<T> currentNode = firstNode;
        while (currentNode.getNext() != null) {
            currentNode = currentNode.getNext();
            size++;
        }
        int size2 = 0;
        for (Node<T> i = firstNode; i.getNext() != null; i = i.getNext()) {
            size2++;
        }
        return size;
    }

    @Override
    public String toString() {
        String s = "[" + firstNode.getValue();
        Node<T> currentNode = firstNode;
        while (currentNode.getNext() != null) {
            s += ", " + currentNode.getNext().getValue();
            currentNode = currentNode.getNext();
        }
        return s + "]";
    }

}


