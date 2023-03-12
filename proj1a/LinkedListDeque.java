public class LinkedListDeque<Dogs>{

    public class Nodes{
        public Nodes pre;
        public Nodes next;
        public Dogs item;
        public boolean isempty = true;

        public Nodes(Dogs x,Nodes pre,Nodes next){
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
    public LinkedListDeque(Dogs x){
        sentinel = new Nodes(x,sentinel,sentinel);
        sentinel.isempty = false;
        sentinel.pre = sentinel;
        sentinel.next = sentinel;
    }
    public LinkedListDeque(LinkedListDeque<Dogs> other){
        sentinel = new Nodes(null,sentinel,sentinel);
        sentinel.isempty = false;
        sentinel.pre = sentinel;
        sentinel.next = sentinel;
        for (int i=0;i < other.size;i += 1){
            addFirst(other.getItem(i));
        }
    }

    public void addLast(Dogs x){
        sentinel = new Nodes(x,sentinel.pre,sentinel);
        sentinel.isempty = false;
        size += 1;
    }
    public void  addFirst(Dogs x){
        sentinel = new Nodes(x,sentinel,sentinel.next);
        sentinel.isempty = false;
        size += 1;
    }

    public Dogs removeFirst() {
        if (size == 0) {
            return null;
        }
        Dogs ret = sentinel.next.item;
        sentinel.next.next.pre = sentinel;
        sentinel.next = sentinel.next.next;
        size--;
        return ret;
    }

    public Dogs removeLast() {
        if (size == 0) {
            return null;
        }
        Dogs ret = sentinel.pre.item;
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
    public Dogs getItem(int index){
        int i = 0;
        Nodes first = sentinel.next;
        while (i<=index){
            first = first.next;
            i++;
        }
        return first.item;
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
    private Dogs getRecursiveHelp(Nodes start, int index) {
        if (index == 0) {
            return start.item;
        } else {
            return getRecursiveHelp(start.next, index - 1);
        }
    }

    public Dogs getRecursive(int index) {
        if (index >= size) {
            return null;
        }
        return getRecursiveHelp(sentinel.next, index);
    }
    public boolean isEmpty(){
        return sentinel.isempty;
    }

}
