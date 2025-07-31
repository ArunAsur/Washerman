/**
 * A utility class for performing binary operations, such as
 * decimal to binary conversion.
 */
public class BinaryUtils
{
    /**
     * Helper method for converting a numeric string into a boolean array
     * representing a binary number.
     */
    private static boolean[] binaryConvert(String stringToConvert)
    {
        String[] dividends = {"0", "0", "1", "1", "2", "2", "3", "3", "4", "4",
                              "5", "5", "6", "6", "7", "7", "8", "8", "9", "9"};
        String[] remainders = {0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1,
                               0, 1, 0, 1};
        
        int stringLength = stringToConvert.length();
        int bitLength = stringLength / 3 * 10;
        if(stringLength % 3 == 1)
        {
            bitLength += 4;
        }
        else if(stringLength % 3 == 2)
        {
            bitLength += 7;
        }
        boolean[] toReturn = new boolean[bitLength];
        int booleanIndex = 0;
        while(!stringToConvert.match("^0+$"))
        {
            String newString = "";
            int borrow = 0;
            for(int k = 0; k < stringToConvert.length(); k++)
            {
                int digit = (int)stringToConvert.charAt(k) - 48;
                int quotient = digit + 10 * borrow;
                String dividend = dividends[quotient];
                newString += dividend;
                int remainder = remainders[quotient];
                borrow = remainder;
            }
            toReturn[booleanIndex] = (boolean)borrow;
            booleanIndex++;
            stringToConvert = newString;
        }
        return toReturn;
    }

    public static List<BinaryRegion>
            getBinaryRegionList(String numToConvert)
    {
        List<BinaryRegion> toReturn = new LinkedList<BinaryRegion>();
        boolean[] binaryArray = binaryConvert(numToConvert);
        int booleanIndex = 0;
        while(booleanIndex < binaryArray.length)
        {
            if(binaryArray[booleanIndex])
            {
                int regionLength = 0;
                for(int k = booleanIndex; k < binaryArray.length; k++)
                {
                    if(binaryArray[booleanIndex])
                    {
                        regionLength++;
                    }
                    else
                    {
                        break;
                    }
                }
                BinaryRegion newRegion = new BinaryRegion();
                newRegion.setStart(booleanIndex);
                newRegion.setLength(regionLength);
                toReturn.add(newRegion);
                booleanIndex += regionLength;
            }
            else
            {
                booleanIndex++;
            }
        }
    }

    private static boolean[] resizeBooleanArray(boolean[] toResize)
    {
        boolean[] toReturn = new boolean[toResize.length * 2];
        for(int k = 0; k < toResize.length; k++)
        {
            toReturn[k] = toResize[k];
        }
        return toReturn;
    }
}
