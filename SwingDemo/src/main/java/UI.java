import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UI implements ActionListener
{
    JButton send,reset;
    JTextField tf;
    JFrame frame;
    public UI()
    {
        frame = new JFrame("Frame");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);


        JMenuBar mb = new JMenuBar();
        JMenu m1 = new JMenu("FILE");
        JMenu m2 = new JMenu("Help");
        mb.add(m1);
        mb.add(m2);
        JMenuItem m11 = new JMenuItem("Open");
        JMenuItem m22 = new JMenuItem("Save as");
        m1.add(m11);
        m1.add(m22);

        JPanel panel = new JPanel();
        JLabel label = new JLabel("Enter Text");
        tf = new JTextField(10);
        send = new JButton("Send");
        reset = new JButton("Reset");
        panel.add(label);
        panel.add(tf);
        send.addActionListener(this);
        reset.addActionListener(this);
        panel.add(send);
        panel.add(reset);

        JTextArea ta = new JTextArea();

        frame.getContentPane().add(BorderLayout.SOUTH, panel);
        frame.getContentPane().add(BorderLayout.NORTH, mb);
        frame.getContentPane().add(BorderLayout.CENTER, ta);
        frame.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == send)
        {
            JOptionPane.showMessageDialog(frame,"Send Successfully");
        }
        if (e.getSource() == reset)
        {
            tf.setText(" ");

        }
    }
    public static void main(String args[])
    {
        UI obj=new UI();
    }



}
