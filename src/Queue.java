public class Queue<T> {
    private Node first;
    private Node last;
    private int N;

    /**
     * check if the queue is empty
     * @return
     */
    public boolean isEmpty() {
        return N == 0;
    }

    /**
     * get the number of items in the queue
     * @return
     */
    public int size() {
        return N;
    }

    /**
     * add an item to the queue
     * @param item
     */
    public void enqueue(T item) {
        Node oldLast = last;
        last = new Node();
        last.item = item;
        last.next = null;

        if(isEmpty()) {
            first = last;
        }
        else {
            oldLast.next = last;
        }
        N++;
    }

    /**
     * get the item at the top of the queue (do not dequeue it however)
     * @return
     */
    public T peek() {
        return first.item;
    }

    /**
     * remove the item at the top of the queue
     * @return
     */
    public T dequeue() {
        T item = first.item;
        first = first.next;
        if(isEmpty()) {
            last = null;
        }
        N--;
        return item;
    }

    //an inner class to be used by Queue
    //*********************
    private class Node {
        T item;
        Node next;
    }
    //*********************

}
