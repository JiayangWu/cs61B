/** Array based list.
 *  @author Josh Hug
 */

public class AList {
    int[] items;
    int size;
    /** Creates an empty list. */
    public AList() {
        items = new int[100];
        size = 0;
    }

    /** Inserts X into the back of the list. */
    public void addLast(int x) {
        if (size >= items.length){
            return;
        }
        items[size] = x;
        size += 1;
    }

    /** Returns the item from the back of the list. */
    public int getLast() {
        return items[size - 1];
    }
    /** Gets the ith item in the list (0 is the front). */
    public int get(int i) {
        if (i >= items.length){
            return -1;
        }
        return items[i];
    }

    /** Returns the number of items in the list. */
    public int size() {
        return size;        
    }

    /** Deletes item from back of the list and
      * returns deleted item. */
    public int removeLast() {
        int last = items[size - 1];
        size -= 1;
        return last;
    }
} 