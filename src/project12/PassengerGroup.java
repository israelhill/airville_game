package project12;

public class PassengerGroup implements Queueable {
    private int numMembers;
    private double processTime;
    public boolean isBusy;
    public boolean processedInLessThanFiveMinutes;
    public static final double GROUP_MULTIPLIER = 0.8;

    /**
     * a constructor for the class
     * if the size param is not greater than 1, the group is set
     * to size 2 by default
     * @param size
     */
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

    /**
     * compute the processing time of the group based on the number of members contained
     */
    public void calculateProcessTime() {
        processTime = GROUP_MULTIPLIER * numMembers;
        if(getNumMembers() >= 10 && processTime < 5) {
            processedInLessThanFiveMinutes = true;
        }
    }

    /**
     * get the number of members in the group
     * @return int number of members
     */
    public int getNumMembers() {
        return numMembers;
    }

    /**
     * get the group process time
     * @return double process time
     */
    public double getProcessTime() {
        return processTime;
    }

    /**
     * set the group process time
     * @param time
     */
    public void setProcessTime(double time) {
        processTime = time;
    }

    /**
     * check if the player should be awarded a diamond
     * @return true if the player processed a group greater than size 10 in less than 5 minutes
     */
    public boolean awardDiamondBonus() {
        return processedInLessThanFiveMinutes;
    }

    /**
     * check if the group is frequent flyer. By default, groups are not frequent flyers
     * @return false
     */
    @Override
    public boolean isFrequentFlyer() {
        return false;
    }

    /**
     * check if the group should be preocessed as a regular passenger.
     * By default this is true
     * @return true
     */
    @Override
    public boolean isRegularPassenger() {
        return true;
    }

    /**
     * set the busy status of the group
     * @param value
     */
    @Override
    public void setBusyStatus(boolean value) {
        isBusy = value;
    }

}
