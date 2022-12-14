import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class RequirementsTest {
    @Test
    public void fromFloat() {
        var mn1 = new MixedNumber(0.25f);
        assertEquals("1/4", mn1.toString());
    }

    @Test
    public void fromLong() {
        var mn2 = new MixedNumber(34l, 6l);
        assertEquals("5 2/3", mn2.toString());
    }

    @Test
    public void fromDoubles() {
        var mn3 = new MixedNumber(11d, 18d, 10d);
        var f = new Fraction(64, 5);
        assertEquals("12 4/5", new MixedNumber(f).toString());
        assertEquals("12 4/5", mn3.toString());
    }

    /**
     * 1. mn1 = new MixedNumber<Float>(0.25f) results into whole = 0, numerator = 1,
     * denominator = 4
     * 2. mn2 = new MixedNumber<Long>(34l, 6l) results into whole = 5, numerator =
     * 2, denominator = 3
     * 3. mn3 = new MixedNumber<Double>(11d, 18d, 10d) results into whole = 12,
     * numerator = 4, denominator = 5
     * Operations Example
     * mn1 + mn2 = MixedNumber(whole = 5, numerator = 11, denominator = 12)
     * mn3 - mn2 = MixedNumber(whole = 7, numerator = 2, denominator = 15)
     * mn3 * mn1 = MixedNumber(whole = 3, numerator = 1, denominator = 5)
     * mn2 / mn3 = MixedNumber(whole = 0, numerator = 85, denominator = 192)
     */
    @Test
    public void canvas() {
        var mn1 = new MixedNumber(0.25f);
        var mn2 = new MixedNumber(34l, 6l);
        var mn3 = new MixedNumber(11d, 18d, 10d);

        assertEquals("5 11/12", mn1.add(mn2).toString());
        assertEquals("7 2/15", mn3.subtract(mn2).toString());
        assertEquals("3 1/5", mn3.multiply(mn1).toString());
        assertEquals("85/192", mn2.divide(mn3).toString());
    }
}
