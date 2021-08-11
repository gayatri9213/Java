import java.util.*;

class Method//Method Overloading
{
	public void add(int a,int b)
	{
		System.out.println("Addition is:"+(a+b));
	}
	public void add(int a,int b,int c)
	{
		System.out.println("Addition is:"+(a+b+c));
	}
	public void add(double a,double b)
	{
		System.out.println("Addition is:"+(a+b));
	}
}

class Constructor//Constructor Overloading
{
	public Constructor(int r)
	{
		System.out.println("Area of circle is:"+(3.14*r*r));
	}
	public Constructor(double l,double b)
	{
		System.out.println("Area of Rectangle is:"+(l*b));
	}
	public Constructor(String str)
	{
		System.out.println("String is:"+str);
	}

}



public class MethodOverloading
{
		public static void main(String args[])
		{

			Method m=new Method();
			m.add(5,2);
			m.add(10,20,10);
			m.add(0.5,0.5);

			Constructor c=new Constructor(10);
			Constructor c1=new Constructor(10,10);
			Constructor c2=new Constructor("Gayatri Sonar");

		}
}