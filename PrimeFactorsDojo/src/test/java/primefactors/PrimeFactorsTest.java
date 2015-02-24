package primefactors;

import static java.util.Arrays.asList;
import static java.util.Collections.singletonList;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static primefactors.PrimeFactors.generate;

import org.junit.Test;
import java.util.Collections;

public class PrimeFactorsTest {

    @Test
    public void zeroShouldReturnEmptyList() {
        assertThat(generate(0), is(Collections.<Integer>emptyList()));
    }

    @Test
    public void oneShouldReturnEmptyList() {
        assertThat(generate(1), is(Collections.<Integer>emptyList()));
    }

    @Test
    public void primeShouldReturnItself() {
        assertThat(generate(2), is(singletonList(2)));
        assertThat(generate(3), is(singletonList(3)));
        assertThat(generate(11), is(singletonList(11)));
        assertThat(generate(643), is(singletonList(643)));
    }

    @Test
    public void shouldReturnPrimeNumbers() {
         assertThat(generate(4), is(asList(2, 2)));
    }

    @Test
    public void shouldReturnPrimeNumbers2() {
        assertThat(generate(6), is(asList(2, 3)));
    }

    @Test
    public void testEight() {
        assertThat(generate(8), is(asList(2, 2, 2)));
    }

    @Test
    public void testNine() {
        assertThat(generate(9), is(asList(3, 3)));
    }

    @Test
    public void test25() {
        assertThat(generate(25), is(asList(5, 5)));
        assertThat(generate(39), is(asList(3, 13)));
        assertThat(generate(63), is(asList(3, 3, 7)));
    }

    @Test
    public void million() {
//        assertThat(generate(1000000), is(asList(2, 2, 2, )));

    }

    @Test
    public void bigPrimeNumber() {
        assertThat(generate(2147483647), is(asList(2147483647)));
    }
}