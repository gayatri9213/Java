import java.io.*;
import java.util.*;
public class FileDemo
{
    public static void main(String[] args) throws IOException,ClassNotFoundException
    {
        File file=new File("C:\\Users\\user\\Desktop\\Training Link.txt");
        File newfile=new File("C:\\Users\\user\\Desktop\\Sample.txt");
        System.out.println(file.getName());
        System.out.println(file.isFile());
        System.out.println(file.getAbsolutePath());
        System.out.println(file.getCanonicalPath());
        System.out.println(file.length());
        System.out.println(file.canExecute());
        System.out.println(file.canRead());
        System.out.println(file.canWrite());
        System.out.println(file.toURI());
        newfile.createNewFile();
        FileWriter f=new FileWriter(newfile);
        f.write("Welcome");
        f.close();

        Scanner sc=new Scanner(newfile);
        while(sc.hasNextLine())
        {
            String line=sc.nextLine();
            System.out.println(line);
        }

        FileOutputStream fos = new FileOutputStream("C:\\Users\\user\\Desktop\\Sample.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeInt(12345);
        oos.writeObject("Today");
        oos.writeObject(new Date());


        FileInputStream fis = new FileInputStream("C:\\Users\\user\\Desktop\\Sample.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);
        int i = ois.readInt();
        String today = (String) ois.readObject();
        Date date = (Date) ois.readObject();
        String obj=(String) ois.readObject();
        System.out.println(i +today +date);
        oos.close();

    }
}
