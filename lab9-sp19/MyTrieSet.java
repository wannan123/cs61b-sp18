import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyTrieSet implements TrieSet61B{
    Node root;
    private boolean is_empty;
    public MyTrieSet() {
        root = new Node(false);
        is_empty = true;
    }
    private static class Node{
        private boolean is_key;

        private Map<Character, Node> next;
        Node(boolean is_key_){
            is_key = is_key_;
            next = new HashMap<>();
        }
        public void setIs_key(boolean is_key1){
            is_key = is_key1;
        }

    }
    @Override
    public void clear() {
        is_empty = true;
    }

    @Override
    public boolean contains(String key) {
        if (key == null) throw new IllegalArgumentException("argument to get() is null");
        int len = get(root, key, 0, key.length());
        if (is_empty) return false;
        return len == key.length();
    }
    private int get(Node x, String key, int l, int len){
        if (x == null) return 0;
        int lens = l;
        if (l == len && x.is_key) return l;
        if (x.next.containsKey(key.charAt(l))){
            x = x.next.get(key.charAt(l));
            l += 1;
            lens = get(x, key, l, len);
        }else {
            return 0;
        }

        return lens;
    }

    @Override
    public void add(String key) {
        is_empty = false;
        if (key == null) throw new IllegalArgumentException("argument to get() is null");
        Node root1 = root;
        for (int i = 0; i < key.length(); i += 1){
            boolean end = (i == (key.length()-1));
            char c = key.charAt(i);
            Map<Character, Node> map = root1.next;
            if (!map.containsKey(c)){
                map.put(c, new Node(end));
            }
            root1 = map.get(c);
            if (end) root1.setIs_key(true);
        }
    }

    @Override
    public List<String> keysWithPrefix(String prefix) {
        Node p = root;
        for (int i = 0; i < prefix.length(); i += 1) {
            p = p.next.get(prefix.charAt(i));  // current node
            if (p == null) break;
        }
        List<String> x = new ArrayList<>();
        if (p == null) return x;
        collection(p, prefix, x);
        return x;
    }
    private void collection(Node x, String pre, List<String> list){
        if (x == null) return;
        if (x.is_key) {
            list.add(pre);
        }
        for (Character character : x.next.keySet()){
            String pre_ = pre + character;
            collection(x.next.get(character), pre_, list);
        }

    }

    @Override
    public String longestPrefixOf(String key) {
        return null;
    }
}
