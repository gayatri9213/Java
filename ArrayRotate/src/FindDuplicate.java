import java.util.Scanner;
public class FindDuplicate
{
    Scanner s=new Scanner(System.in);
    void duplicate()
    {
        int n;

        System.out.println("Enter count of array :");
        n=s.nextInt();
        int ch[]=new int[n];
        System.out.println("Enter Array element");
        for(int i=0;i<n;i++)
        {
            ch[i]=s.nextInt();
        }
        System.out.println("Duplicate Element");
        for(int i=0;i<n;i++)
        {
            for (int j=i+1;j<n;j++)
            {
                if(ch[i] == ch[j])
                {
                    System.out.println(ch[j]);
                }
            }
        }
    }

    public static void main(String[] args)
    {
        FindDuplicate r=new FindDuplicate();
        r.duplicate();

    }
}
