package project12;

public class PassengerGroup implements Queueable {
    private int numMembers;
    private double processTime;
    public boolean isBusy;
    public boolean processedInLessThanFiveMinutes;
    public static final double GROUP_MULTIPLIER = 0.8;

    public PassengerGroup(int size) {
        if(size > 1) {
            numMembers = size;
        }
        else {
            numMembers = 2;
        }

        isBusy = false;
        processedInLessThanFiveMinutes = false;
        calculateProcessTime();
    }

    public void calculateProcessTime() {
        processTime = GROUP_MULTIPLIER * numMembers;
        if(getNumMembers() >= 10 && processTime < 5) {
            processedInLessThanFiveMinutes = true;
        }
    }

    public int getNumMembers() {
        return numMembers;
    }

    public double getProcessTime() {
        return processTime;
    }

    public void setProcessTime(double time) {
        processTime = time;
    }

    public boolean awardDiamondBonus() {
        return processedInLessThanFiveMinutes;
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
