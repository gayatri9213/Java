import java.sql.*;
import java.util.Scanner;

public class DemoDB
{
    int id,age;
    String name;
    Scanner sc=new Scanner(System.in);
    PreparedStatement p;
    Connection con;
    public void connection()throws SQLException,ClassNotFoundException
    {
        Class.forName("com.mysql.cj.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/database", "root", "Gayatri@2000");
    }
    public void insert()throws Exception
    {
        System.out.print("Enter Id:");
        id=sc.nextInt();
        System.out.print("Enter Name :");
        name=sc.next();
        System.out.print("Enter Age:");
        age=sc.nextInt();
        PreparedStatement p =con.prepareStatement("insert into demo values(?,?,?)");
        p.setInt(1,id);
        p.setString(2,name);
        p.setInt(3,age);
        p.execute();
    }
    public void update()throws SQLException
    {
        System.out.println("Insert id to update record: ");
        id=sc.nextInt();
        System.out.println("Enter Name and Age to update");
        name=sc.next();
        age=sc.nextInt();
        p=con.prepareStatement("update demo set Name=?,Age=? where Id=?");
        p.setString(1,name);
        p.setInt(2,age);
        p.setInt(3,id);
        p.executeUpdate();
    }
    public void delete() throws SQLException
    {
        System.out.println("Insert id to delete record: ");
        id=sc.nextInt();
        p=con.prepareStatement("delete from demo where Id=?");
        p.setInt(1,id);
        p.execute();
    }
    public void select()throws SQLException
    {
        Statement st=con.createStatement();
        ResultSet rs=st.executeQuery("SELECT * FROM demo;");

        while(rs.next())
        {
            System.out.println(rs.getInt(1)+ " " +rs.getString(2)+ " "+rs.getInt(3));

        }
    }
    public static void main(String[] args)
    {
        int ch;
        Scanner sc=new Scanner(System.in);
        DemoDB d=new DemoDB();
        try
        {
            do
            {
                d.connection();
                System.out.println("************Database Operations**********");
                System.out.println("1.Insert/n2.Update/n3.Delete/n4.Select/n5.Exit");
                System.out.println("Enter Your Choice");
                ch=sc.nextInt();
                switch(ch)
                {
                    case 1:
                        d.insert();
                    break;
                    case 2:
                        d.update();
                    break;
                    case 3:
                        d.delete();
                    break;
                    case 4:
                        d.select();
                    break;
                }
            }while(ch!=5);
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }

}
