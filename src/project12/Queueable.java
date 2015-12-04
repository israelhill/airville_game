package project12;

/**
 * This is an interface to specify the behavior required by items
 */
public interface Queueable {
    
    boolean isFrequentFlyer();

    boolean isRegularPassenger();
    
    void setBusyStatus(boolean value);
    
    double getProcessTime();
    
    void setProcessTime(double time);
}
