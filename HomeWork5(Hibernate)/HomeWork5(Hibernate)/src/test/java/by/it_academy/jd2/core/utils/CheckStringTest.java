package by.it_academy.jd2.core.utils;


import net.bytebuddy.pool.TypePool;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

class CheckStringTest {

    @Test
    void classDefinition() {
        CheckString flights = new CheckString();
        Assert.assertTrue(flights instanceof CheckString);
    }
    //return string == null || string.isEmpty() || string.isBlank();
    @Test
    void isNullOrEmptyOrBlankForNull() {
        Assert.assertTrue(CheckString.isNullOrEmptyOrBlank(null));

    }
    @Test
    void isNullOrEmptyOrBlankForEmpty() {
        Assert.assertTrue(CheckString.isNullOrEmptyOrBlank("" ));

    }
    @Test
    void isNullOrEmptyOrBlankForBlank() {
        Assert.assertTrue(CheckString.isNullOrEmptyOrBlank("   "));

    }
    @Test
    void isNullOrEmptyOrBlankForNullFalse() {
        Assert.assertTrue(!CheckString.isNullOrEmptyOrBlank("null"));

    }
    @Test
    void isNullOrEmptyOrBlankForEmptyFalse() {
        Assert.assertTrue(!CheckString.isNullOrEmptyOrBlank("a" ));

    }
    @Test
    void isNullOrEmptyOrBlankForBlankFalse() {
        Assert.assertTrue(!CheckString.isNullOrEmptyOrBlank("  a "));

    }
}