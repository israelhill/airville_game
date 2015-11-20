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

    abstract void processNextPassenger() throws InvalidOperationException;
    abstract <E extends Queueable> void addPassenger(E passenger) throws InvalidOperationException;
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

    void removeSupervisor() throws InvalidOperationException {
        if(supervisors > 0) {
            supervisors--;
            hasSupervisor = false;
        }
        else {
            String message = "Removing supervisor that does not exist";
            throw new InvalidOperationException(InvalidOperationException.ErrorCode.INVALID_SUPERVISOR, message);
        }
    }

    void checkForNullPassenger(Queueable passenger) throws InvalidOperationException {
        if(passenger == null) {
            String message = "Passenger is NULL";
            throw new InvalidOperationException(InvalidOperationException.ErrorCode.INVALID_PASSENGER, message);
        }
    }

}
