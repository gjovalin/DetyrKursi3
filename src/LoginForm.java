import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

//Projekt 3 ne Java 2
//Informatike viti III
//Data e marrjes së projektit : 8.1.2020
//Data e dorëzimit të projektit : 18.11.2020
//Ky program ben te mundur leximin nga nje databaze, afishimin,shtimin e rreshtave nga perdoruesi
//me ane te menyse perzgjedhese.
//Punuan Gjovalin Deda,Eljona Arrinaj,Klevisa Zekaj, Gledis Kapidani

public class LoginForm extends JFrame implements ActionListener{
 JLabel l1, l2, l3;
 JTextField tf1;
 JButton btn1;
 JPasswordField p1;
 LoginForm() {
  JFrame frame = new JFrame("Login Form");
  l1 = new JLabel("Identifikohuni");
  l1.setForeground(Color.blue);
  l1.setFont(new Font("Serif", Font.BOLD, 20));

  l2 = new JLabel("Username");
  l3 = new JLabel("Password");
  tf1 = new JTextField();
  p1 = new JPasswordField();
  btn1 = new JButton("Login");
  

  l1.setBounds(100, 30, 400, 30);
  l2.setBounds(80, 70, 200, 30);
  l3.setBounds(80, 110, 200, 30);
  tf1.setBounds(300, 70, 200, 30);
  p1.setBounds(300, 110, 200, 30);
  btn1.setBounds(150, 160, 100, 30);

  btn1.addActionListener(
          new ActionListener()
          {
              public void actionPerformed( ActionEvent event )
              {
            	  String uname = tf1.getText();
            	   String pass = p1.getText();
            	   if(uname.equals("admin") && pass.equals("admin"))
            	   {
            		  
            		   
            		   //mbyllet dritarja e logimit dhe hapet dritarja e klases se re per manipulimin eskedarit
            		   
						TextAreaLoad Text1 = new TextAreaLoad();
					
					
            		   frame.setVisible(false);
            	   }else
            	    {
            		      JOptionPane.showMessageDialog(LoginForm.this,"Incorrect login or password",
            		      "Error",JOptionPane.ERROR_MESSAGE);  
            		    }
            	    
              }
          }
  );
  
  frame.add(l1);
  frame.add(l2);
  frame.add(tf1);
  frame.add(l3);
  frame.add(p1);
  frame.add(btn1);

  frame.setSize(600, 300);
  frame.setLayout(null);
  frame.setVisible(true);
 }
 
 public static void main(String[] args) {
  new LoginForm();
 }

@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	
}
}