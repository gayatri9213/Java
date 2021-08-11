package com.company;
import java.util.Scanner;
public class AddTwoNumber
{
    public static void main(String[] args)
    {
        int no1,no2;
        Scanner scan=new Scanner(System.in);
        System.out.print("Enter First Number:");
        no1=scan.nextInt();
        System.out.print("Enter Second Number:");
        no2=scan.nextInt();

        System.out.println("Addition is:"+(no1+no2));

    }
}

