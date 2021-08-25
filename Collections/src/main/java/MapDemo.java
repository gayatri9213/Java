import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MapDemo
{
    public static void main(String args[])
    {
        Map<Integer,String> map=new HashMap<Integer,String>();
        map.put(100,"Amit");
        map.put(101,"Vijay");
        map.put(102,"Rahul");

        for(Map.Entry m:map.entrySet())
        {
            System.out.println(m.getKey()+" "+m.getValue());
        }
        System.out.println("************************************");
        Set<Integer> keys=map.keySet();
        keys.forEach(key -> {
            System.out.println("Key :"+key);
            System.out.println("Value :"+map.get(key));
        });
        System.out.println("************************************");
        for (Integer key : keys)
        {
            System.out.println("Key :"+key+"  Value :"+map.get(key));

        }
        System.out.println("************************************");
        map.remove(100, "Amit");
        System.out.println(map);


    }

}
