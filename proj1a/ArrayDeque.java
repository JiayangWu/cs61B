public class ArrayDeque<T> {
    /* Invariants: start is always the next free front position,
                   end is always the next free back position.
     */
    private T[] items;
    private int size;
    private int start;
    private int end;

    public ArrayDeque() {
        items = (T[]) new Object[8];
        start = 0;
        end = 1;
        size = 0;
    }

    public void addFirst(T item) {
        if (size == items.length) {
            resize(size * 2);
        }
        items[start] = item;
        start = (start - 1 + items.length) % items.length;
        size += 1;
    }

    public void addLast(T item) {
        if (size == items.length) {
            resize(size * 2);
        }
        items[end] = item;
        end = (end + 1) % items.length;
        size += 1;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void printDeque() {
        for (int i = (start + 1) % size; i != end; i = (i + 1) % items.length) {
            System.out.print(items[i]);
        }
        System.out.println();
    }
    public T removeFirst() {
        if (size == 0) {
            return null;
        }
        start = (start + 1) % items.length;
        T itemToReturn = items[start];
        items[start] = null;
        size -= 1;
        if (items.length > 16 && size * 4 < items.length) {
            resize(size);
        }
        return itemToReturn;
    }

    public T removeLast() {
        if (size == 0) {
            return null;
        }
        end = (end - 1 + items.length) % items.length;
        T itemToReturn = items[end];
        items[end] = null;
        size -= 1;
        if (items.length > 16 && size * 4 < items.length) {
            resize(size);
        }
        return itemToReturn;

    }

    public int size() {
        return size;
    }

    public T get(int index) {
        return items[(start + index + 1) % items.length];
    }

    private void resize(int newSize) {
        T[] tempArray = (T[]) new Object[newSize];
        int j = 0;
        for (int i = (start + 1) % items.length; j != size; i = (i + 1) % items.length) {
            tempArray[j] = items[i];
            j += 1;
        }
        items = tempArray;
        start = newSize - 1;
        end = size;
    }

    // public ArrayDeque(ArrayDeque other) {
    //     items = (T[]) new Object[other.size];
    //     size = 0;
    //     start = 0;
    //     end = 1;
    //     for (int i = 0; i < other.size; i++) {
    //         addLast((T) other.get(i));
    //     }
    // }
}
