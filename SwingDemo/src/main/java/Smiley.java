import javax.swing.*;
import java.awt.*;
class Smiley extends JPanel
{
    //Driver function
    public static void main(String args[])
    {
        //Create a frame
        JFrame frame=new JFrame("Smiley");
        frame.setSize(500,500);
        frame.setBackground(Color.white);
        Smiley panel=new Smiley();
        frame.add(panel);
        //Set default close operation for the frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    //function to draw the shapes
    public void paint(Graphics g)
    {
        //Change color to yellow
        g.setColor(Color.yellow);
        //Draw and fill the face
        g.drawArc(100,100,250,250,0,360);
        g.fillArc(100,100,250,250,0,360);
        //Change color to black
        g.setColor(Color.black);
        //Draw the left eye
        g.drawArc(170,185,25,25,0,360);
        g.fillArc(170,185,25,25,0,360);
        //Draw the right eye
        g.drawArc(255,185,25,25,0,360);
        g.fillArc(255,185,25,25,0,360);
        //Draw the smile
        g.drawArc(150,215,150,100,0,-180);
    }
}