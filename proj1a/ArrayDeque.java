public class ArrayDeque<Cats> {
    private Cats[] items;
    private int size;
    private int front;
    private int last;
    private int len;

    /** Creates an empty list. */
    public ArrayDeque() {
        items = (Cats[]) new Object[8];
        size = 0;
        len = 8;
        front = 0;
        last = 0;

    }
    /** decide if the deque is empty.
     * @return true if the deque is empty, vice versa.
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /** Change the index. */
    public int decreaseIndex(int x) {
        if (x < 0){
            return len-1;
        }
        return x;
    }

    public int addIndex(int x) {
        if (x == len){
            return 0;
        }
        return x;
    }
    /** Change the len of array. */
    public void grows() {
        Cats[] a = (Cats[]) new Object[len*2];
        int ptr1 = front;

        for (int i = 0;i < size;i += 1 ){
            a[i] = items[ptr1];
            ptr1 = addIndex(ptr1+1);
        }
        front = 0;
        last = size;
        len *= 2;
        items = a;
    }
    public void shrink() {
        Cats[] a = (Cats[]) new Object[len/2];
        int ptr1 = front;

        for (int i = 0;i < size;i += 1 ){
            a[i] = items[ptr1];
            ptr1 = addIndex(ptr1+1);
        }
        front = 0;
        last = size;
        len /= 2;
        items = a;
    }
    /** Inserts X into the back of the list. */
    public void addLast(Cats x) {
        if (size >= len){
            grows();
        }
        items[last] = x;
        last = addIndex(last+1);
        size = size + 1;
    }
    public void addFirst(Cats x) {
        if (size >= len){
            grows();
        }
        front = decreaseIndex(front-1);
        items[front] = x;
        size = size + 1;

    }


    /** Gets the ith item in the list (0 is the front). */
    public Cats get(int index) {
        if (index >= size) {
            return null;
        }
        int ptr = front;
        ptr = addIndex(ptr);
        for (int i = 0; i < index; i++) {
            ptr = addIndex(ptr);
        }
        return items[ptr];
    }

    /** Returns the number of items in the list. */
    public int size() {
        return size;
    }

    /** Deletes item from back of the list and
     * returns deleted item. */
    public Cats removeLast() {
        if (len >= 16 && len/size >=4 ){
            shrink();
        }
        if (size == 0) {
            return null;
        }
        last = decreaseIndex(last-1);
        size = size - 1;
        return items[last];
    }
    public Cats removeFirst() {
        if (len >= 16 && len/size >=4 ){
            shrink();
        }
        if (size == 0) {
            return null;
        }
        Cats ret = items[front];
        front = addIndex(front+1);
        size = size - 1;
        return ret;
    }
    /** print the entire deque from front to end. */
    public void printDeque() {
        int ptr = front;
        ptr = addIndex(ptr);
        for (int i = 0; i < size; i++) {
            System.out.print(items[ptr] + " ");
            ptr = addIndex(ptr+1);
        }
    }
}
