public class Prime
{
	public static void main(String args[])
	{
		int n=11,flag=0,i;

		i=2;
		while(i<n)
		{
			if(n%i==0)
			{
				flag=1;
			}
			i++;
		}

		if(flag==0)
		{
			System.out.println("Number "+n+" is Prime");
		}
		else
		{
			System.out.println("Number " +n +" is not prime");
		}
	}
}









//Using For Loop
		/*for(i=2;i<n-1;i++)
		{
			if(n%i==0)
			{
				flag=1;
			}

		}*/
		//Using While Loop