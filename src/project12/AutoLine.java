package project12;

public class AutoLine extends AbstractLine {
    private Queue<Queueable> line = new Queue<>();

    public AutoLine() {
        super();
    }

    @Override
    public Queueable processNextPassenger() throws InvalidOperationException {
        if(!line.isEmpty() && hasAgent()) {
            computePassengerProcessingTime(line.peek());
            checkIfLineIsBusy();
            return line.dequeue();
        }
        else {
            String message = "Can not process passenger in a line that is empty";
            throw new InvalidOperationException(InvalidOperationException.ErrorCode.INVALID_LINE, message);
        }
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

    public int getLineLength() {
        return line.size();
    }

}