import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Demo extends JFrame implements ActionListener
{
    JLabel l1, l2, l3, l4;
    JTextField tf1, tf2, tf3;
    JButton btn1, btn2;
    Frame frame;
    Demo()
    {

        setSize(700, 700);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Registration Form in Java");
        l1 = new JLabel("Registration Form :");
        l1.setForeground(Color.blue);
        l1.setHorizontalAlignment(SwingConstants.CENTER);
        l1.setFont(new Font("Serif", Font.BOLD, 20));
        l2 = new JLabel("Name:");
        l3 = new JLabel("Email-ID:");
        l4 = new JLabel("Phone No:");

        tf1 = new JTextField();
        tf2 = new JTextField();
        tf3 = new JTextField();

        btn1 = new JButton("Submit");
        btn2 = new JButton("Clear");

        l1.setBounds(100, 30, 400, 30);//title
        l2.setBounds(80, 70, 200, 30);
        l3.setBounds(80, 110, 200, 30);
        l4.setBounds(80, 150, 200, 30);

        tf1.setBounds(300, 70, 200, 30);
        tf2.setBounds(300, 110, 200, 30);
        tf3.setBounds(300, 150, 200, 30);

        btn1.setBounds(150, 200, 100, 30);
        btn2.setBounds(300, 200, 100, 30);
        add(l1);
        add(l2);
        add(tf1);
        add(l3);
        add(tf2);
        add(l4);
        add(tf3);
        btn1.addActionListener(this);
        btn2.addActionListener(this);
        add(btn1);
        add(btn2);


        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == btn1)
        {
            String name=tf1.getText();
            String email=tf2.getText();
            String phone=tf3.getText();

            try
            {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/database", "root", "Gayatri@2000");
                PreparedStatement p =con.prepareStatement("insert into form values(?,?,?)");
                p.setString(1,phone);
                p.setString(2,name);
                p.setString(3,email);

                p.execute();
            }
            catch (Exception e1)
            {
                e1.printStackTrace();
            }
            finally
            {
                JOptionPane.showMessageDialog(frame,"Submited Successfully");
            }

        }
        if (e.getSource() == btn2)
        {
           tf1.setText(" ");
           tf2.setText(" ");
           tf3.setText(" ");
        }

    }

    public static void main(String[] args)
    {
        Demo d=new Demo();
    }


}