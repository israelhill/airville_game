public class Passenger implements Queueable {
    private boolean hasExcessBaggage;
    private boolean isReRouted;
    private boolean isOverbooked;
    public static final int SLOW_MULTIPLIER = 5;

    private boolean isFrequentFlyer;
    private boolean isRegularPassenger;
    private double processTime;
    private double busyTime;
    private boolean isBusy;

    public Passenger(boolean hasExcessBaggage, boolean isReRouted, boolean isOverbooked){
        this.hasExcessBaggage = hasExcessBaggage;
        this.isReRouted = isReRouted;
        this.isOverbooked = isOverbooked;

        isFrequentFlyer = false;
        isRegularPassenger = true;
        isBusy = false;

        processTime = 1.0;
        busyTime = 0;
    }

    public double getProcessTime() {
        return calculateProcessTime();
    }

    public double getBusyTime() {
        if(isBusy()) {
            busyTime = calculateProcessTime();
            return busyTime;
        }
        else {
            return busyTime;
        }
    }

    public double calculateProcessTime() {
        if(isSlowPassenger()) {
            return processTime = processTime * SLOW_MULTIPLIER;
        }
        else {
            return processTime;
        }
    }

    public void setBusyStatus(boolean status) {
        isBusy = status;
    }

    public boolean isBusy() {
        return isBusy;
    }

    public boolean isFrequentFlyer() {
        return isFrequentFlyer;
    }

    public boolean isRegularPassenger() {
        return isRegularPassenger;
    }

    public boolean isReRouted() {
        return isReRouted;
    }

    public boolean isOverbooked() {
        return isOverbooked;
    }

    public boolean hasExcessBaggage() {
        return hasExcessBaggage;
    }

    public void setFrequentFlyer(boolean value) {
        isFrequentFlyer = value;
        if(isRegularPassenger()) {
            setRegularPassenger(false);
        }
    }

    public void setRegularPassenger(boolean value) {
        isRegularPassenger = value;
        if(isFrequentFlyer()) {
            setFrequentFlyer(false);
        }
    }

    public void setExcessBaggage(boolean value) {
        hasExcessBaggage = value;
    }

    public void setReRouted(boolean value) {
        isReRouted = value;
    }

    public void setOverbooked(boolean value) {
        isOverbooked = value;
    }

    public boolean isSlowPassenger() {
        return isOverbooked() || isReRouted() || hasExcessBaggage();
    }

}
