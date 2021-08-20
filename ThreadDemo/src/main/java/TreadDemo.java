public class TreadDemo extends Thread
{
    public static void main(String[] args)
    {
        new Thread(new Runnable()
        {
           public void run()
           {
               System.out.println("Hello");
           }
        }).start();

    }
}







/*public class TreadDemo extends Thread
{
    String name;
    public TreadDemo(String name)
    {
        this.name=name;
    }
    public void run()
    {
        for (int i=1;i<3;i++)
        {
            System.out.println("Name :"+name);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args)
    {
        TreadDemo t1=new TreadDemo("Gaurav");
        TreadDemo t2=new TreadDemo("Gayatri");
        t2.setPriority(MAX_PRIORITY);
        t2.getState();
        t1.start();
        t2.start();

    }
}
*/