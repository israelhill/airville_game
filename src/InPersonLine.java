public class InPersonLine<T> extends AbstractLine {
    private Queue<Queueable> frequentFlyerLine = new Queue<>();
    private Queue<Queueable> regularPassengerLine = new Queue<>();


    public InPersonLine() {
        super();
    }

    @Override
    public void processNextPassenger() {
        if(!frequentFlyerLine.isEmpty() && hasAgent()) {
            frequentFlyerLine.dequeue();
        }
        else if(!regularPassengerLine.isEmpty() && hasAgent()) {
            regularPassengerLine.dequeue();
        }
        else {
            // TODO throw an exception
        }

        checkIfLineIsBusy();
    }

    @Override
    public <E extends Queueable> void addPassenger(E passenger) {
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
