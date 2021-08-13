import java.util.Scanner;

public class ReverseNumber
{
    Scanner s=new Scanner(System.in);
    ReverseNumber()
    {
        int n,reverse=0,remainder;
        System.out.println("Enter Number:");
        n=s.nextInt();
        while(n>0)
        {
            remainder=n%10;
            reverse=reverse*10+remainder;
            n=n/10;
        }
        System.out.println("Reverse of Number:"+reverse);
    }
    public static void main(String[] args)
    {
        ReverseNumber r1=new ReverseNumber();


    }
}