public class ArrayDeque<T> {

    private T[] items;
    private int nextFirst;
    private int nextLast;
    private int size;

    public ArrayDeque() {
        items = (T[]) new Object[8];
        nextFirst = 4;
        nextLast = 5;
        size = 0;
    }


    private boolean isFull() {
        return size == items.length;
    }

    private boolean isSparse() {
        return items.length >= 16 && size < (items.length*0.25);
    }

    private int plusOne(int index) {
        return (index + 1) % items.length;
    }

    private int minusOne(int index) {
        return (index - 1 + items.length) % items.length;
    }

    private void resize(int capacity) {
        T[] newDeque = (T[]) new Object[capacity];
        /* index of first item in the old deque */
        int oldIndex = plusOne(nextFirst);
        /* new deque starts from index 0 */
        for (int newIndex = 0; newIndex < size; newIndex++) {
            newDeque[newIndex] = items[oldIndex];
            oldIndex = plusOne(oldIndex);
        }
        items = newDeque;
        nextFirst = capacity - 1;
        nextLast = size;
    }

    private void upSize() {
        resize(size * 2);
    }

    private void downSize() {
        resize(items.length / 2);
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void printDeque() {
        for (int i = plusOne(nextFirst); i != nextLast; i = plusOne(i)) {
            System.out.print(items[i] + " ");
        }
        System.out.println();
    }

    public void addFirst(T item) {
        if (isFull()) {
            upSize();
        }
        items[nextFirst] = item;
        nextFirst = minusOne(nextFirst);
        size++;
    }

    public void addLast(T item) {
        if (isFull()) {
            upSize();
        }
        items[nextLast] = item;
        nextLast = plusOne(nextLast);
        size++;
    }

    public T removeFirst() {
        if (isSparse()) {
            downSize();
        }
        nextFirst = plusOne(nextFirst);
        T oldItem = items[nextFirst];
        items[nextFirst] = null;
        if (!isEmpty()) {
            size--;
        }
        return oldItem;
    }

    public T removeLast() {
        if (isSparse()) {
            downSize();
        }
        nextLast = minusOne(nextLast);
        T oldItem = items[nextLast];
        items[nextLast] = null;
        if (!isEmpty()) {
            size--;
        }
        return oldItem;
    }

    public T get(int index) {
        if (index >= size) {
            return null;
        }
        int start = plusOne(nextFirst);
        return items[(start + index) % items.length];
    }

    /*
       public static void main(String[] args) {
       ArrayDeque<String> L = new ArrayDeque<>();

       L.addLast("a");
       L.addLast("b");
       L.addFirst("c");
       L.addLast("d");
       L.addLast("e");

       L.printDeque();

       System.out.println("Size = " + L.size());
       System.out.println();

       L.removeFirst();

       L.printDeque();

       L.addLast("f");
       L.addFirst("a");
       L.addFirst("2");
       L.addFirst("1");
       L.addLast("g");
       L.addLast("h");
       L.addLast("i");

       L.printDeque();

       System.out.println("Size = " + L.size());
       }
     */
}

