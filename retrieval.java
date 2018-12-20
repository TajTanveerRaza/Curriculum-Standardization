import java.sql.*;  
import java.io.*;
public class retrieval
{  
	private static final String FILENAME = "output.txt";
	public static void main(String args[])
	{  
		try{  
			Integer i=0,y=0;
			String ch;
			FileWriter fw = new FileWriter("output.txt", true);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter out = new PrintWriter(bw);
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","");
			Statement stmt=con.createStatement(); 
			ResultSet rs=stmt.executeQuery("SELECT * FROM mydb ORDER BY Count DESC");
			while(rs.next())
			{		
				if(rs.getString(1).equals("Average"))
				{
					i=rs.getInt(2);
					y=y-i;
				}
				else
				{
					ch=rs.getString(1);
					out.println(ch);
					y++;
					if(y==0)
						break;
				}
			}
			con.close();  
			out.close();
			System.out.println("Standard syllabus created");
		}
		catch(Exception e){System.out.println(e);}  
	}  
}  