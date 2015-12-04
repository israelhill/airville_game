package project12;

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

    /**
     * a constructor for the class
     * @param hasExcessBaggage
     * @param isReRouted
     * @param isOverbooked
     */
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

    /**
     * get the passenger processing time
     * @return double: process time
     */
    public double getProcessTime() {
        return calculateProcessTime();
    }

    /**
     * set the processing time for the passenger
     * @param time
     */
    public void setProcessTime(double time) {
        this.processTime = time;
    }

    /**
     * return the aount of time this passenger is expected to be busy
     * @return double: busy time
     */
    public double getBusyTime() {
        if(isBusy()) {
            busyTime = calculateProcessTime();
            return busyTime;
        }
        else {
            return busyTime;
        }
    }

    /**
     * calculate the processing time based on the if the passenger is slow or not
     * @return double: process time
     */
    public double calculateProcessTime() {
        if(isSlowPassenger()) {
            return processTime = processTime * SLOW_MULTIPLIER;
        }
        else {
            return processTime;
        }
    }

    /**
     * set the busy status of the passenger
     * @param status
     */
    public void setBusyStatus(boolean status) {
        isBusy = status;
    }

    /**
     * get the passenger's busy status
     * @return true if the passenger is busy, false otherwise
     */
    public boolean isBusy() {
        return isBusy;
    }

    /**
     * check if the passenger is a frequent flyer
     * @return true if the passenger is of type frequent flyer
     */
    public boolean isFrequentFlyer() {
        return isFrequentFlyer;
    }

    /**
     * check if the passenger is normal
     * @return true iof the passenger is of type regular passenger
     */
    public boolean isRegularPassenger() {
        return isRegularPassenger;
    }

    /**
     * check if the passenger is slow
     * @return true if the passenger has been rerouted
     */
    public boolean isReRouted() {
        return isReRouted;
    }

    /**
     * check if the passenger is slow
     * @return true if the passenger's flight was overbooked
     */
    public boolean isOverbooked() {
        return isOverbooked;
    }

    /**
     * check if the passenger is slow
     * @return true if the passenger has excess baggage
     */
    public boolean hasExcessBaggage() {
        return hasExcessBaggage;
    }

    /**
     * set the passenger to be a frequent flyer
     * @param value
     */
    public void setFrequentFlyer(boolean value) {
        isFrequentFlyer = value;
        if(isRegularPassenger()) {
            isRegularPassenger = false;
        }
    }

    /**
     * set the passenger to be normal
     * @param value
     */
    public void setRegularPassenger(boolean value) {
        isRegularPassenger = value;
        if(isFrequentFlyer()) {
            isFrequentFlyer = false;
        }
    }

    /**
     * set excess baggage status
     * @param value
     */
    public void setExcessBaggage(boolean value) {
        hasExcessBaggage = value;
    }

    /**
     * set passenger reroute status
     * @param value
     */
    public void setReRouted(boolean value) {
        isReRouted = value;
    }

    /**
     * set overbooked status
     * @param value
     */
    public void setOverbooked(boolean value) {
        isOverbooked = value;
    }

    /**
     * check if the passenger is of one of the slow types
     * @return true if the passenger is of any of the slow types
     */
    public boolean isSlowPassenger() {
        return isOverbooked() || isReRouted() || hasExcessBaggage();
    }

}
