import java.sql.*;  
class sql{  
	public static void main(String args[]){  
	try{  
		Class.forName("com.mysql.jdbc.Driver");  
		Connection con=DriverManager.getConnection(  
		"jdbc:mysql://localhost:3306/test","root","");
		Statement stmt=con.createStatement();  
		stmt.executeUpdate("INSERT INTO test " + "VALUES ('Touseef',175)"); 
		con.close();  
		}catch(Exception e){ System.out.println(e);}  
	}  
}  