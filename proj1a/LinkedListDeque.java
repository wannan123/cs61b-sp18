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
    public void removeFirst(){
        Nodes first = sentinel;
        first.next = sentinel.next.next;
        size -= 1;
        if(size == 0){
            sentinel.isempty = true;
        }
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
    public boolean isEmpty(){
        return sentinel.isempty;
    }

}
