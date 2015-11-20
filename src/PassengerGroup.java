public class PassengerGroup implements Queueable {
    private int numMembers;
    private double processTime;

    public PassengerGroup(int size) {
        numMembers = size;
        calculateProcessTime();
    }

    public void calculateProcessTime() {
        processTime = 0.6 * numMembers;
    }

    public int getNumMembers() {
        return numMembers;
    }

    public double getProcessTime() {
        return processTime;
    }

    @Override
    public boolean isFrequentFlyer() {
        return false;
    }

    @Override
    public boolean isRegularPassenger() {
        return false;
    }

    @Override
    public boolean isReRouted() {
        return false;
    }

    @Override
    public boolean isOverbooked() {
        return false;
    }

    @Override
    public boolean isHasExcessBaggage() {
        return false;
    }
}
