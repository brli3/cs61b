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

    public void addFirst(T item) {
       items[nextFirst] = item;
       nextFirst--;
       size++;
       if (nextFirst == 0) {
           nextFirst = size - 1;
       }
       if (nextFirst == nextLast) {
           resize();
       }
    }

    public void addLast(T item) {
       items[nextLast] = item;
       nextLast++;
       size++;
       if (nextLast == items.length) {
           nextLast = 0;
       } 
       if (nextFirst == nextLast) {
           resize();
       }
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        for (T item : items) {
            System.out.println(item);
        }
    }

    public T removeFirst() {
        T oldFirst = items[nextFirst+1];
        items[nextFirst+1] = null;
        size--;
        nextFirst++;
        return oldFirst;
    }

    public T removeLast() {
        T oldLast;
        if (nextLast == 0) {
            oldLast = items[items.length-1];
            items[items.length-1] = null;
            nextLast = items.length - 1;
        } else {
            oldLast = items[nextLast-1];
            items[nextLast-1] = null;
            nextLast--;
        }
        size--;
        return oldLast;
    }

    public T get(int index) {
        if (isEmpty() || index > items.length) {
            return null;
        } 
        return items[index];
    }

    private void resize() {

    }

    public static void main(String[] args) {
        ArrayDeque<String> L = new ArrayDeque<>();
        L.addLast("a");
        L.addLast("b");
        L.addFirst("c");
        L.addLast("d");
        L.addLast("e");

        System.out.println("Size = " + L.size() + "\n\n");

        L.printDeque();

        L.removeFirst();

        L.printDeque();
    }
}

