import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

class inlupp2 extends JFrame implements ActionListener {


    JPanel panel;
    JLabel user_label, password_label, message;
    JTextArea display, display2;
    JTextField userName, password,tf1;
    JButton submit, Kundrelate,Administrativ ;
    inlupp2() {

        //nunu
        tf1 = new JTextField("tf11111");
        Kundrelate = new JButton("Kundrelate (Sök Titel)");
        Administrativ = new JButton("Administrativ");


        // Username Label
        user_label = new JLabel();
        user_label.setText("User Name :");
        userName = new JTextField("admin");

        // Password Label
        password_label = new JLabel();
        password_label.setText("Password :");
        password = new JPasswordField("0000");
        // Submit
        submit = new JButton("Login");
        panel = new JPanel(new GridLayout(5, 5));
        message = new JLabel();
        display = new JTextArea(" displa 1");
        display2 = new JTextArea(" Lista: Adminstrativ \n ");

        panel.add(user_label);
        panel.add(userName);
        panel.add(password_label);
        panel.add(password);
        panel.add(submit);

        panel.add(message);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Adding the listeners to components..
        submit.addActionListener(this);

        add(panel, BorderLayout.CENTER);

        setTitle("Please Login Here !");
        setSize(850,550);
        setVisible(true);
    }
    public static void main(String[] args) {

        new inlupp2();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String userName2 =userName.getText();
        String password2 = password.getText();

        if (userName2.equals("admin") && password2.equals("0000")) {
            message.setText(" Welcome " + userName2 + " ");

            submit.setVisible(false); userName.setVisible(false);
            password.setVisible(false); submit.setVisible(false);
            user_label.setVisible(false); password_label.setVisible(false);


            panel.add(Kundrelate);
            panel.add(tf1);
            panel.add(display);



            Kundrelate.addActionListener(ae1 -> {
                //***************
                String ans,ans2="";

                try {

                    Connection con =
      DriverManager.getConnection("jdbc:mysql://localhost/upp2DB", "root", "123456");
                    Statement stmt;
                    stmt = con.createStatement();

                    ResultSet rs =
                            stmt.executeQuery("select * FROM bok_tabel");

                    while ( rs.next() ) {

                        ans="Bok Titel: "+rs.getString(2)+"\n"
                        +"Författare: "+rs.getString(3)+"\n"
                        +"Antal sidor: "+rs.getString(4)+"\n"
                       + "klassifikation: "+rs.getString(5)+"\n"
                       +"Hylla: "+rs.getString(6)+"\n";


                        if( tf1.getText().equals( rs.getNString(2)  ) ){
                     display.setText("boken finns \n i hylla ["+rs.getNString(5)+"] \n" +ans);
                             }
                             else{
                                 display.setText(tf1.getText()+" boken finns inte!");

                             }
                        display2.setText(ans);

                    }

                    con.close();

                } catch (Exception e) {
                    //System.out.println(e);
                }


            });

            panel.add(Administrativ);
            panel.add(display2);



        } else {
            message.setText(" Invalid user.. ");
        }

    }
}