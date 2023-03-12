public class LinkedListDeque<T>{

    public class Nodes{
        private Nodes pre;
        private Nodes next;
        private T item;
        private boolean empty = true;

        public Nodes(T x,Nodes pre,Nodes next){
            Nodes.this.item = x;
            Nodes.this.pre = pre;
            Nodes.this.next = next;
        }

        public Nodes() {
        }
    }
    private Nodes sentinel =new Nodes();
    private int size;

    public LinkedListDeque(){
        sentinel = new Nodes(null,sentinel,sentinel);
        sentinel.pre = sentinel;
        sentinel.next = sentinel;
    }
    public LinkedListDeque(T x){
        sentinel = new Nodes(x,sentinel,sentinel);
        sentinel.empty = false;
        sentinel.pre = sentinel;
        sentinel.next = sentinel;
    }
    public LinkedListDeque(LinkedListDeque<T> other){
        sentinel = new Nodes(null,sentinel,sentinel);
        sentinel.empty = false;
        sentinel.pre = sentinel;
        sentinel.next = sentinel;
        for (int i=0;i < other.size;i += 1){
            addFirst(other.get(i));
        }
    }

    private void addLast(T x){
        Nodes newList = new Nodes(x, sentinel.pre, sentinel);
        sentinel.pre.next = newList;
        sentinel.pre = newList;
        sentinel.empty = false;
        size += 1;
    }
    private void  addFirst(T x){
        Nodes newList = new Nodes(x, sentinel, sentinel.next);
        sentinel.next.pre = newList;
        sentinel.next = newList;
        sentinel.empty = false;
        size += 1;
    }

    private T removeFirst() {
        if (size == 0) {
            return null;
        }
        T ret = sentinel.next.item;
        sentinel.next.next.pre = sentinel;
        sentinel.next = sentinel.next.next;
        size--;
        if (size == 0){
            sentinel.empty = true;
        }
        return ret;
    }

    private T removeLast() {
        if (size == 0) {
            return null;
        }
        T ret = sentinel.pre.item;
        sentinel.pre.pre.next = sentinel;
        sentinel.pre = sentinel.pre.pre;
        size--;
        return ret;
    }

    /** return size of the linked list*/
    public int size(){
        return size;
    }

    /** return the item of the list*/

    private T get(int index_) {
        if (index_ >= size) {
            return null;
        }
        Nodes ptr = sentinel;
        for (int i = 0; i <= index_; i++) {
            ptr = ptr.next;
        }
        return ptr.item;
    }
    /** print the list */
    public void printDeque(){
        Nodes first = sentinel.next;
        int i = 0;
        while (i<size){
            System.out.println(first.item);
            first=first.next;
            i++;
        }
    }
    private T getRecursiveHelp(Nodes start, int index) {
        if (index == 0) {
            return start.item;
        } else {
            return getRecursiveHelp(start.next, index - 1);
        }
    }

    private T getRecursive(int index) {
        if (index >= size) {
            return null;
        }
        return getRecursiveHelp(sentinel.next, index);
    }
    public boolean isEmpty(){
        return size == 0;
    }

}
