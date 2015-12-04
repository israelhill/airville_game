package project12;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AutoLineTest {
    Passenger p;
    Passenger p1;
    Passenger p2;
    AutoLine a = new AutoLine();

    @Before
    public void setup() {
        p = new Passenger(false, false, false);
        p1 = new Passenger(true, false, false);
        p2 = new Passenger(false, false, false);

        a = new AutoLine();
    }

    @Test
    public void testAddPassenger() throws InvalidOperationException {
        a.addPassenger(p);
        a.addPassenger(p1);
        a.addPassenger(p2);

        assertTrue(a.getLineLength() == 3);
    }

    @Test
    public void testProcessPassenger() throws InvalidOperationException {
        a.addPassenger(p);
        a.addPassenger(p1);
        a.addPassenger(p2);
        a.addAgent();

        a.processNextPassenger();
        a.processNextPassenger();
        a.processNextPassenger();

        assertTrue(a.getLineLength() == 0);

    }

}