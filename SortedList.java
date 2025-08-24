/**
 *
 */
public class SortedList<T>
{
    private T[] listElements = null;

    public SortedList()
    {
        listElements = new T[256];
    }

    private T[] resizeList(T[] toResize)
    {
        T[] newListElements = new T[toResize.length * 2];
        for(int k = 0; k < toResize.length; k++)
        {
            newListElements[k] = toResize[k];
        }
        return newListElements;
    }

    public void add(T toAdd)
    {
        if(listLength == listElements.length)
        {
            listElements = resizeList();
        }
        listElements[listLength] = toAdd;
    }

    public T get(int index)
    {
        return listElements[index];
    }

    public void set(T newItem, int index)
    {
        listElements[index] = newItem;
    }

    public int searchList(T toFind)
    {
        return binarySearch(listElements, toFind, 0, listElements.length);
    }

    private int binarySearch(T[] toSearch, T toFind, int start, int end)
    {
        int midPt = (start + end) / 2;
        int compare = toSearch[midPt].compareTo(toFind);
        if(toSearch[midPt].compareTo(toFind) < 0)
        {
            return binarySearch(toSearch, toFind, start, midPt);
        }
        else if(toSearch[midPt].compareTo(toFind) > 0)
        {
            return binarySearch(toSearch, toFind, midPt, end);
        }
        return midPt;
    }
}
