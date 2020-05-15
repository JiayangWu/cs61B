public class LinkedListDeque<T> {
    private Node first;
    private Node last; // sentinel.next should be the first, sentinel.next.pre should be the last

    private Node sentinel;
    private int size;

    public class Node {
        private Node prev;
        private T item;
        private Node next;

        public Node(T n) {
            item = n;
        }
    }

    public LinkedListDeque() {
        size = 0;
        sentinel = new Node(null);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
    }

    public void addFirst(T item) {
        sentinel.next = new Node(item);
        first = sentinel.next;
        first.prev = first;
        size = 1;
    }

    public void addLast(T item) {
        first = sentinel.next;
        Node prevLast = first.prev;
        Node newLast = new Node(item);

        prevLast.next = newLast;
        newLast.prev = prevLast;
        newLast.next = first;
        first.prev = newLast;
        last = newLast;
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
        while (p.next != null && p.next != first) {
            p = p.next;
            System.out.print(p.item + " ");
        }
    }

    public T removeFirst() {
        if (first == null) {
            return null;
        }
        if (size == 1) {
            sentinel.next = null;
        } else {
            Node second = first.next;
            sentinel.next = second;
            second.prev = first.prev;
        }
        size -= 1;
        first.next = null;
        first.prev = null;
        return first.item;
    }

    public T removeLast() {
        first = sentinel.next;
        if (first == null) {
            return null;
        }

        if (size == 1) {
            sentinel.next = null;
        } else {
            last = first.prev;
            Node newLast = last.prev;
            newLast.next = first;
            first.prev = newLast;
        }
        size -= 1;
        last.next = null;
        last.prev = null;
        return last.item;
    }

    public T get(int index) {
        int idx = 0;
        Node p = sentinel.next;
        while (idx < index && p.next != sentinel.next) {
            idx += 1;
            p = p.next;
        }
        if (idx == index) {
            return p.item;
        }
        return null;
    }

    public T getRecursive(int index) {
        if (index == 0) {
            if (size > 0) {
                return sentinel.next.item;
            }
            return null;
        }
        return getRecursive(index - 1);
    }
}
