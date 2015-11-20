import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PassengerTest {
    Passenger p;
    Passenger p1;
    Passenger p2;
    Passenger p3;

    @Before
    public void setup() {
        p = new Passenger(false, false, false);
        p1 = new Passenger(true, false, false);
        p2 = new Passenger(false, true, false);
        p3 = new Passenger(false, false, true);
    }

    @Test
    public void testGetProcessTime() {
        assertTrue(p.getProcessTime() == 1.0);
        assertTrue(p1.getProcessTime() == 5.0);
    }

    @Test
    public void testGetBusyTime() {
        p2.setBusyStatus(true);
        p3.setBusyStatus(true);

        assertTrue(p.getBusyTime() == 0);
        assertTrue(p1.getBusyTime() == 0);
        assertTrue(p2.getBusyTime() == 5.0);
        assertTrue(p3.getBusyTime() == 5.0);
    }

    @Test
    public void testSetConstructor() {
        assertFalse(p.isSlowPassenger());
        assertTrue(p1.isSlowPassenger());
        assertTrue(p2.isSlowPassenger());
        assertTrue(p3.isSlowPassenger());
    }

    @Test
    public void testPassengerType() {
        p.setFrequentFlyer(true);
        p1.setRegularPassenger(true);

        assertTrue(p.isFrequentFlyer());
        assertTrue(p1.isRegularPassenger());
    }

}