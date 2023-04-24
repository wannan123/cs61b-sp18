import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TestDeque {
    @Test
    public void test(){
        LinkedListDeque linkedListDeque = new LinkedListDeque<>();
        System.out.println("is Empty?:"+linkedListDeque.isEmpty());
        linkedListDeque.addLast(6);
        linkedListDeque.addLast(4);
        linkedListDeque.addLast(8);
        linkedListDeque.printDeque();
        System.out.println("index 1 : "+linkedListDeque.get(1));
        linkedListDeque.removeFirst();
        System.out.println("remove the first one");
        System.out.println("index 1 : "+linkedListDeque.get(1));
        System.out.println("Size :"+linkedListDeque.size());
    }
}
