public class AutoLine extends AbstractLine {
    private Queue<Queueable> line = new Queue<>();

    // TODO check for null when adding to the queue

    public AutoLine() {
        super();
    }

    @Override
    public void processNextPassenger() {
        if(!line.isEmpty() && hasAgent()) {
            line.dequeue();
        }
        else {
            // TODO throw an exception
        }

        checkIfLineIsBusy();
    }

    @Override
    void checkIfLineIsBusy() {
        if(line.isEmpty()) {
            setBusy(false);
        }
        else {
            setBusy(true);
        }
    }

    @Override
    void addPassenger(Queueable passenger) {
        setBusy(true);
        line.enqueue(passenger);
        passenger.setBusyStatus(true);
    }

}
