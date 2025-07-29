/**
 * 
 */
public class BinaryUtils
{ 
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
}
