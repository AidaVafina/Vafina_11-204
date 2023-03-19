import java.lang.reflect.Array;
import java.util.*;

public class MySet<T> extends AbstractSet<T> implements SortedSet<T> {
    private T[] array;
    private Comparator<? super T> comparator;

    public MySet(Comparator<T> comparator, Class<T> tClass){
        this.comparator = comparator;
        array = (T[]) Array.newInstance(tClass,0);
    }

    public MySet(Comparator<? super T> comparator, Collection<T> collection){
        this.comparator = comparator;
        List<T> list = new ArrayList();
        for (T elem: collection) {
            if(!list.contains(elem)){
                list.add(elem);
            }
        }
        list.sort(comparator);
        array = (T[]) list.toArray();
    }

    @Override
    public Iterator<T> iterator() {
        return new MyIterator1(array);
    }

    @Override
    public int size() {
        return array.length;
    }

    @Override
    public Comparator<? super T> comparator() {
        return comparator;
    }

    @Override
    public SortedSet<T> subSet(T fromElement, T toElement) {
    if (comparator == null){
        return null;
    }
    List<T> list = new ArrayList<>();
    for (T elem: array) {
        if (comparator.compare(elem,fromElement) >= 0 && comparator.compare(elem, toElement) < 0){
            list.add(elem);
        } else {
            break;
        }
    }
    return new MySet<T>(comparator,list);
    }

    @Override
    public SortedSet<T> headSet(T toElement) {
        if (comparator == null){
            return null;
        }
        ArrayList<T> list = new ArrayList<>();
        for (T elem: array){
            if (comparator.compare(elem, toElement) < 0){
                list.add(elem);
            } else {
                break;
            }
        }
        return new MySet<>(comparator,list);
    }

    @Override
    public SortedSet<T> tailSet(T fromElement) {
        if (comparator == null){
            return null;
        }
        List<T> list = new ArrayList<>();
        for (T elem: array){
            if (comparator.compare(elem,fromElement) >= 0){
                list.add(elem);
            }
        }
        return new MySet<>(comparator, list);
    }

    @Override
    public T first() {
        return array[0];
    }

    @Override
    public T last() {
        return array[array.length-1];
    }

    @Override
    public boolean add(T element) {
        List<T> list = new ArrayList<>();
        list.addAll(Arrays.asList(array));
        if (list.contains(element)) {
            return false;
        } else {
            list.add(element);
            list.sort(comparator);
            array = (T[]) list.toArray();
            return true;
        }
    }

    class MyIterator1 implements Iterator<T>{

        T[] arr;

        int curr = 0;

        public MyIterator1(T[] arr){
            this.arr = arr;
        }
        @Override
        public boolean hasNext() {
            return curr < arr.length;
        }

        @Override
        public T next() {
            return arr[curr++];
        }
    }

    @Override
    public String toString(){
        return "MySet{" + "array= " + Arrays.toString(array) + ", comparator =" + comparator + "}";
    }

    public static void main(String[] args) {
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        };
        MySet<Integer> integers = new MySet<>(comparator, Integer.class);
        integers.add(1);
        integers.add(2);
        integers.add(3);
        integers.add(5);
        integers.add(100);
        System.out.println("size: " + integers.size());
        System.out.println("all elements: " + integers);
        System.out.println("headSet: " + integers.headSet(3));
        System.out.println("subSet: " + integers.subSet(2,100));
        System.out.println("tailSet: " + integers.tailSet(3));
        System.out.println("first: " + integers.first());
        System.out.println("last: " + integers.last());
        integers.add(9);
        System.out.println("add: " + integers.toString());

   }
}
