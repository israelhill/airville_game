package project12;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PassengerGroupTest {
    PassengerGroup g;
    PassengerGroup g2;
    PassengerGroup g3;


    @Before
    public void setup() {
        g = new PassengerGroup(10);
        g2 = new PassengerGroup(20);
        g3 = new PassengerGroup(30);
    }

    @Test
    public void testGetProcessTime() {
        assertTrue(g.getProcessTime() == 8.0);
        assertTrue(g2.getProcessTime() == 16.0);
        assertTrue(g3.getProcessTime() == 24.0);
    }



}