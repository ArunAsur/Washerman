/**
 * This class will be used to represent integers as a list of binary regions.
 * For example, 1110011 will be stored as a list of two binary regions: one of
 * length 2 beginning at bit 0, and another of length 3 beginning at bit 4.  If
 * a binary number can be stored in this format, then the process of
 * multiplication, division, etc. can be shortened by performing algebra using
 * the binary regions.
 */
public class BinaryRegion
{
    private int regionStart = -1;
    private int regionLength = 0;
  
    public BinaryRegion()
    {

    }

    public void setStart(int newStart)
    {
        regionStart = newStart;
    }

    public int getStart()
    {
        return regionStart;
    }

    public void setLength(int newLength)
    {
        regionLength = newLength;
    }

    public int getLength()
    {
        return regionLength;
    }
}
