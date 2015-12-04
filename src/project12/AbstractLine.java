package project12;

public abstract class AbstractLine {
    private boolean hasAgent;
    private boolean hasSupervisor;
    private boolean isBusy;
    private int supervisors;
    private static final double SUPERVISOR_PROCESS_BONUS = 0.3;

    /**
     * constructor for the class
     */
    public AbstractLine() {
        hasAgent = false;
        hasSupervisor = false;
        isBusy = false;
        supervisors = 0;
    }

    /**
     * processes the next passenger in the line (ordering constraints in InPersonLine)
     * @return
     * @throws InvalidOperationException
     */
    abstract Queueable processNextPassenger() throws InvalidOperationException;

    /**
     * add a passenger to the end of the line
     * @param passenger
     * @param <E>
     * @throws InvalidOperationException
     */
    abstract <E extends Queueable> void addPassenger(E passenger) throws InvalidOperationException;

    /**
     * returns true if there are passengers in the line
     */
    abstract void checkIfLineIsBusy();

    /**
     * return how many passengers are in the line
     * @return
     */
    abstract int getLineLength();

    /**
     * check if line has a supervisor
     * @return
     */
    boolean hasSupervisor() {
        return hasSupervisor;
    }

    /**
     * check if the line has a agent
     * @return
     */
    boolean hasAgent() {
        return hasAgent;
    }

    /**
     * return whether or not the line is busy or not
     * @return
     */
    boolean isBusy() {
        return isBusy;
    }

    /**
     * set the busy status of the line
     * @param value
     */
    void setBusy(boolean value) {
        isBusy = value;
    }

    /**
     * add a supervisor to the line
     */
    void addSupervisor() {
        supervisors++;
        hasSupervisor = true;
    }

    /**
     * add an agent to the line
     */
    void addAgent() {
        hasAgent = true;
    }

    /**
     * remove the supervisor from this line
     * @throws InvalidOperationException
     */
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

    /**
     * make sure user does not pass in null object
     * @param passenger
     * @throws InvalidOperationException
     */
    void checkForNullPassenger(Queueable passenger) throws InvalidOperationException {
        if(passenger == null) {
            String message = "Passenger is NULL";
            throw new InvalidOperationException(InvalidOperationException.ErrorCode.INVALID_PASSENGER, message);
        }
    }

    /**
     * compute the time it will take for this passenger to be processed
     * @param passenger
     */
    void computePassengerProcessingTime(Queueable passenger) {
        if(hasSupervisor()) {
            double oldProcessTime = passenger.getProcessTime();
            double newProcessTime = oldProcessTime * SUPERVISOR_PROCESS_BONUS;
            passenger.setProcessTime(newProcessTime);
        }
    }

}
