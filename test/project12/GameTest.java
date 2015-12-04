package project12;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class GameTest {
    Game g;
    Game g2;
    Game g3;

    @Before
    public void setup() {
        g = new Game();
        g2 = new Game();
        g3 = new Game();
    }

    @Test
    public void testConstructor() {
        assertFalse(g.hasDiamonds());
        assertTrue(g.getSupervisors() == 1);
    }

    @Test
    public void testGetDiamonds() {
        g2.addDiamond();
        g2.addDiamond();
        g2.addDiamond();

        assertTrue(g2.getDiamonds() == 3);
        assertTrue(g3.getDiamonds() == 0);
    }

    @Test
    public void testPurchase() throws InvalidOperationException {
        g.addDiamond();
        g2.addDiamond();
        g2.addDiamond();
        g3.addDiamond();
        g3.addDiamond();
        g3.addDiamond();

        g.redeemAgent();
        g2.redeemSupervisor();
        g3.redeemInPersonLines();

        assertTrue(g.getDiamonds() == 0);
        assertTrue(g2.getSupervisors() == 2);
        assertTrue(g2.getDiamonds() == 1);
        assertTrue(g3.getDiamonds() == 2);
    }

    @Test
    public void stressTest() throws InvalidOperationException {
        for(int i = 0; i < 10000000; i++) {
            g.addDiamond();
        }
        assertTrue(g.getDiamonds() == 10000000);

        for(int i = 0; i < 10000000; i++) {
            g.redeemInPersonLines();
            g.addDiamond();
            g.redeemSupervisor();
        }

        assertTrue(g.getDiamonds() == 0);
        assertTrue(g.getSupervisors() == 10000001);
    }

}