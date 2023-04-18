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
        root = new Node(key, value, 0);
    }
    @Override
    public void clear() {
    }

    @Override
    public boolean containsKey(Key key) {
        return false;
    }

    @Override
    public Value get(Key key) {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public void put(Key key, Value value) {
        if (key == null) throw new UnsupportedOperationException("key is null");
        if (root.key == null){
            root = new Node(key, value, 0);
        }
        root = put(root, key, value);
    }
    private Node put(Node root, Key key, Value value){
        if (root == null){
            return new Node(key, value, 0);
        }
        int x = root.key.compareTo(key);
        if (x > 0){
            root.left = put(root.left, key, value);
        }else if (x < 0){
            root.right = put(root.right, key, value);
        }
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
