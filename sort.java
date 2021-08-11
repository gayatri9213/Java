package com.company;
import java.util.Scanner;
public class sort
{
    public static void main(String args[])
    {
        int count;
        String temp;
        Scanner s=new Scanner(System.in);
        System.out.print("Enter Number of String Count:");
        count=s.nextInt();

        String str[] = new String[count];
        System.out.println("Enter the Strings one by one:");
        for(int i = 0; i < count; i++)
        {
            str[i] = s.nextLine();
        }

        for(int i=0;i<count;i++)
        {
            for (int j=i+1;j<count;j++)
            {
                if(str[i].compareTo(str[j])>0)
                {
                    temp=str[i];
                    str[i]=str[j];
                    str[j]=temp;
                }
            }
        }
        System.out.print("Strings in Sorted Order:");
        for (int i = 0; i <= count - 1; i++)
        {
            System.out.print(str[i] + ",");
        }

    }

}


