public class LinkedListDeque<T> {
    // sentinel.next should be the first, sentinel.next.pre should be the last

    private Node sentinel;
    private int size;

    public class Node {
        private Node prev;
        private T item;
        private Node next;

        public Node(Node p, T i, Node n) {
            prev = p;
            item = i;
            next = n;
        }
    }

    public LinkedListDeque() {
        size = 0;
        sentinel = new Node(null, null, null);
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
    }

    public void addFirst(T item) {
        Node newNode = new Node(sentinel, item, sentinel.next);
        sentinel.next.prev = newNode;
        sentinel.next = newNode;
        size += 1;
    }

    public void addLast(T item) {
        Node newNode = new Node(sentinel.prev, item, sentinel);
        sentinel.prev.next = newNode;
        sentinel.prev = newNode;
        size += 1;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        Node p = sentinel.next;
        while (p.next != null && p != sentinel) {
            System.out.print(p.item + " ");
            p = p.next;
        }
        System.out.println("");
    }

    public T removeFirst() {
        if (size == 0){
            return null;
        }
        Node prevFirst = sentinel.next;
        sentinel.next = prevFirst.next;
        sentinel.next.prev = sentinel;
        size -= 1;
        return prevFirst.item;
    }

    public T removeLast() {
        if (size == 0){
            return null;
        }
        Node prevLast = sentinel.prev;
        sentinel.prev = prevLast.prev;
        sentinel.prev.next = sentinel;
        size -= 1;
        return prevLast.item;
    }

    public T get(int index) {
        if (index > size){
            return null;
        }
        Node p = sentinel.next;
        while (index > 0) {
            p = p.next;
            index -= 1;
        }
        return p.item;
    }

    public T getRecursive(int index) {
        if (index > size) {
            return null;
        }
        return getRecursiveHelper(sentinel.next, index);
    }

    public T getRecursiveHelper(Node n, int index) {
        if (index == 0) {
            return n.item;
        }
        return getRecursiveHelper(n.next, index - 1);

    }
}
