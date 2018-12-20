import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import java.util.Scanner;
public class sqladd
{
	public static void main( String [] args ) throws Exception
	{
		Integer n,c,x,countn=0,countt=0,avg;
		String ch,q;
		Scanner reader=new Scanner(System.in);
		do
		{
			countn++;
			System.out.print("Enter filename: ");
			String y=reader.nextLine();
			BufferedReader br = new BufferedReader(new FileReader(y));
			String fileRead = br.readLine();
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","");
			Statement stmt=con.createStatement();
			while (fileRead != null)
			{
				c=1;
				ResultSet rs=stmt.executeQuery("select * from mydb");
				String[] tokenize = fileRead.split(",");
                		String tempItem = tokenize[0];
				countt++;
				if(!rs.isClosed())
				{
					L1:while(rs.next())
					{
						ch=rs.getString(1);
						n=rs.getInt(2);
						if(ch.equals(tempItem))
						{
							n++;
							stmt.execute("UPDATE mydb SET count='"+n+"' WHERE Topics='"+ch+"'");
							c++;
						}
						if(rs.isClosed())
							break L1;
					}
				}
				if(c==1)
					stmt.executeUpdate("INSERT INTO mydb " + "VALUES ('"+tempItem+"',1)");
                		fileRead = br.readLine();
            		}
            		br.close();
			con.close();
			System.out.print("Do you wish to add another file (0/1): ");
			x=reader.nextInt();
			q=reader.nextLine();
		}
		while(x==1);
		Class.forName("com.mysql.jdbc.Driver");  
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","");
		Statement stmt=con.createStatement();
		avg=countt/countn;
		stmt.executeUpdate("INSERT INTO mydb " + "VALUES ('Average',"+avg+")");
		con.close();
	}
}