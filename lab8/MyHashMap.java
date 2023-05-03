import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;


/**
 * Created by Jun-haoW on 05/14/2019
 */

public class MyHashMap<K, V> implements Map61B<K, V>{
    private int initialSize;
    private int M;
    private final double loadFactor;
    private Entry_<K,V>[] bins;

    private int size;
    private final HashSet<K> allKeys;
    private static class Entry_ <K, V>{

        /** Stores the key of the key-value pair of this node in the list. */
        public K key;
        /** Stores the value of the key-value pair of this node in the list. */
        public V val;
        /** Stores the next Entry in the linked list. */
        public Entry_<K, V> next;
        public int size_ = 0;

        public Entry_(K k, V v) {
            key = k;
            val = v;
        }

        public Entry_() {
            key = null;
            val = null;
            next = null;
        }

        public int size() {
            return size_;
        }

        /**
         * Returns the Entry in this linked list of key-value pairs whose key
         * is equal to KEY, or null if no such Entry exists.
         */
        public Entry_<K, V> get(K k) {
            Entry_<K, V> entry = next;
            for (int i =0; i < size(); i ++){
                if (k != null && k.equals(entry.key)) {
                    return entry;
                }
                if (k == null){
                    return null;
                }
                entry = entry.next;
            }
            return null;
        }
        public boolean containKey(K key){
            if (key == null) throw new IllegalArgumentException();
            if (next == null) return false;
            return get(key) != null;
        }
        public boolean put(K key, V val){
            if (key == null) throw new IllegalArgumentException();
            Entry_<K, V> entry = get(key);
            if (entry == null){
                Entry_<K, V> entry2 = new Entry_<K, V>(key, val);
                entry2.next = next;
                next = entry2;
                size_ += 1;
                return true;
            }else{
                entry.val = val;
            }
            return false;
        }
        public void removeAll() {
            next = null;
            size_ = 0;
        }
        public V remove(K key){
            if (!containKey(key))return null;
            Entry_<K, V> entry3 = next;
            while (entry3.key != key){
                entry3 = entry3.next;
                if (!containKey(entry3.next.key))break;
            }
            entry3 = entry3.next;
            Entry_<K, V> entry = entry3.next;
            return entry.val;
        }


    }

    public MyHashMap() {
        initialSize = 16;
        loadFactor = 0.75;
        bins = new Entry_[initialSize];
        allKeys = new HashSet<>();
    }

    public MyHashMap(int initialSize_) {
        initialSize = initialSize_;
        loadFactor = 0.75;
        bins = new Entry_[initialSize];
        allKeys = new HashSet<>();
    }

    public MyHashMap(int initialSize_, double loadFactor_) {
        initialSize = initialSize_;
        loadFactor = loadFactor_;
        bins = new Entry_[initialSize];
        allKeys = new HashSet<>();
    }

    @Override
    public void clear() {
        this.size = 0;
        for (Entry_<K, V> bin : this.bins) {
            if (bin != null) {
                bin.removeAll();
            }
        }
        this.allKeys.clear();
    }

    @Override
    public boolean containsKey(K key) {
        if (key == null) throw new IllegalArgumentException();
        return get(key) != null;
    }

    @Override
    public V get(K key) {
        int h = hash (key);
        Entry_<K,V> e = find(key, h);
        if (e == null){
            return null;
        }
        return e.val;
    }

    @Override
    public int size() {
        return size;
    }
    private int hash(K key){
        return (key.hashCode() & 0x7FFFFFFF) % initialSize;
    }
    private Entry_<K, V> find(K k, int hash){
        Entry_<K, V> entry = bins[hash];
        if (entry == null)return null;
        return entry.get(k);
    }
    private void grow(){
        MyHashMap<K, V> myHashMap = new MyHashMap<>(initialSize * 2);
        for (K k: allKeys){
            V val = get(k);
            myHashMap.put(k, val);
        }
        initialSize *= 2;
        this.bins = myHashMap.bins;
    }

    @Override
    public void put(K key, V value) {
        if (key == null) throw new IllegalArgumentException();
        if (value == null) {
            remove(key);
            return;
        }
        if ((double) size / initialSize >= loadFactor) {
            // resize
            grow();
        }
        int h = hash (key);
        boolean flag = bins[h] == null;
        if (flag) bins[h] = new Entry_<>();

        Entry_ <K, V> L = bins[h];
        if (L.put(key, value)) {
            size += 1;
            allKeys.add(key);
        }
    }

    @Override
    public Set<K> keySet() {
        return allKeys;
    }

    @Override
    public V remove(K key) {
        return remove(key, null);
    }

    @Override
    public V remove(K key, V value) {
        int num = hash(key);
        Entry_<K,V> L = bins[num];
        if (L == null)return null;
        if (L.containKey(key)) {
            // remove
            V val = L.remove(key);
            size -= 1;
            return val;
        }
        return null;
    }

    @Override
    public Iterator<K> iterator() {
        return keySet().iterator();
    }
    public static void main(String[] args) {
        MyHashMap<String, String> a = new MyHashMap<String, String>();
        MyHashMap<String, Integer> b = new MyHashMap<String, Integer>();
        MyHashMap<Integer, String> c = new MyHashMap<Integer, String>();
        MyHashMap<Boolean, Integer> e = new MyHashMap<Boolean, Integer>();
    }
}
