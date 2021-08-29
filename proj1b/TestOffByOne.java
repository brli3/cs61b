import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByOne {
    // You must use this CharacterComparator and not instantiate
    // new ones, or the autograder might be upset.
    static CharacterComparator offByOne = new OffByOne();

    // Your tests go here.

    @Test
    public void testOffbyOne() {
        assertTrue("'a' and 'b' failed", offByOne.equalChars('a', 'b'));
        assertTrue("'r' and 'q' failed", offByOne.equalChars('r', 'q'));
        assertTrue("'&' and '%' failed", offByOne.equalChars('&', '%'));
        assertFalse("'a' and 'e' failed", offByOne.equalChars('a', 'e'));
        assertFalse("'z' and 'a' failed", offByOne.equalChars('z', 'a'));
        assertFalse("'a' and 'B' failed", offByOne.equalChars('a', 'B'));
    }

    public static void main(String[] args) {
        jh61b.junit.TestRunner.runTests("all", TestOffByOne.class);
    }
}
