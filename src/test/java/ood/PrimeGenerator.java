package ood;

/**
 * Date: 2021/4/7 15:51
 */
public class PrimeGenerator
{
    private static Boolean[] crossedOut;
    private static int[] result;
    public static int[] GeneratePrimeNumbers(int maxValue)
    {
        if (maxValue < 2)
            return new int[0];
        else
        {
            UncrossIntegersUpTo(maxValue);
            CrossOutMultiples();
            PutUncrossedIntegersIntoResult();
            return result;
        }
    }
    private static void UncrossIntegersUpTo(int maxValue)
    {
        crossedOut = new Boolean[maxValue + 1];
        for (int i = 2; i < crossedOut.length; i++)
            crossedOut[i] = false;
    }
    private static void PutUncrossedIntegersIntoResult()
    {
        result = new int[NumberOfUncrossedIntegers()];
        for (int j = 0, i = 2; i < crossedOut.length; i++)
        {
            if (NotCrossed(i))
                result[j++] = i;
        }
    }
    private static int NumberOfUncrossedIntegers()
    {
        int count = 0;
        for (int i = 2; i < crossedOut.length; i++)
        {
            if (NotCrossed(i))
                count++; // bump count.
        }
        return count;
    }
    private static void CrossOutMultiples()
    {
        int limit = DetermineIterationLimit();
        for (int i = 2; i <= limit; i++)
        {
            if (NotCrossed(i))
                CrossOutputMultiplesOf(i);
        }
    }
    private static int DetermineIterationLimit()
    {
        // Every multiple in the array has a prime factor that
        // is less than or equal to the root of the array size,
        // so we don't have to cross off multiples of numbers
        // larger than that root.
        double iterationLimit = Math.sqrt(crossedOut.length);
        return (int)iterationLimit;
    }
    private static void CrossOutputMultiplesOf(int i)
    {
        for (int multiple = 2 * i;
             multiple < crossedOut.length;
             multiple += i)
            crossedOut[multiple] = true;
    }
    private static Boolean NotCrossed(int i)
    {
        return crossedOut[i] == false;
    }
}
