import java.util.Iterator;
import java.util.Set;

public class BSTMap<Key extends Comparable<Key>, Value> implements Map61B<Key, Value>{
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
