package synthesizer;
import java.util.Iterator;
public interface BoundedQueue<T> extends Iterable<T> {

    /** return size of the buffer */
    int capacity();

    /** return number of items currently in the buffer */
    int fillCount();

    /** add an item to the end */
    void enqueue(T x);

    /** delete and return item from front */
    T dequeue();

    /** return but not delete item from front */
    T peek();

    default boolean isEmpty() {
        return fillCount() == 0;
    }

    default boolean isFull() {
        return fillCount() == capacity();
    }
    
    /** return an iterator object */
    Iterator<T> iterator();
}
