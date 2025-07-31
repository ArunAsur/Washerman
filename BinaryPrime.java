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
            totalValue += Math.pow(2, nextRegion.getStart() + 1) *
                (Math.pow(2, nextRegion.getLength() + 1) - 1);
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

    public PrimeNumber multiply(PrimeNumber otherPrime)
    {
          Iterator<Binary
    }

    public PrimeNumber divide(PrimeNumber divisor)
    {

    }
}
