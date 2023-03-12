import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main1 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(4);
        list.add(8);
        list.add(7);
        list.add(6);
        list.add(3);
        MyIterator itr = new MyIterator(list);
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }

    }

    static class MyIterator implements Iterator<Integer> {
        private int current = 0;
        private List<Integer> list = new ArrayList<>();

        public MyIterator(List<Integer> list) {
            Iterator<Integer> iter = list.iterator();
            while (iter.hasNext()) {
                int t = iter.next();
                if (t % 2 == 1) {
                    this.list.add(t);
                }
            }
        }

        @Override
        public boolean hasNext() {
            if (current < list.size()) {
                return true;
            } else {
                return false;
            }
        }

        @Override
        public Integer next() {
            return list.get(current++);
        }
    }
}
