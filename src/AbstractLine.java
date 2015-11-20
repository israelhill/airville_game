public abstract class AbstractLine {
    abstract void processNextPassenger();
    abstract <E extends Queueable> void addPassenger(E passenger);

}
