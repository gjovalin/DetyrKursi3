import java.awt.*;
import java.awt.event.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import java.sql.Statement;



import javax.swing.*;

//Projekt 1_2 ne Java 2
//Informatike viti III
//Data e marrjes së projektit : 3.12.2019
//Data e dorëzimit të projektit : 15.12.2019
//Ky program ben te mundur leximin nga nje skedar text, afishimin,shtimin e rreshtave nga perdoruesi
//me ane te menyse perzgjedhese.
//Punuan Gjovalin Deda,Eljona Arrinaj,Klevisa Zekaj, Gledis Kapidani

public class TextAreaLoad extends JFrame implements ActionListener

{
	
	private  Connection connection = null;
	private  Statement statement = null;
	private  ResultSet resultSet = null;
	
   public TextAreaLoad() 
   
	
    {
	   	
        final JTextArea edit = new JTextArea(25, 40);
       

        //lexon te dhenat e skedarit dhe i afishon ne textarea
        JButton read = new JButton("Lexo databazen");
        read.addActionListener( new ActionListener()
        {
            public void actionPerformed(ActionEvent e) {
            	
            	
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/muzikant", "root", "");
                    statement = connection.createStatement();
                    resultSet = statement.executeQuery("SELECT id, emer, mbiemer, ditlindja, v_dekjes, rryma, vendlindja FROM muzikantet");
                    while (resultSet.next()) {
                  
                    int id= resultSet.getInt("id");
                    String id1=Integer.toString(id);
                    edit.append(id1);
                    edit.append("\t");
                    edit.append(resultSet.getString("emer"));
                    edit.append("\t");
                    edit.append(resultSet.getString("mbiemer"));
                    edit.append("\t");
                    int a=(resultSet.getInt("ditlindja"));
                    String a1=Integer.toString(a);
                    edit.append(a1);
                    edit.append("\t");
                    int b=resultSet.getInt("v_dekjes");
                    String b1=Integer.toString(b);
                    edit.append(b1);
                    edit.append("\t");
                    edit.append(resultSet.getString("rryma"));
                    edit.append("\t");
                    edit.append(resultSet.getString("vendlindja"));
                    edit.append("\r\n");
                    }
                    connection.close();

                } catch (Exception e1) {
                   JOptionPane.showMessageDialog(read," pamundur te   afishohet");
                 e1.printStackTrace();
                }
            }
        });
        
        
        //per te kerkuar emrin
        JButton kerko = new JButton("Kerko me Emer");
        kerko.addActionListener( new ActionListener()
        {
        	public void actionPerformed(ActionEvent e)	{
        		edit.setText("");
        		try {
        			String str=JOptionPane.showInputDialog("shkruani emrin : ");
        			
                        Class.forName("com.mysql.cj.jdbc.Driver");
                        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/muzikant", "root", "");
                        statement = connection.createStatement();
                        resultSet = statement.executeQuery("SELECT id, emer, mbiemer, ditlindja, v_dekjes, rryma, vendlindja FROM muzikantet where emer='"+str+"'" );
                        while (resultSet.next()) {
                        	
        				 int id= resultSet.getInt("id");
                         String id1=Integer.toString(id);
                         String  emri=resultSet.getString("emer");  
                         
                         String mbiemri = resultSet.getString("mbiemer");
                         int a=resultSet.getInt("ditlindja");
                         String a1=Integer.toString(a);
                         int b=resultSet.getInt("v_dekjes");
                         String b1=Integer.toString(b);
                         String rryma=resultSet.getString("rryma");
                         String vendlindja=resultSet.getString("vendlindja");
             
        			
                        edit.append(id1);
                        edit.append("\t");
                        edit.append(emri);
                        edit.append("\t");
                        edit.append(mbiemri);
                        edit.append("\t");
                        edit.append(a1);
                        edit.append(b1);
                        edit.append("\t");
                        edit.append(rryma);
                        edit.append("\t");
                        edit.append(vendlindja);
                        edit.append("\r\n");
                        
        			
        		
        		}
        			
        			connection.close();
        			
                        }
        				catch(Exception ex){
        					JOptionPane.showMessageDialog(kerko,"Lidhja me mysql nuk mund te kryhet");
        				}
        			
        	}
        	     
        		});
        
        // Shton rresht me vlerat perkatese ne skedar
        
        JButton write = new JButton("Shto ne Skedar");
        write.addActionListener( new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
             
            	edit.setText("");
            	 
        		 try 
        		 {	
        			 int id,ditlindja,v_vdekjes;
        		 	String emri,mbiemri,rr_muzikore,vendlindja,tmp1,tmp2,tmp3;
        		 	
        		 	tmp1=JOptionPane.showInputDialog("shkruani id : ");
        		 	id=Integer.parseInt(tmp1);
        		 	emri= JOptionPane.showInputDialog("shkruani emrin : ");
        		 	mbiemri= JOptionPane.showInputDialog("shkruani mbiemrin : ");
        		 	tmp2= JOptionPane.showInputDialog("shkruani ditlindjen : ");
        		 	ditlindja=Integer.parseInt(tmp2);
        		 	tmp3= JOptionPane.showInputDialog("shkruani vitin e vdekjes : ");
        		 	v_vdekjes= Integer.parseInt(tmp3);
        		 	rr_muzikore= JOptionPane.showInputDialog("shkruani rrymen muzikore : ");
        		 	vendlindja= JOptionPane.showInputDialog("shkruani vendlindjen : ");
        		 	
        		 	
        		 
        		 	 Class.forName("com.mysql.cj.jdbc.Driver");
                     connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/muzikant", "root", "");
                     statement = connection.createStatement();
                     String str = "INSERT INTO muzikantet VALUES ("+id+", N'"+emri+"', N'"+mbiemri+"', "+ditlindja+", "+v_vdekjes+", N'"+rr_muzikore+"', N'"+vendlindja+"')";
                     statement.executeUpdate(str);
                     JOptionPane.showMessageDialog(null, "shtimi me sukses ");

                     connection.close();
        	}
        	 catch (Exception ex) {//JOptionPane.showMessageDialog(read, "E pamundur te shtohet");} 
        		 JOptionPane.showMessageDialog(read,ex);
        	 }
        	 }
        	
            }
        );

        JFrame frame = new JFrame("TextArea");
        frame.getContentPane().add( new JScrollPane(edit), BorderLayout.NORTH );
        frame.getContentPane().add(read, BorderLayout.WEST);
        frame.getContentPane().add(kerko, BorderLayout.CENTER);
        frame.getContentPane().add(write, BorderLayout.EAST);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo( null );
        frame.setVisible(true);
    }

@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	
}



}