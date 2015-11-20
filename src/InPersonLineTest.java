import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class InPersonLineTest {
    Passenger p;
    Passenger p1;
    Passenger p2;
    PassengerGroup g;
    PassengerGroup g2;
    PassengerGroup g3;
    InPersonLine<Queueable> line;
    InPersonLine<Queueable> line2;

    @Before
    public void setup() {
        p = new Passenger(false, false, false);
        p1 = new Passenger(true, false, false);
        p2 = new Passenger(false, false, false);
        g = new PassengerGroup(10);
        g2 = new PassengerGroup(20);
        g3 = new PassengerGroup(30);
        line = new InPersonLine<>();
        line2 = new InPersonLine<>();
    }

    @Test
    public void testValidAddPassenger() throws InvalidOperationException {
        line.addPassenger(p);
        line.addPassenger(p1);
        line.addPassenger(p2);

        assertTrue(line.getLineLength() == 3);
    }

    @Test
    public void testProcessPassenger() throws InvalidOperationException {
        line.addPassenger(p);
        line.addPassenger(p1);
        line.addPassenger(p2);
        line.addPassenger(g);
        line.addAgent();

        line.processNextPassenger();
        line.processNextPassenger();
        line.processNextPassenger();
        line.processNextPassenger();

        assertTrue(line.getLineLength() == 0);
    }

    @Test(expected = InvalidOperationException.class)
    public void testProcessPassengerWithNoAgent() throws InvalidOperationException {
        line.addPassenger(p);
        line.addPassenger(p1);
        line.addPassenger(p2);

        line.processNextPassenger();
        line.processNextPassenger();
    }

    /**
     * frequent flyer at the end of the line should be processed first
     * @throws InvalidOperationException
     */
    @Test
    public void testProcessingOrderingConstraint() throws InvalidOperationException {
        p2.setFrequentFlyer(true);
        line.addPassenger(p);
        line.addPassenger(p1);
        line.addPassenger(p2);
        line.addAgent();

        assertTrue(line.processNextPassenger().isFrequentFlyer());
    }

}