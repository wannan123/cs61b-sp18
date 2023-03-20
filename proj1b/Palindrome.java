public class Palindrome {
    public Deque<Character> wordToDeque(String word){
        Deque d = new ArrayDeque();
        for (int i = 0;i<word.length();i++){
            String ss = String.valueOf(word.charAt(i));
            d.addLast(ss);
        }
        return d;
    }
}
