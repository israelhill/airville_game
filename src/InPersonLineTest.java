import org.junit.Before;

import static org.junit.Assert.*;

public class InPersonLineTest {
    Passenger p;
    Passenger p1;
    Passenger p2;
    InPersonLine<Queueable> line;
    InPersonLine<Queueable> line2;

    @Before
    public void setup() {
        p = new Passenger(false, false, false);
        p1 = new Passenger(true, false, false);
        p2 = new Passenger(false, false, false);
        line = new InPersonLine<>();
        line2 = new InPersonLine<>();
    }

}