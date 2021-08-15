public class LinkedListDeque<T> {

    /** Nested Node class */
    private static class Node<T> {
        private T item;
        private Node<T> prev;
        private Node<T> next;
        public Node(T i, Node<T> p, Node<T> n) {
            item = i;
            prev = p;
            next = n;
        }
    }

    /** Instance variables */
    private int size = 0;
    
    /* The first item, if exists, is at header.next 
       The last item is at trailer.prev */
    private Node<T> header;
    private Node<T> trailer;

    /** Constructs a new empty list */
    public LinkedListDeque() {
        header = new Node<>(null, null, null);
        trailer = new Node<>(null, header, null);
        header.next = trailer;
    }

    /** Adds an item in between given nodes */
    private void addBetween(T item, Node<T> predecessor, Node<T> successor) {
        Node<T> newest = new Node<>(item, predecessor, successor);
        predecessor.next = newest;
        successor.prev = newest;
        size++;
    }

    /** Add an item at front */
    public void addFirst(T item) {
        addBetween(item, header, header.next);
    }

    public void addLast(T item) {
        addBetween(item, trailer.prev, trailer);
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        Node<T> temp = header.next;
        while (temp != trailer) {
            System.out.println(temp.item);
            temp = temp.next;
        }
    }

    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }
        Node<T> first = header.next;
        first.next.prev = header;
        header.next = first.next;
        size--;
        return first.item;
    }

    public T removeLast() {
        if (isEmpty()) {
            return null;
        }
        Node<T> last = trailer.prev;
        last.prev.next = trailer;
        trailer.prev = last.prev;
        size--;
        return last.item;
    }

    public T get(int index) {
        if (size == 0 || index < 0 || index >= size) {
            return null;
        }
        Node<T> temp = header.next;
        while (index > 0) {
            index--;
            temp = temp.next;
        }
        return temp.item;
    }


    public T getRecursiveHelper(Node<T> currNode, int index) {
        if (index == 0) {
            return currNode.item;
        }
        index--;
        return getRecursiveHelper(currNode.next, index);
    }

    public T getRecursive(int index) {
        if (size == 0 || index < 0 || index >= size) {
            return null;
        }
        return getRecursiveHelper(header.next, index);
    }

    public static void main(String[] args) {
        LinkedListDeque<Integer> L = new LinkedListDeque<>();
        L.addFirst(10);
        L.addFirst(5);
        L.addLast(15);
        L.addLast(20);
        L.printDeque();
        System.out.println("Remove first and last");
        int first = L.removeFirst();
        int last = L.removeLast();
        L.printDeque();
        System.out.println("Add two items to the end");
        L.addLast(25);
        L.addLast(30);
        System.out.println();
        L.printDeque();
        System.out.println("Get item " + 2 + " :" + L.get(2));
        System.out.println("Get item recursively" + 2 + " :" + L.getRecursive(2));
    }

}
