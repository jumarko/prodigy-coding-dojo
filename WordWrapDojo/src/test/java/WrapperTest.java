import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        WrapperTest.DegeneratedTests.class,
        WrapperTest.WrapWordsTests.class
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

    public static class WrapWordsTests {

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



        @Test
        public void testWrapWithSpace() {
           assertEquals("wrap\nme", Wrapper.wrap("wrap me", 4));

        }

        @Test
        public void testWrapWithMoreSpaces() {
           assertEquals("wrap\nme\nwrap\nme\nwrap", Wrapper.wrap("wrap me wrap me wrap", 4));

        }

        @Test
        public void testWrapWithMoreSpaces2() {
            assertEquals("wrap me\nwrap me\nwrap", Wrapper.wrap("wrap me wrap me wrap", 10));
        }



        @Test
        public void shortColumnLength() {
            assertEquals("wor\nd\nwor\nd", Wrapper.wrap("word word", 3));
        }

        @Test
        public void longColumnLength() {
            assertEquals("word word\nword", Wrapper.wrap("word word word", 12));
        }


    }
}