import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        WrapperTest.DegeneratedTests.class,
        WrapperTest.NormalTests.class
})
public class WrapperTest {

    public static class DegeneratedTests {
        @Test
        public void testEmptyString() {
            assertEquals("", Wrapper.wrap("", 10));
        }

        @Test
        public void testColumnLargerThanString() {
            assertEquals("somestring", Wrapper.wrap("somestring", 10));
        }
    }

    public static class NormalTests {

        @Test
        public void testSingleWrap() {
            assertEquals("wrap\nme", Wrapper.wrap("wrapme", 4));
        }

        @Test
        public void testMultipleWraps() {
            assertEquals("wrap\nmewr\napme\nwrap\nme", Wrapper.wrap("wrapmewrapmewrapme", 4));
        }

        @Test
        public void testMultipleExactWraps() {
            assertEquals("wrap\nmewr\napme\nwrap", Wrapper.wrap("wrapmewrapmewrap", 4));
        }

    }
}