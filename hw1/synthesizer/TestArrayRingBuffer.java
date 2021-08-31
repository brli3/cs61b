package synthesizer;
import java.util.Iterator;
import org.junit.Test;
import static org.junit.Assert.*;
/** Tests the ArrayRingBuffer class.
 *  @author Josh Hug
 */

public class TestArrayRingBuffer {
    @Test
    public void someTest() {
        //ArrayRingBuffer arb = new ArrayRingBuffer(10);
        ArrayRingBuffer<Double> arb = new ArrayRingBuffer<>(10);
        arb.enqueue(1.2);
        arb.enqueue(2.4);
        arb.enqueue(3.6);
        arb.enqueue(4.8);
        arb.enqueue(6.0);
        assertEquals(1.2, arb.dequeue(), 0.01);
        assertEquals(2.4, arb.peek(), 0.01);
    }

    @Test
    public void testIterator() {
        ArrayRingBuffer<Double> arb = new ArrayRingBuffer<>(10);
        arb.enqueue(1.2);
        arb.enqueue(2.4);
        arb.enqueue(3.6);
        arb.enqueue(4.8);
        arb.enqueue(6.0);

        Iterator<Double> arbIter = arb.iterator();
        assertTrue(arbIter.hasNext());
        assertEquals(1.2, arbIter.next(), 0.001);
        while (arbIter.hasNext()) {
            double x = arbIter.next();
        }
        assertFalse(arbIter.hasNext());

        for (double x : arb) {
        }
    }

    /** Calls tests for ArrayRingBuffer. */
    public static void main(String[] args) {
        jh61b.junit.textui.runClasses(TestArrayRingBuffer.class);
    }
} 
