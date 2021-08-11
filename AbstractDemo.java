abstract class Demo
{
	abstract void calculate();
}

class Demo1 extends Demo
{
	void calculate()
	{
		System.out.println("Table of 5");
		for(int i=1; i <= 10; i++)
		{
		System.out.println(5+" * "+i+" = "+5*i);
		}
	}
}

class Demo2 extends Demo
{
	void calculate()
	{
		System.out.println("\nTable of 10");
		for(int i=1; i <= 10; i++)
		{
			System.out.println(10+" * "+i+" = "+10*i);
		}
	}
}

public class AbstractDemo
{
	public static void main(String args[])
	{
		Demo1 d1=new Demo1();
		d1.calculate();
		Demo2 d2=new Demo2();
		d2.calculate();
	}
}