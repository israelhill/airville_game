public class InPersonLine<T> extends AbstractLine {
    private Queue<Queueable> frequentFlyerLine = new Queue<>();
    private Queue<Queueable> regularPassengerLine = new Queue<>();


    public InPersonLine() {
        super();
    }

    @Override
    public void processNextPassenger() throws InvalidOperationException {
        if(!frequentFlyerLine.isEmpty() && hasAgent()) {
            computePassengerProcessingTime(frequentFlyerLine.peek());
            frequentFlyerLine.dequeue();
        }
        else if(!regularPassengerLine.isEmpty() && hasAgent()) {
            computePassengerProcessingTime(regularPassengerLine.peek());
            regularPassengerLine.dequeue();
        }
        else {
            String message = "Can not process passenger in line that is empty";
            throw new InvalidOperationException(InvalidOperationException.ErrorCode.INVALID_LINE, message);
        }

        checkIfLineIsBusy();
    }

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

    public void checkIfLineIsBusy() {
        if(regularPassengerLine.isEmpty() && frequentFlyerLine.isEmpty()) {
            setBusy(false);
        }
        else {
            setBusy(true);
        }
    }

}
