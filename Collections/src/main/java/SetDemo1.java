import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SetDemo1
{
    public String name;
    public SetDemo1(String name)
    {
        this.name=name;

    }

    @Override
    public int hashCode()
    {
        return 1;
    }

    @Override
    public boolean equals(final Object obj)
    {
        SetDemo1 sd=(SetDemo1) obj;
        return (this.name.equalsIgnoreCase(sd.name));

    }

    public static void main(String[] args)
    {
        Set s=new HashSet();
        SetDemo1 s1=new SetDemo1("Gayatri");
        SetDemo1 s2=new SetDemo1("Gayatri");
        SetDemo1 s3=new SetDemo1("Aarya");
        s.add(s1);
        s.add(s2);
        s.add(s3);
        System.out.println(s.size());
        Iterator iterator=s.iterator();


        while(iterator.hasNext())
        {

            System.out.println("Elements :"+iterator.next());

        }
    }
}
