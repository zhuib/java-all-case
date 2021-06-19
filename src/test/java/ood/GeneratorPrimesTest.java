package ood;

import junit.framework.TestCase;

/**
 * Date: 2021/4/7 15:52
 */
public class GeneratorPrimesTest extends TestCase {

    public void testPrimes() {
        int[] nullArray = PrimeGenerator.GeneratePrimeNumbers(0);
        assertEquals(nullArray.length, 0);

        int[] minArray = PrimeGenerator.GeneratePrimeNumbers(2);
        assertEquals(minArray.length, 1);
        assertEquals(minArray[0], 2);

        int[] threeArray = PrimeGenerator.GeneratePrimeNumbers(3);
        assertEquals(threeArray.length, 2);
        assertEquals(threeArray[0], 2);
        assertEquals(threeArray[1], 3);

        int[] centArray = PrimeGenerator.GeneratePrimeNumbers(100);
        assertEquals(centArray.length, 25);
        assertEquals(centArray[24], 97);
    }

}
