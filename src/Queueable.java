public interface Queueable {
    
    boolean isFrequentFlyer();

    boolean isRegularPassenger();
    
    void setBusyStatus(boolean value);
    
    double getProcessTime();
    
    void setProcessTime(double time);
}
