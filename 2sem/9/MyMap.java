import java.util.AbstractMap;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;


public class MyMap<K extends Comparable<K>, V> implements Map<K, V> {

    private Tree<K, V> root;

    private static class Tree<K extends Comparable<K>, V> {
        private Tree<K, V> parent;
        private Tree<K, V> left;
        private Tree<K, V> right;
        private K key;
        private V value;


        public Tree<K, V> get(K key) {
            //берем корневой узел
            Tree<K, V> node = this;
            //начинаем проход по дереву
            while (node != null) {
                //берем ключ нашей ноды
                int cmp = key.compareTo(node.key);
                //если меньше в левое поддерево
                if (cmp < 0) {
                    node = node.left;
                    //если больше то в правое
                } else if (cmp > 0) {
                    node = node.right;
                    //как только равно,то возвращаем значение
                } else {
                    return node;
                }
            }
            //если ничего нет то нулл
            return null;
        }

        public K remove(K key) {
            Tree<K, V> node = get(key);
            if (node == null) {
                return null;
            }
            K result = node.key;
            if (node.left == null && node.right == null) {
                if (node.parent == null) {
                    // Удаляем корневой узел
                } else if (node == node.parent.left) {
                    node.parent.left = null;
                } else {
                    node.parent.right = null;
                }
            } else if (node.left == null) {
                node.right.parent = node.parent;
                if (node.parent == null) {
                    // Заменяем корневой узел
                } else if (node == node.parent.left) {
                    node.parent.left = node.right;
                } else {
                    node.parent.right = node.right;
                }
            } else if (node.right == null) {
                node.left.parent = node.parent;
                if (node.parent == null) {
                    // Заменяем корневой узел
                } else if (node == node.parent.left) {
                    node.parent.left = node.left;
                } else {
                    node.parent.right = node.left;
                }
            } else {
                Tree<K, V> min = node.right;
                while (min.left != null) {
                    min = min.left;
                }
                node.key = min.key;
                node.value = min.value;
                min.remove(min.key);
            }
            return result;
        }

        public V add(Tree<K, V> node) {
            Tree<K, V> parent = null;
            Tree<K, V> current = this;
            while (current != null) {
                int cmp = node.key.compareTo(current.key);
                if (cmp == 0) {
                    V oldValue = current.value;
                    current.value = node.value;
                    return oldValue;
                } else if (cmp < 0) {
                    parent = current;
                    current = current.left;
                } else {
                    parent = current;
                    current = current.right;
                }
            }
            node.parent = parent;
            if (parent == null) {
                return null;
            } else if (node.key.compareTo(parent.key) < 0) {
                parent.left = node;
            } else {
                parent.right = node;
            }
            return null;
        }
    }

    @Override
    public int size() {
        if (root == null) {
            return 0;
        }

        Queue<Tree<K, V>> queue = new ArrayDeque<>();
        int size = 0;
        queue.add(root);
        while (!queue.isEmpty()) {
            Tree<K, V> tree = queue.remove();

            if (tree.left != null) {
                queue.add(tree.right);
            }
            if (tree.right != null) {
                queue.add(tree.right);
            }
            size++;
        }
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public boolean containsKey(Object key) {
        if (key == null) {
            return false;
        }
        K k = (K) key;
        Tree<K, V> node = root.get(k);
        return node != null;
    }

    @Override
    public boolean containsValue(Object value) {
        if (value == null) {
            return false;
        }

        Queue<Tree<K, V>> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Tree<K, V> node = queue.remove();
            if (node.value.equals(value)) {
                return true;
            }
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
        return false;
    }

    @Override
    public V get(Object key) {
        if (key == null) {
            return null;
        }

        K k = (K) key;
        Tree<K, V> node = root.get(k);
        if (node != null) {
            return node.value;
        }
        return null;
    }

    @Override
    public V put(K key, V value) {
        Tree<K, V> node = new Tree<>();
        node.key = key;
        node.value = value;

        V oldValue = root.add(node);
        if (oldValue != null) {
            return oldValue;
        }
        return null;
    }

    @Override
    public V remove(Object key) {
        if (key == null) {
            return null;
        }

        K k = (K) key;
        K result = root.remove(k);
        if (result != null) {
            return null;
        }
        return null;
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> m) {
        for (Entry<? extends K, ? extends V> entry : m.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    @Override
    public void clear() {
        root = null;
    }

    @Override
    public Set<K> keySet() {
        Set<K> keys = new HashSet<>();
        Queue<Tree<K, V>> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Tree<K, V> node = queue.remove();
            keys.add(node.key);
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
        return keys;
    }

    @Override
    public Collection<V> values() {
        List<V> values = new ArrayList<>();
        Queue<Tree<K, V>> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Tree<K, V> node = queue.remove();
            values.add(node.value);
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
        return values;
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        Set<Entry<K, V>> entries = new HashSet<>();
        Queue<Tree<K, V>> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Tree<K, V> node = queue.remove();
            entries.add(new AbstractMap.SimpleEntry<>(node.key, node.value));
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
        return entries;
    }
}