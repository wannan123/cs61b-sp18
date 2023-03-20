public interface Deque<T> {
    boolean isEmpty();
    void addLast(T x);
    void addFirst(T x);
    T get(int index);
    int size();
    T removeLast();
    T removeFirst();
    void printDeque();
}
