package ww.q3;

import org.junit.Assert;
import org.junit.Test;

public class MinInRandomTest {
    private final MinInRandom underTest = new MinInRandom();

    @Test(expected = IllegalArgumentException.class)
    public void argumentIsTooBig() {
        underTest.printNthSmallestNum(600);
    }

    @Test(expected = IllegalArgumentException.class)
    public void argumentIsTooSmall() {
        underTest.printNthSmallestNum(0);
    }

    @Test
    public void checkOrder() {
        final double smallest = underTest.printNthSmallestNum(1);
        final double middle = underTest.printNthSmallestNum(2);
        final double bigger = underTest.printNthSmallestNum(3);

        Assert.assertTrue(smallest < middle);
        Assert.assertTrue(middle < bigger);
    }
}
