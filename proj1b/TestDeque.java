import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TestDeque {
    @Test
    public void test(){
        LinkedListDeque linkedListDeque = new LinkedListDeque<>();
        System.out.println("is Empty?:"+linkedListDeque.isEmpty());
        linkedListDeque.addFirst(6);
        linkedListDeque.addFirst(4);
        linkedListDeque.addFirst(8);
        linkedListDeque.printDeque();
        System.out.println("index i : "+linkedListDeque.get(1));
        linkedListDeque.removeFirst();
        System.out.println("index i : "+linkedListDeque.get(1));
        System.out.println("Size :"+linkedListDeque.size());
    }
}
