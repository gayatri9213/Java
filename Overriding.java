class Method
{
	public void show(int a,int b)
	{
		System.out.println("Addition is:"+(a+b));
	}

}
class Method1 extends Method
{
	public void show(int a,int b)
	{
		System.out.println("Substraction is:"+(a-b));
	}

}


public class Overriding
{
	public static void main(String args[])
	{
		Method1 obj=new Method1();
		obj.show(30,20);

	}
}