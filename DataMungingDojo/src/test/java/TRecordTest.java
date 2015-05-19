import static org.hamcrest.CoreMatchers.is;

import org.junit.Assert;
import org.junit.Test;

public class TRecordTest{

    @Test(expected = IllegalArgumentException.class)
    public void parseNullRecord() {
        new TRecord(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void parseEmptyRecord() {
        new TRecord("");
    }

    @Test
    public void parseRecord() {
        assertRecord("   1  88    59    74          53.8       0.00 F       280  9.6 270  17  1.6  93 23 1004.5", 1,
                88.0, 59.0);
    }

    @Test
    public void parseRecordWithStars() {
        assertRecord("   1  88    59*    74          53.8       0.00 F       280  9.6 270  17  1.6  93 23 1004.5", 1,
                88.0, 59.0);

    }

    private void assertRecord(String toParse, int expectedDay, double expectedMaxT, double expectedMinT) {
        TRecord record = new TRecord(toParse);
        Assert.assertThat(record.getDay(), is(expectedDay));
        Assert.assertThat(record.getMaxTemp(), is(expectedMaxT));
        Assert.assertThat(record.getMinTemp(), is(expectedMinT));
    }
}