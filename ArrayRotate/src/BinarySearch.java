import java.util.*;
class BinarySearch
{
    public static void main(String args[])
    {
        Scanner s=new Scanner(System.in);

        System.out.println("Enter size of array");
        int n=s.nextInt();

        int numArray[] = new int[n];
        System.out.println("Enter array Element");
        for(int i=0;i<n;i++)
        {
            numArray[i]=s.nextInt();
        }

        System.out.println("The input array: " + Arrays.toString(numArray));

        System.out.println("Enter key value");
        int key=s.nextInt();

        int first = 0;
        int last=numArray.length-1;
        int mid = (first + last)/2;

        while( first <= last )
        {
            if ( numArray[mid] < key )
            {
                first = mid + 1;
            }
            else if ( numArray[mid] == key )
            {
                System.out.println("Element is found at index: " + mid);
                break;
            }
            else
            {
                last = mid - 1;
            }
            mid = (first + last)/2;
        }
        if ( first > last )
        {
            System.out.println("Element is not found!");
        }
    }
}