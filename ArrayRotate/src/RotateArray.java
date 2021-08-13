import java.util.Scanner;
public class RotateArray
{
    Scanner s=new Scanner(System.in);
    void calculate()
    {
        int n,temp;
        System.out.println("Enter size of array:");
        n=s.nextInt();
        int ch[]=new int[n];
        System.out.println("Enter Array Element:");
        for(int i=0;i<n;i++)
        {
            ch[i]=s.nextInt();
        }
        System.out.println("Elements After Rotation");
        for(int i=0;i<n;i++)
        {
            temp=ch[n-1];
            for(int j=n-2;j>=0;j--)
            {
                ch[j+1]=ch[j];
            }
            ch[0]=temp;
            for(int k=0;k<n;k++)
            {
                System.out.print("["+ch[k]+"]");
            }
            System.out.println();
        }

    }

    public static void main(String[] args)
    {
        RotateArray r=new RotateArray();
        r.calculate();
    }

}
