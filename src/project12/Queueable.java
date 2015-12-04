package project12;

/**
 * This is an interface to specify the behavior required by items queued into lines
 */
public interface Queueable {

    /**
     * check if the Queueable object is a frequent flyer
     * @return true if frequent flyer, false otherwise
     */
    boolean isFrequentFlyer();

    /**
     * check if the Queueable object is a regular passenger
     * @return true if it is a regular passenger, false otherwise
     */
    boolean isRegularPassenger();

    /**
     * set the busy status of the Queueable object
     * @param value
     */
    void setBusyStatus(boolean value);

    /**
     * get the time it will take to process the Queueable object
     * @return double process time
     */
    double getProcessTime();

    /**
     * set the time it will take to process the Queueable object
     * @param time
     */
    void setProcessTime(double time);
}
