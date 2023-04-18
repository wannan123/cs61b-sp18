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
        throw new UnsupportedOperationException();
    }

    @Override
    public Value remove(Key key, Value value) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Iterator<Key> iterator() {
        throw new UnsupportedOperationException();
    }
}
