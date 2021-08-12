class B
{
    int data=40;
    private void msg()
    {
        System.out.println("Hello ");
    }
}

public class PrivateDemo{
    public static void main(String args[])
    {
        B obj=new B();
        System.out.println(obj.data);
        obj.msg();
    }
}