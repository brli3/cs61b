import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {
//    /*// You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();

    @Test
    public void testWordToDeque() {
        //Deque d = palindrome.wordToDeque("persiflage");
        Deque<Character> d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    }// Uncomment this class once you've created your Palindrome class. */

    @Test
    public void testIsPalindrome() {
        assertTrue("'noon' failed ", palindrome.isPalindrome("noon"));
        assertTrue("One letter failed", palindrome.isPalindrome("a"));
        assertTrue("Empty word failed", palindrome.isPalindrome(""));
        assertFalse("'cat' failed", palindrome.isPalindrome("cat"));
    }

    @Test
    public void testIsPalindromeOffByOne() {
        CharacterComparator obo = new OffByOne();
        assertTrue("flake failed", palindrome.isPalindrome("flake", obo));
        assertTrue("flke failed", palindrome.isPalindrome("flke", obo));
        assertTrue("One letter failed", palindrome.isPalindrome("a", obo));
        assertTrue("Empty word failed", palindrome.isPalindrome("", obo));
        assertFalse("flkea failed", palindrome.isPalindrome("flkea", obo));
    }

    public static void main(String[] args) {
        jh61b.junit.TestRunner.runTests("all", TestPalindrome.class);
    }
}
