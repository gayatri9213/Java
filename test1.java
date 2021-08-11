import java.util.*;
public class test1
{
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);

		int age;
		String name,phone;


		System.out.print("Enter Name:");
		name=sc.next();
		System.out.print("Enter Age:");
		age=sc.nextInt();
		System.out.print("Enter Phone:");
		phone=sc.nextLine();


		System.out.println("Your Age:"+age);
		System.out.println("Name is:"+name);
		System.out.println("Phone is:"+phone);

	}
}
/*abstract class test
{
	public abstract void calculate();
}
public class test1 extends test
{
	int m1,m2,m3;
	public test1(int a,int b,int c)
	{
		m1=a;
		m2=b;
		m3=c;
	}

	public void calculate()
	{
		System.out.println("Percentage is:"+(((m1+m2+m3)*100)/300));
	}







	public static void main(String args[])
	{
		test1 t1=new test1(50,70,60);
		t1.calculate();
	}
}*/