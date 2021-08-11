public class Factorial
{
		public static void main(String args[])
		{
			int fact=1,n=5;
			for(int i=2;i<=n;i++)
			{
				fact=fact*i;
			}
			System.out.println("The Factorial of "+n+" is "+fact);
		}
}
/*public class Factorial
{

    static int factorial(int n)
    {
        if (n == 0)
        {
        	return 1;
		}
		else
		{
    	    return n*factorial(n-1);
		}
    }


    public static void main(String[] args)
    {
        int num = 8;
        System.out.println("Factorial of "+ num + " is " + factorial(num));
    }
}*/