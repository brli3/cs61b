// Done: Make sure to make this class a part of the synthesizer package
package synthesizer;

import java.util.Iterator;

//Done: Make sure to make this class and all of its methods public
//Done: Make sure to make this class extend AbstractBoundedQueue<t>
public class ArrayRingBuffer<T> extends AbstractBoundedQueue<T>  {
    /* Index for the next dequeue or peek. */
    private int first;            // index for the next dequeue or peek
    /* Index for the next enqueue. */
    private int last;
    /* Array for storing the buffer data. */
    private T[] rb;

    /**
     * Create a new ArrayRingBuffer with the given capacity.
     */
    public ArrayRingBuffer(int capacity) {
        // Done: Create new array with capacity elements.
        //       first, last, and fillCount should all be set to 0.
        //       this.capacity should be set appropriately. Note that the local variable
        //       here shadows the field we inherit from AbstractBoundedQueue, so
        //       you'll need to use this.capacity to set the capacity.

        rb = (T[]) new Object[capacity];

        first = 0;
        last = 0;
        fillCount = 0;
        this.capacity = capacity;

    }

    /**
     * Adds x to the end of the ring buffer. If there is no room, then
     * throw new RuntimeException("Ring buffer overflow"). Exceptions
     * covered Monday.
     */
    public void enqueue(T x) {
        // Done: Enqueue the item. Don't forget to increase fillCount and update last.
        if (isFull()) {
            throw new RuntimeException("Ring buffer overflow");
        }
        rb[last] = x;
        last = (last + 1) % rb.length;
        fillCount++;
    }

    /**
     * Dequeue oldest item in the ring buffer. If the buffer is empty, then
     * throw new RuntimeException("Ring buffer underflow"). Exceptions
     * covered Monday.
     */
    public T dequeue() {
        // Done: Dequeue the first item. Don't forget to decrease fillCount and update 
        if (isEmpty()) {
            throw new RuntimeException("Ring buffer underflow");
        }
        T old = rb[first];
        rb[first] = null;
        first = (first + 1) % rb.length;
        fillCount--;
        return old;
    }

    /**
     * Return oldest item, but don't remove it.
     */
    public T peek() {
        // Done: Return the first item. None of your instance variables should change.
        if (isEmpty()) {
            throw new RuntimeException("Ring buffer underflow");
        }
        return rb[first];
    }

    // Done: When you get to part 5, implement the needed code to support iteration.

    /**
      Return an iterator
     */
    @Override
    public Iterator<T> iterator() {
        return new ARBIterator();
    }

    private class ARBIterator implements Iterator<T> {
        private int pos;
        public ARBIterator() {
            pos = first;
        }

        @Override
        public boolean hasNext() {
            return !(pos == last);
        }

        @Override
        public T next() {
            T item = rb[pos];
            pos = (pos + 1) % rb.length;
            return item;
        }
    }
}
