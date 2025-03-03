import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ValidParenthesesTest {

    ValidParentheses vp = new ValidParentheses();

    @Test
    void test1() {
        assertTrue(vp.isValid("()"));
    }

    @Test
    void test2() {
        assertTrue(vp.isValid(""));
    }

    @Test
    void test3() {
        assertTrue(vp.isValid("(({{[[]]}}))"));
    }

    @Test
    void test4() {
        assertTrue(vp.isValid("(){}[]"));
    }

    @Test
    void test5() {
        assertTrue(vp.isValid("({{[[[([([[{}]])])]]]}})"));
    }

    @Test
    void test6() {
        assertFalse(vp.isValid("(}"));
    }

    @Test
    void test7() {
        assertFalse(vp.isValid("("));
    }

    @Test
    void test8() {
        assertFalse(vp.isValid("({][{}[)"));
    }

    @Test
    void test9() {
        assertFalse(vp.isValid("([))"));
    }

    @Test
    void test10() {
        assertFalse(vp.isValid(")"));
    }
}