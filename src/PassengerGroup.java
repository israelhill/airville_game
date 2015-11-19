public class PassengerGroup implements Queueable {
    private int numMembers;
    private double processTime;

    public PassengerGroup(int size) {
        numMembers = size;
        calculateProcessTime();
    }

    public void calculateProcessTime() {
        processTime = 0.6 * numMembers;
    }

    public int getNumMembers() {
        return numMembers;
    }

    public double getProcessTime() {
        return processTime;
    }
}
