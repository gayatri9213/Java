import java.util.Scanner;

public class LinearSearch
{
    Scanner s = new Scanner(System.in);
    void search()
    {
        int n, key;
        System.out.println("Enter size of array:");
        n = s.nextInt();
        int ch[] = new int[n];
        System.out.println("Enter Array Element:");
        for (int i = 0; i < n; i++)
        {
            ch[i] = s.nextInt();
        }
        System.out.println("Enter Number to find:");
        key = s.nextInt();

        for (int i = 0; i < n; i++)
        {
            if (ch[i] == key)
            {
                System.out.println("Number is found at "+i+" location");
            }
        }
        System.out.println("Number is not found");
    }
    public static void main(String[] args)
    {
        LinearSearch l=new LinearSearch();
        l.search();
    }
}
