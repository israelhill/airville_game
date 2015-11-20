public class InPersonLine<T> extends AbstractLine {
    private Queue<Queueable> frequentFlyerLine = new Queue<>();
    private Queue<Queueable> regularPassengerLine = new Queue<>();
    private boolean hasSupervisor;

    public InPersonLine() {
        hasSupervisor = false;
    }

    @Override
    public void processNextPassenger() {

    }

    @Override
    public <E extends Queueable> void addPassenger(E passenger) {
        if(passenger.isFrequentFlyer()) {
            frequentFlyerLine.enqueue(passenger);
        }
        else {
            regularPassengerLine.enqueue(passenger);
        }
    }

    public boolean hasSupervisor() {
        return hasSupervisor;
    }

    public void setSupervisor() {
        hasSupervisor = true;
    }

}
