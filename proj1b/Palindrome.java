public class Palindrome {
    public Deque<Character> wordToDeque(String word) {
        Deque d = new ArrayDeque();
        for (int i = 0; i < word.length(); i++) {
            String ss = String.valueOf(word.charAt(i));
            d.addLast(ss);
        }
        return d;
    }

//    public boolean isPalindrome(String word) {
//        if (word == null || word.length() <= 1) {
//            return true;
//        }
//        int lens = word.length();
//        boolean is = true;
//        for (int i = 0; i < lens / 2; i++){
//            if (word.charAt(i) != word.charAt(lens - i - 1)){
//                is = false;
//            }
//        }
//        return is;
//    }
//    public boolean isPalindrome(String word,CharacterComparator cc){
//        if (word == null || word.length() <= 1) {
//            return true;
//        }
//        int lens = word.length();
//        boolean is = true;
//        for (int i = 0; i < lens / 2; i++) {
//            if (!cc.equalChars(word.charAt(i), word.charAt(lens - i - 1))) {
//                is = false;
//            }
//        }
//        return is;
//    }
public boolean isPalindrome(String word) {
    if (word == null || word.length() <= 1) {
        return true;
    }
    int len = word.length();
    for (int i = 0; i < len / 2; i++) {
        if (word.charAt(i) != word.charAt(len - i - 1)) {
            return false;
        }
    }
    return true;
}

    /** overloaded isPalindrome, decide if the given word is palindrome.
     * according to the given CharacterComparator
     */
    public boolean isPalindrome(String word, CharacterComparator cc) {
        if (word == null || word.length() <= 1) {
            return true;
        }
        int len = word.length();
        for (int i = 0; i < len / 2; i++) {
            if (!cc.equalChars(word.charAt(i), word.charAt(len - i - 1))) {
                return false;
            }
        }
        return true;
    }

}