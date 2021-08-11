import java.util.*;


abstract class Demo
{
	int order,coffee_count=0,muffin_count=0,shake_count=0,coffee=10, muffin=10, shake=10,Total;
	public abstract void order();
	public abstract void price();
	public abstract void report();
	public void choice4()
	{
		System.out.println("25 Muffins Baked");
	}
}
class CafeOrder extends Demo implements Demo1
{

	int c1=0, m1=0, s1=0;
	Scanner s=new Scanner(System.in);

	public void order()
	{
		do
		{
			System.out.println("*****************Choose your order*****************");
			System.out.println("\n1. Press 1 to Coffee\n2. Press 2 to Muffin\n3. Press 3 to Shake\n4. Press 4 to View Order\n5.Exit");
			System.out.println("Enter Your Choice");
			order=s.nextInt();

			switch(order)
			{
				case 1:
						System.out.println("How many coffee you want to buy :");
						c1=s.nextInt();
						coffee_count=coffee_count+c1;
				break;
				case 2:
						System.out.println("How many muffin you want to buy :");
						m1=s.nextInt();
						muffin_count=muffin_count+m1;
				break;
				case 3:
						System.out.println("How many Shake you want to buy :");
						s1=s.nextInt();
						shake_count=shake_count+s1;
				break;
				case 4:
						System.out.println("-------------ORDER--------------");

						System.out.println("Coffee  "  +c1+ "    "   +(c1*coffee));
						System.out.println("Muffin  "  +m1+ "    "   +(m1*muffin));
						System.out.println("Shake   "  +s1+ "    "   +(s1*shake));

						System.out.println("______________________________");

						Total = (c1*coffee)+ (m1*muffin) + (s1*shake);
						System.out.println("Total        " +Total);

						System.out.print("Proceed Amount : ");
						int amt = s.nextInt();

						int ramt = amt - Total;
						System.out.println("Please return amount : " +ramt);
				break;
			}
		}while(order<5);
	}

	public void price()
	{
		do
		{
			System.out.println("***************Change your price***********************");
			System.out.println("\n1. Coffee\n2. Muffin\n3. Shake\n4. Exit");
			System.out.println("Enter Your Choice");
			order=s.nextInt();

			switch(order)
			{
				case 1:
					System.out.println("Please enter new price for Coffee :");
					coffee=s.nextInt();
					System.out.println("Updated Coffee Price is "+coffee+" Rs.");
				break;

				case 2:
					System.out.println("Please enter new price for Muffin :");
					muffin=s.nextInt();
					System.out.println("Updated Muffin Price is "+muffin+" Rs.");
				break;

				case 3:
					System.out.println("Please enter new price for Shake:");
					shake=s.nextInt();
					System.out.println("Updated Shake Price is "+shake+" Rs.");
				break;

			}
		}while(order!=4);
	}

	public void report()
	{
		System.out.println("****************************************************");
								System.out.println("\t\tWELCOME TO CAFE");
								System.out.println("****************************************************");



								System.out.println("Coffee  "  +coffee_count+ "    "   +(coffee*coffee_count));


								System.out.println("Muffin  "  +muffin_count+ "    "   +(muffin*muffin_count));


								System.out.println("Shake   "  +shake_count+ "    "   +(shake*shake_count));

								System.out.println("______________________________");

								Total = (coffee*coffee_count) + (muffin*muffin_count)+(shake*shake_count);
								System.out.println("Total        " +Total);

								System.out.println("Total muffin's Baked is : 50");

								int muff = 50 - muffin_count;
						System.out.println("Muffin left : " +muff);
	}

}


public class Cafe2 extends CafeOrder
{
		public static void main(String args[])
		{
			int ch;

			System.out.println("****************************************************");
			System.out.println("\t\tWELCOME TO CAFE");
			System.out.println("****************************************************");

			Scanner s=new Scanner(System.in);
			CafeOrder obj=new CafeOrder();
			do
			{
				System.out.println("************************MENU***************************");
				System.out.println("\n1. Press 1 to place order\n2. Press 2 to change price\n3. Press 3 view report\n4. press 4 to bake Muffins\n5. Exit");
				System.out.println("Enter Your Choice");
				ch=s.nextInt();

				switch(ch)
				{
					case 1://order

						obj.order();

					break;
					case 2://price
						obj.price();
					break;
					case 3://report
						obj.report();
					break;
					case 4://muffins
						obj.choice4();
					break;
				}


			}while(ch!=5);
		}
}