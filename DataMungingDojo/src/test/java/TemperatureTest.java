import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TemperatureTest {

    private Temperature temperature;

    @Before
    public void setUp() throws Exception {
        temperature = new Temperature("weather.dat");

    }

    @Test
    public void smallestSpread() {
        assertThat(temperature.smallestSpreadDay(), is(14));

    }
}
