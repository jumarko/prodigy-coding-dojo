import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class StringCalculatorTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    final StringCalculator calculator = new StringCalculator();

    @Test
    public void noNumbers() {
        assertThat(calculator.add(""), is(0));
        assertThat(calculator.add("  "), is(0));
    }

    @Test
    public void oneNumber() {
        assertThat(calculator.add("10"), is(10));
        assertThat(calculator.add(" 10   "), is(10));
    }

    @Test
    public void twoNumbers() {
        assertThat(calculator.add("10,20"), is(30));
        assertThat(calculator.add(" 10, 20   "), is(30));
    }

    @Test
    public void multipleNumbers() {
        assertThat(calculator.add("10,20,30,60,50,40"), is(210));
        assertThat(calculator.add(" 10, 20, 30,   60,   50,40  "), is(210));
    }

    @Test
    public void newLineSeparator() {
        assertThat(calculator.add("10\n20,30"), is(60));
        assertThat(calculator.add("10\n20\n30"), is(60));
    }

    @Test(expected = NumberFormatException.class)
    public void doubleCommaAtTheEnd() {
        calculator.add("10,20,30,,");
    }

    @Test(expected = NumberFormatException.class)
    public void doubleCommaInTheMiddle() {
        calculator.add("10,20,,30");
    }

    @Test(expected = NumberFormatException.class)
    public void newLineAndCommaAtTheEnd() {
        calculator.add("10\n20,30,\n");
    }

    @Test(expected = NumberFormatException.class)
    public void newLineAndCommaInTheMiddle() {
        calculator.add("10\n20\n,30");
    }

    @Test(expected = NumberFormatException.class)
    public void newLineAndCommaAtTheBeginning() {
        calculator.add("\n,10\n20\n30");
    }

    @Test(expected = NumberFormatException.class)
    public void doubleNewLineAtTheEnd() {
        calculator.add("10\n20\n30\n\n");
    }

    @Test(expected = NumberFormatException.class)
    public void doubleNewLineInTheMiddle() {
        calculator.add("10\n20\n\n30");
    }

    @Test(expected = NumberFormatException.class)
    public void doubleNewLineAtTheBeginning() {
        calculator.add("\n\n10\n20\n30");
    }

    @Test
    public void customDelimiter() {
        assertThat(calculator.add("//;\n1;2"), is(3));
    }

    @Test
    public void customDelimiterWithDefaults() {
        assertThat(calculator.add("//;\n10\n20,30;40"), is(100));
    }

    @Test
    public void customDelimiterEmpty() {
        assertThat(calculator.add("//;\n"), is(0));
    }

    @Test
    public void negativeNumber() {
        expectedException.expect(StringCalculatorException.class);
        expectedException.expectMessage("negative numbers not supported: -574985");
        calculator.add("-574985");
    }

    @Test
    public void multipleNegativeNumber() {
        expectedException.expect(StringCalculatorException.class);
        expectedException.expectMessage("negative numbers not supported: -10,-1,-3");
        calculator.add("1,3,-10,0,-1,10,-3,100");
    }
}