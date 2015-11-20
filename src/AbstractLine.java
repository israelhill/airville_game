public abstract class AbstractLine {
    private boolean hasAgent;
    private boolean hasSupervisor;
    private boolean isBusy;
    private int supervisors;

    public AbstractLine() {
        hasAgent = false;
        hasSupervisor = false;
        isBusy = false;
        supervisors = 0;
    }

    abstract void processNextPassenger();
    abstract <E extends Queueable> void addPassenger(E passenger);
    abstract void checkIfLineIsBusy();

    boolean hasSupervisor() {
        return hasSupervisor;
    }

    boolean hasAgent() {
        return hasAgent;
    }

    boolean isBusy() {
        return isBusy;
    }

    void setBusy(boolean value) {
        isBusy = value;
    }

    void addSupervisor() {
        supervisors++;
        hasSupervisor = true;
    }

    void addAgent() {
        hasAgent = true;
    }

    //TODO removing a supervisor when there are no supervisors
    void removeSupervisor() {
        assert(supervisors != 0);
                
        supervisors--;
        if(supervisors == 0) {
            hasSupervisor = false;
        }
    }

}
