public class Queue<T> {
    private Node first;
    private Node last;
    private int N;

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

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

    public T dequeue() {
        T item = first.item;
        first = first.next;
        if(isEmpty()) {
            last = null;
        }
        N--;
        return item;
    }

    //*********************
    private class Node {
        T item;
        Node next;
    }
    //*********************

}
