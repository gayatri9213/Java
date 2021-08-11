import java.util.Scanner;

public class MyProgram
{
    public static  void main(String a[])
    {
        char G[][]={{' ','|',' ','|',' '},{'-','+','-','+','-'},
                    {' ','|',' ','|',' '},{'-','+','-','+','-'},
                    {' ','|',' ','|',' '}};
        printBoard(G);
        Scanner scan=new Scanner(System.in);
        System.out.println("Enter Position(1-9)");
        int pos=scan.nextInt();
        System.out.println(pos);
        changePiece(G,pos,"player");
    }
    public static void printBoard(char[] [] G)
    {
        for(char[] row: G)
        {
            for (char c:row)
            {
                System.out.print(c);
            }
            System.out.println();
        }
    }


    public static void changePiece(char[] [] G,int pos, String user)
    {
        char symbol=' ';
        if(user.equals("player"))
        {
            symbol='X';
        }
        else if(user.equals("CPU"))
        {
            symbol='O';
        }
        switch (pos)
        {
            case 1:
                G[0][0]=symbol;
            break;
            case 2:
                G[0][2]=symbol;
            break;
            case 3:
                G[0][4]=symbol;
            break;
            case 4:
                G[2][0]=symbol;
            break;
            case 5:
                G[2][2]=symbol;
            break;
            case 6:
                G[2][4]=symbol;
            break;
            case 7:
                G[4][0]=symbol;
            break;
            case 8:
                G[4][2]=symbol;
            break;
            case 9:
                G[4][4]=symbol;
            break;
        }
    }


}
