public class AutoLine extends AbstractLine {
    private Queue<Queueable> line = new Queue<>();

    public AutoLine() {
        super();
    }

    @Override
    public void processNextPassenger() throws InvalidOperationException {
        if(!line.isEmpty() && hasAgent()) {
            computePassengerProcessingTime(line.peek());
            line.dequeue();
        }
        else {
            String message = "Can not process passenger in a line that is empty";
            throw new InvalidOperationException(InvalidOperationException.ErrorCode.INVALID_LINE, message);
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
    void addPassenger(Queueable passenger) throws InvalidOperationException {
        checkForNullPassenger(passenger);
        setBusy(true);
        line.enqueue(passenger);
        passenger.setBusyStatus(true);
    }

}
