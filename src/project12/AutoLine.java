package project12;
/**
 * class representing automated lines.
 * This class extends AbstractLine.
 */
public class AutoLine extends AbstractLine {
    private Queue<Queueable> line = new Queue<>();

    /**
     * a constructor for the class
     */
    public AutoLine() {
        super();
    }

    /**
     * process the next passenger in a line
     * @return a Queueable passenger
     * @throws InvalidOperationException if line is empty
     */
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

    /**
     * check if a line is busy and set the busy status of the line
     */
    @Override
    void checkIfLineIsBusy() {
        if(line.isEmpty()) {
            setBusy(false);
        }
        else {
            setBusy(true);
        }
    }

    /**
     * add a passenger to the end of a line
     * @param passenger the passenger you want to add to the line
     * @throws InvalidOperationException
     */
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
