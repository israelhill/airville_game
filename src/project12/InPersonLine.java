package project12;

/**
 * class representing an in person line. This class extends abstract line.
 * @param <T>
 */
public class InPersonLine<T> extends AbstractLine {
    private Queue<Queueable> frequentFlyerLine = new Queue<>();
    private Queue<Queueable> regularPassengerLine = new Queue<>();

    /**
     * a constructor for the class
     */
    public InPersonLine() {
        super();
    }

    /**
     * process the next passenger at the front of the line
     * @return a Queueable passenger
     * @throws InvalidOperationException
     */
    @Override
    public Queueable processNextPassenger() throws InvalidOperationException {
        if(!frequentFlyerLine.isEmpty() && hasAgent()) {
            computePassengerProcessingTime(frequentFlyerLine.peek());
            checkIfLineIsBusy();
            return frequentFlyerLine.dequeue();
        }
        else if(!regularPassengerLine.isEmpty() && hasAgent()) {
            computePassengerProcessingTime(regularPassengerLine.peek());
            checkIfLineIsBusy();
            return regularPassengerLine.dequeue();
        }
        else {
            String message = "Can not process passenger in line that is empty or has no agent";
            throw new InvalidOperationException(InvalidOperationException.ErrorCode.INVALID_LINE, message);
        }

    }

    /**
     * add a passenger to the end of the line
     * @param passenger the passenger to be added
     * @param <E> generic type that must extend Queueable
     * @throws InvalidOperationException
     */
    @Override
    public <E extends Queueable> void addPassenger(E passenger) throws InvalidOperationException {
        checkForNullPassenger(passenger);
        setBusy(true);
        if(passenger.isFrequentFlyer()) {
            frequentFlyerLine.enqueue(passenger);
        }
        else {
            regularPassengerLine.enqueue(passenger);
        }
    }

    /**
     * check if the line is busy and set the busy status of the line
     */
    public void checkIfLineIsBusy() {
        if(regularPassengerLine.isEmpty() && frequentFlyerLine.isEmpty()) {
            setBusy(false);
        }
        else {
            setBusy(true);
        }
    }

    /**
     * get the current number of passengers in the line
     * @return int representing the number of passengers in the line
     */
    public int getLineLength() {
        return frequentFlyerLine.size() + regularPassengerLine.size();
    }

}
