public abstract class AbstractLine {

    abstract void processNextPassenger();
    abstract void addPassenger(Passenger p);

    public class Queue<Item extends Queueable> {
        private Node first;
        private Node last;
        private int N;

        public boolean isEmpty() {
            return N == 0;
        }

        public int size() {
            return N;
        }

        public void enqueue(Item item) {
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

        public Item dequeue() {
            Item item = first.item;
            first = first.next;
            if(isEmpty()) {
                last = null;
            }
            N--;
            return item;
        }

        //*********************
        private class Node {
            Item item;
            Node next;
        }
        //*********************

    }
}
