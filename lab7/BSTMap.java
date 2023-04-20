import java.util.Iterator;
import java.util.Set;

public class BSTMap<Key extends Comparable<Key>, Value> implements Map61B<Key, Value>{

    private Node root;
    private class Node {
        private Key key;           // sorted by key
        private Value val;         // associated data
        private Node left, right;  // left and right subtrees
        private int size;          // number of nodes in subtree

        public Node(Key key, Value val, int size) {
            this.key = key;
            this.val = val;
            this.size = size;
        }

        public Node() {

        }
    }
    BSTMap(){
        root = new Node();
    }
    BSTMap(Key key, Value value){
        root = new Node(key, value, 1);
    }
    @Override
    public void clear() {
        root = null;
    }

    @Override
    public boolean containsKey(Key key) {
        if (root == null) return false;
        if (root.key == null) return false;
        Value value = get(key);
        return value != null;
    }

    @Override
    public Value get(Key key) {
        if (root == null) return null;
        if (root.key == null) return null;
        return get(root, key);
    }
    private Value get(Node root, Key key){
        if (key == null) throw new IllegalArgumentException("calls get() with a null key");
        if (root == null){
            return null;
        }
        int x = root.key.compareTo(key);
        if (x > 0){
            return get(root.left, key);
        } else if (x < 0) {
            return get(root.right, key);
        } else {
            return root.val;
        }
    }

    @Override
    public int size() {
        if (root == null) return 0;
        return size(root);
    }
    private int size(Node node){
        if (node == null){
            return 0;
        }
        return node.size;
    }

    @Override
    public void put(Key key, Value value) {
        if (root == null) throw new IllegalArgumentException("Map is not available");
        if (key == null) throw new UnsupportedOperationException("key is null");
        if (root.key == null){
            root = new Node(key, value, 1);
            return;
        }
        root = put(root, key, value);
    }
    private Node put(Node root, Key key, Value value){
        if (root == null){
            return new Node(key, value, 1);
        }
        int x = root.key.compareTo(key);
        if (x > 0){
            root.left = put(root.left, key, value);
        }else if (x < 0){
            root.right = put(root.right, key, value);
        }else {
            root.val = value;
        }
        root.size = 1 + size(root.left) + size(root.right);
        return root;
    }

    @Override
    public Set<Key> keySet() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Value remove(Key key) {
        if (root == null || root.key == null) throw new IllegalArgumentException("Map is not available");
        if (key == null) throw new IllegalArgumentException("key is null");
        if (!containsKey(key)) throw new IllegalArgumentException("nothing match the key");
        Value value1 = get(key);
        Node val = delete(root, key);
        assert val != null;
        return value1;
    }

    @Override
    public Value remove(Key key, Value value) {
        if (root == null || root.key == null) throw new IllegalArgumentException("Map is not available");
        if (key == null) throw new IllegalArgumentException("key is null");
        if (get(key) != value || !containsKey(key)) throw new IllegalArgumentException("nothing match the key");
        Value value1 = get(key);
        Node val = delete(root, key);
        assert val != null;
        return value1;
    }
    private Node delete(Node root, Key key){
        int x = key.compareTo(root.key);
        if (x < 0){
            root.left = delete(root.left, key);
        } else if (x > 0) {
            root.right = delete(root.right, key);
        } else {
            if (root.left == null || root.right == null){
                if (root.left != null) {
                    root = root.left;
                }else {
                    root = root.right;
                }
            }else {
                Node pp = root.right;
                while (pp.left != null) pp = pp.left;
                root.right = delete(root.right, pp.key);
                root.key = pp.key;
                root.val = pp.val;
            }
        }
        if (root != null) {
            root.size = 1 + size(root.left) + size(root.right);
        }
        return root;
    }
    public void print(){
        if (root == null || root.key == null) throw new IllegalArgumentException("Map is not available");
        print(root);
    }
    private void print(Node root){
        if (root == null){
            return;
        }
        print(root.left);
        System.out.println(root.key + "(" + root.val + ")" + " ");
        print(root.right);
    }

    @Override
    public Iterator<Key> iterator() {
        throw new UnsupportedOperationException();
    }
}
