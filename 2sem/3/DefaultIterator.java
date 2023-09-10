import java.util.Iterator;

public class DefaultIterator<T> implements Iterator<T> {
    private T[] elem;
    private int current;

    public DefaultIterator(T[] elem){
        this.elem = elem;
    }

    @Override
    public boolean hasNext() {
        return current < elem.length && elem[current] != null;
    }

    @Override
    public T next() {
        return elem[current++];
    }
}
