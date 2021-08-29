public class Palindrome {
    public Deque<Character> wordToDeque(String word) {
        Deque<Character> dq = new ArrayDeque<>();
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            dq.addLast(c);
        }
        return dq;
    }

    private boolean isPalRec(Deque<Character> charDeque) {
        if (charDeque.isEmpty() || charDeque.size() == 1) {
            return true;
        }
        char first = charDeque.removeFirst();
        char last = charDeque.removeLast();
        if (first == last) {
            return isPalRec(charDeque);
        }
        return false;
    }

    public boolean isPalindrome(String word) {
        Deque<Character> charDeque = wordToDeque(word);
        return isPalRec(charDeque);
    }

    private boolean isPalRec(Deque<Character> charDeque, CharacterComparator cc) {
        if (charDeque.isEmpty() || charDeque.size() == 1) {
            return true;
        }
        char first = charDeque.removeFirst();
        char last = charDeque.removeLast();
        if (cc.equalChars(first, last)) {
            return isPalRec(charDeque, cc);
        }
        return false;
    }

    public boolean isPalindrome(String word, CharacterComparator cc) {
        Deque<Character> charDeque = wordToDeque(word);
        return isPalRec(charDeque, cc);
    }


    private boolean isPalindrome2(String word) {
        Deque<Character> charDeque = wordToDeque(word);
        Deque<Character> charDeque2 = wordToDeque(word);

        String wordForward = "";
        String wordReverse = "";
        
        for (int i = 0; i < word.length(); i++) {
            wordForward += charDeque.removeFirst();
        }

        for (int i = 0; i < word.length(); i++) {
            wordReverse += charDeque2.removeLast();
        }

        System.out.println(wordForward);
        System.out.println(wordReverse);

        return wordForward.equals(wordReverse);
    }

   /* 
    public static void main(String[] args) {
        Palindrome palindrome = new Palindrome();
        palindrome.wordToDeque("palindrome");
    }
    */
}
