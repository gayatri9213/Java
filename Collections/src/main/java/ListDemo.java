import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class ListDemo
{
    public static void main(String[] args)
    {
        List l1=new ArrayList();
        l1.add("Gayatri");
        l1.add("Gaurav");
        l1.add("Prasad");
        l1.add("Pranali");
        l1.add("Pratik");
        System.out.println(l1.size());
        System.out.println("*******************For Loop************************");
        for(int i=0;i< l1.size();i++)
        {
            System.out.println(l1.get(i));
        }
        System.out.println("*********************For Each Loop**********************");
        for (Object name:l1)
        {
            System.out.println((String)name);
        }
        System.out.println("**********************Lambda For Loop*********************");
        l1.forEach(name -> System.out.println(name));

        System.out.println("*******************Methods************************");

        System.out.println(l1.isEmpty());
        System.out.println(l1.contains("" +
                "Pranali"));
        System.out.println(l1.indexOf("Prasad"));
        System.out.println(l1.lastIndexOf("Pratik"));
        System.out.println(l1.get(3));
        String[] array = (String[]) l1.toArray(new String[l1.size()]);
        System.out.println("Printing Array: "+ Arrays.toString(array));

        l1.set(1,"Aarya");
        System.out.println("Printing Array: "+ l1);

        l1.add(5,"Gaurav");
        System.out.println("Printing Array: "+ l1);

        Collections.sort(l1);
        System.out.println("Sorting Array: "+ l1);
    }
}
