public class Passenger implements Queueable {
    // adds one time unit
    private boolean hasExcessBaggage;
    // adds 2 time units
    private boolean isReRouted;
    // adds 3 time units
    private boolean isOverbooked;

    private boolean isFrequentFlier;
    private boolean isRegularPassenger;
    private double processTime;

    public Passenger(boolean hasExcessBaggage, boolean isReRouted, boolean isOverbooked){
        this.hasExcessBaggage = hasExcessBaggage;
        this.isReRouted = isReRouted;
        this.isOverbooked = isOverbooked;
        processTime = 1.0;
    }


}
