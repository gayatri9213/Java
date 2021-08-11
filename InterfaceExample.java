import java.util.*;
interface print
{
	void accept();
	void print();
}

class InterfaceExample implements print
{
	int rno;
	String name;
	Scanner s=new Scanner(System.in);
	public void accept()
	{
		System.out.print("Enter Roll No :");
		rno=s.nextInt();
		System.out.print("Enter Name :");
		name=s.next();


	}
	public void print()
	{
		System.out.println("Roll No:"+rno);
		System.out.println("Name:"+name);
	}

	public static void main(String args[])
	{

		InterfaceExample obj=new InterfaceExample();
		obj.accept();
		obj.print();
 	}
}
