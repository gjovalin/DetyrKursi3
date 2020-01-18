import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class krijoDatabazen {


	
		
		 String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
		 static String DB_URL = "jdbc:mysql://localhost/";
// Kredencialet ne database
		 static String USER = "root";
		 static String PASS = "";
		
	//metode me kriju tabelen	
		public static   void krijoTabelen() throws SQLException{			
			
			try{
					String	tabela=" Create table muzikantet (id INTEGER not NULL, " + 
					" emer VARCHAR(255), " + 
					"  mbiemer VARCHAR(255)," + 
					"  ditlindja INTEGER, " + 
					" v_dekjes INTEGER, "+
					" rryma VARCHAR(255), " + 
					" vendlindja VARCHAR(255), " + 
					"  PRIMARY KEY ( id ))" ;
					
	
		
		Connection 	conn1 = DriverManager.getConnection("jdbc:mysql://localhost/muzikant", "root", "");
			conn1.createStatement().executeUpdate(tabela);

			conn1.close();
		}catch (Exception e) {
			e.printStackTrace();
			}
		
		}
		
		public static void mbushTeDhena() throws SQLException {
			
			Connection connection = null;
		    Statement statement = null;
		   // ResultSet resultSet = null;
			
			try {
				
				 Class.forName("com.mysql.cj.jdbc.Driver");
                 connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/muzikant", "root", "");
                 statement = connection.createStatement();
                 statement.executeUpdate("INSERT INTO muzikantet VALUES (7, 'Fred', 'Blogs', 1948, 0, 'jazz', 'Manchester');");
     			connection.close();	
			}catch (Exception e) {
				e.printStackTrace();
				}
			
			

			
		}
		
		public static void main (String[] args) throws SQLException {
			
			
			
			krijoDatabazen.mbushTeDhena();
			krijoDatabazen.krijoTabelen();
		
		/*public krijoDatabazen () throws SQLException{
			
				Connection conn = null;
				Statement stmt = null;
				try{
	 //HAPI 2: Registrimi i JDBC driver
					Class.forName("com.mysql.cj.jdbc.Driver");
					//HAPI 3: Krijimi i connection
					System.out.println("Lidhja me database...");
					conn = DriverManager.getConnection(DB_URL, USER, PASS);
	 //HAPI 4: Ekzekutimi i query
					System.out.println("Krijimi i database...");
					stmt = conn.createStatement();

					String sql = "CREATE DATABASE muzikant";
					stmt.executeUpdate(sql);
					System.out.println("Database u krijua me sukses...");
				}catch(SQLException se){
	 //Trajtimi i perjashtimit te JDBC
					se.printStackTrace();
				}catch(Exception e){
	 //Trajtimi i perjashtimit te Class.forName
					e.printStackTrace();
				}finally{
	 //blloku finally qe mbyll resurset
					try{
						if(stmt!=null)
							stmt.close();
					}catch(SQLException se2){
					}
	 
					 try{
						 if(conn!=null)
						 conn.close();
						 }catch(SQLException se){
						 se.printStackTrace();
						 }
						 }
						 System.out.println("Dalje....");	
						 
						 //thirrje metodes
						// krijoTabelen() ;
						
			*/
		
		
		}


		}
