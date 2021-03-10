import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class App extends JFrame implements ActionListener {
       private static final long serialVersionUID = 1L;
   
   JPanel panel;
   JLabel user_label, password_label, message;
   JTextField userName, password;
   JButton submit, cancel, newButton;
   App() {
      // Username Label
      user_label = new JLabel();
      user_label.setText("User Name :");
      userName = new JTextField();
      // Password Label
      password_label = new JLabel();
      password_label.setText("Password :");
      password = new JPasswordField();
      // Submit
      submit = new JButton("SUBMIT");
      panel = new JPanel(new GridLayout(3, 1));
      panel.add(user_label);
      panel.add(userName);
      panel.add(password_label);
      panel.add(password);
      message = new JLabel();
      panel.add(message);
      panel.add(submit);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      // Adding the listeners to components..
      submit.addActionListener(this);
      add(panel, BorderLayout.CENTER);
      setTitle("Please Login Here !");
      setSize(450,350);
      setVisible(true);
   }
   public static void main(String[] args) {
      new App();
   }
   @Override
   public void actionPerformed(ActionEvent ae) {
      String userName2 =userName.getText();
      String password2 = password.getText();

      if (userName2.equals("admin") && password2.equals("0000")) {
         message.setText(" Hello " + userName2 + "");
         
      } else {
         message.setText(" Invalid user.. ");
      }

   }
}