import java.util.*;

public class SetDemo
{
    public static void main(String[] args)
    {
        Set l1=new HashSet();
        l1.add("Gayatri");
        l1.add("Gaurav");
        l1.add("Prasad");
        l1.add("Pranali");
        l1.add("Gaurav");
        System.out.println(l1.size());
        Iterator iterator=l1.iterator();
        while(iterator.hasNext())
        {
            System.out.println("Elements :"+iterator.next());
        }
        System.out.println(l1.isEmpty());
        System.out.println(l1.contains("Prasad"));
        System.out.println(l1.hashCode());
        System.out.println();






    }
}
