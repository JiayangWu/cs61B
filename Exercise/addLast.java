public class SLList {
    public class IntNode {
        public int item;
        public IntNode next;
        public IntNode(int i, IntNode n) {
            item = i;
            next = n;
        }
    }

    private IntNode first; 

    public SLList(int x) {
        first = new IntNode(x, null);
    }

    /** Adds an item to the front of the list. */
    public void addFirst(int x) {
        first = new IntNode(x, first);
    }    

    /** Retrieves the front item from the list. */
    public int getFirst() {
        return first.item;
    }

    /** Adds an item to the end of the list. */
    public void addLast(int x) {
        /* Your Code Here! */
        IntNode curLast = first;
        while (curLast.next != null){
            curLast = curLast.next;
        }
        curLast.next = new IntNode(x);
    }

    /** Returns the number of items in the list using recursion. */
    public int size() {
        /* Your Code Here! */
        int size = 0;
        IntNode curLast = first;
        while (curLast.next != null){
            curLast = curLast.next;
            size += 1;
        }
        return size;
    }

}
