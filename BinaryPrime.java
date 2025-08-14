/**
 * 
 */
public class BinaryPrime
{
    private int primeValue = -1;
    private List<BinaryRegion> regionsList = null;
    private List<BinaryRegion> reciprocalList = null;

    public BinaryPrime()
    {
        regionsList = new LinkedList<BinaryRegion>();
        reciprocalList = new LinkedList<BinaryRegion>();
    }

    public BinaryPrime(int newValue)
    {
        setValue(newValue);
    }

    public void setValue(int newValue)
    {
        primeValue = newValue;
        regionsList = BinaryUtils.getBinaryRegionList(newValue);
        reciprocalList = BinaryUtils.getReciprocalRegionList(newValue);
    }

    public int getValue()
    {
        int totalValue = 0;
        Iterator<BinaryRegion> regionIter = regionsList.iterator();
        while(regionIter.hasNext())
        {
            BinaryRegion nextRegion = regionIter.next();
            totalValue += Math.pow(2, nextRegion.getStart()) *
                (Math.pow(2, nextRegion.getLength()) - 1);
        }
        return totalValue;
    }

    private void evaluate()
    {
        primeValue = getValue();
    }

    public PrimeNumber add(PrimeNumber otherPrime)
    {
        return new PrimeNumber(primeValue + otherPrime.getValue());
    }

    public PrimeNumber subtract(PrimeNumber otherPrime)
    {
        return new PrimeNumber(primeValue + otherPrime.getValue());
    }

    /**
     * A integer can be represented as a sequence of binary regions,
     * where the regions are represented as a series of "1" bits.  The
     * formula for the sum of a geometric series can then be used to
     * represent the binary regions:
     * S = a + ar + ar^2 + ... + ar^n-1 + ar^n
     * S = a(1 - r^(n+1))/(1 - r)
     * Multiplying two binary regions would therefore involve using
     * algebra to find the product of the sums.
     */
    public PrimeNumber multiply(PrimeNumber otherPrime)
    {
        int totalSum = 0;
        Iterator<BinaryRegion> regionIter = regionsList.iterator();
        while(regionIter.hasNext())
        {
            BinaryRegion nextRegion = regionIter.next();
            Iterator<BinaryRegion> otherIter =
                otherPrime.regionsList.iterator();
            while(otherIter.hasNext())
            {
                BinaryRegion otherRegion = otherPrime.next();
                PrimeNumber product = new PrimeNumber(Math.pow(2,
                    nextRegion.getStart() + otherRegion.getStart() +
                    otherRegion.getStart() + otherRegion.getLength())
                    * (Math.pow(2, nextRegion.getStart() +
                    nextRegion.getLength()) - 1));
                PrimeNumber subtract = new PrimeNumber(Math.pow(2,
                    nextRegion.getStart() + otherRegion.getStart())
                    * (Math.pow(2, nextRegion.getStart() +
                    nextRegion.getLength()) - 1));
                PrimeNumber difference = product.subtract(subtract);
                totalSum += difference.getValue();
            }
        }
        return new PrimeNumber(totalSum);
    }

    /**
     * Similar to the multiply() function, except this time, the
     * binary regions of the product are multiplied by the binary
     * regions of the 
     */
    public PrimeNumber divide(PrimeNumber divisor)
    {
        int totalSum = 0;
        Iterator<BinaryRegion> regionIter = regionList.iterator();
        while(regionIter.hasNext())
        {
            BinaryRegion nextRegion = regionIter.next();
            Iterator<BinaryRegion> otherIter = otherPrime.iterator();
            while(otherIter.hasNext())
            {
                BinaryRegion otherRegion = otherPrime.next();
                PrimeNumber product = new PrimeNumber(Math.pow(2,
                    nextRegion.getStart() + otherRegion.getStart() +
                    otherRegion.getLength()) * (Math.pow(2,
                    nextRegion.getLength()) - 1));
                PrimeNumber subtract = new PrimeNumber(Math.pow(2,
                    nextRegion.getLength()) - 1);
                PrimeNumber difference = product.subtract(subtract);
                totalSum += difference.getValue();
            }
        }
        return new PrimeNumber(totalSum);
    }
}
