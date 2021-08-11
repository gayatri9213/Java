interface MyMath
{
	void add(int a, int b);
	void subtract(int a, int b);
}
class MyMathImpl implements MyMath
{
	public void add(int a, int b)
	{
		System.out.println("Add Result is: " + (a+b));
	}

	public void subtract(int a, int b)
	{
		System.out.println("Subtract Result is: " + (a-b));
	}
}
public class InterfaceExample1
{
	public static void main(String args[])
	{
		MyMath mymath = new MyMathImpl();
		mymath.add(5,2);
		mymath.subtract(5,2);
	}
}
