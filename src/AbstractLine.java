public abstract class AbstractLine {
    private boolean hasAgent;
    private boolean hasSupervisor;
    private boolean isBusy;
    private int supervisors;
    private static final double SUPERVISOR_PROCESS_BONUS = 0.3;

    public AbstractLine() {
        hasAgent = false;
        hasSupervisor = false;
        isBusy = false;
        supervisors = 0;
    }

    abstract Queueable processNextPassenger() throws InvalidOperationException;
    abstract <E extends Queueable> void addPassenger(E passenger) throws InvalidOperationException;
    abstract void checkIfLineIsBusy();
    abstract int getLineLength();

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

    void computePassengerProcessingTime(Queueable passenger) {
        if(hasSupervisor()) {
            double oldProcessTime = passenger.getProcessTime();
            double newProcessTime = oldProcessTime * SUPERVISOR_PROCESS_BONUS;
            passenger.setProcessTime(newProcessTime);
        }
    }

}
