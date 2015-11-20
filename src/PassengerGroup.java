public class PassengerGroup implements Queueable {
    private int numMembers;
    private double processTime;
    public boolean isBusy;
    public static final double GROUP_MULTIPLIER = 0.8;

    public PassengerGroup(int size) {
        numMembers = size;
        isBusy = false;
        calculateProcessTime();
    }

    public void calculateProcessTime() {
        processTime = GROUP_MULTIPLIER * numMembers;
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
        return true;
    }

    @Override
    public void setBusyStatus(boolean value) {
        isBusy = value;
    }

}
