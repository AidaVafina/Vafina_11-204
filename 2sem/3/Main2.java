import java.lang.reflect.Array;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;

public class Main2 {
    public class ModifiableCollection<T> extends AbstractCollection {
        private T[] arr;
        int curr = 0;

        public ModifiableCollection(Class<T> tClass, Collection<T> collection){
            arr = (T[]) Array.newInstance(tClass, collection.size());
            Iterator<T> iterator = collection.iterator();
            int ind = 0;
            while (iterator.hasNext()){
                arr[ind] = iterator.next();
                ind ++;
            }
        }

        @Override
        public Iterator<T> iterator() {
            return new DefaultIterator<>(arr);
        }

        @Override
        public int size() {
            return arr.length;
        }

        @Override
        public boolean remove(Object o) {
            return super.remove(o);
        }

        @Override
        public void clear(){
            for (int i = 0; i < arr.length; i++) {
                super.remove(arr[i]);
            }
        }

        @Override
        public String toString() {
            if (isEmpty()){
                return "[]";
            }
            DefaultIterator<T> iterator = new DefaultIterator<>(arr);
            String s = "[" + iterator.next();
            while (iterator.hasNext()){
                T elem = iterator.next();
                if (elem == null){
                    break;
                }
                s += ", " + elem;
            }
            return s + "]";
        }

        @Override
        public boolean add(Object item){
            arr[size()] = (T) item;
            return true;
        }

    }
}
