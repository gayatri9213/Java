import java.util.Scanner;

public class SumOfDigit
{
    Scanner s=new Scanner(System.in);
    SumOfDigit()
    {
        int n,sum=0,digit;
        System.out.println("Enter Number:");
        n=s.nextInt();
        while(n>0)
        {
            digit=n%10;
            sum=sum+digit;
            n=n/10;
        }
        System.out.println("Sum of Digit:"+sum);
    }
    public static void main(String[] args)
    {
        SumOfDigit s1=new SumOfDigit();


    }
}