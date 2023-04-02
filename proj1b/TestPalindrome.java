import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {
    // You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();

    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    }
    /*Uncomment this class once you've created your Palindrome class. */
    @Test
    public void testIsPalindrome(){
        boolean is = palindrome.isPalindrome("cat");
        assertEquals(false, is);
        boolean is2 = palindrome.isPalindrome("caa");
        assertEquals(false, is2);
        boolean is3 = palindrome.isPalindrome("caac");
        assertEquals(true, is3);
        boolean is4 = palindrome.isPalindrome("c");
        assertEquals(true, is4);
        boolean is5 = palindrome.isPalindrome("racecar");
        assertEquals(true, is5);
    }
    @Test
    public void testIsOffByOnePalindrome() {
        CharacterComparator cc = new OffByOne();
        assertTrue(palindrome.isPalindrome("flake", cc));
        assertFalse(palindrome.isPalindrome("aba", cc));
    }
    @Test
    public void testWordToDeque2(){
        LinkedListDeque d = new LinkedListDeque();
        d.addFirst(1);
        d.addFirst(2);
        d.addFirst(3);
        System.out.println((int)d.getRecursive(2));

    }

}
