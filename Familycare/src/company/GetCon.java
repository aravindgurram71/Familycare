package company;
import java.sql.*;
public class GetCon {
private GetCon()
{
}
public static Connection con;
static 
{
	try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		 con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","12345");
		}
	catch(ClassNotFoundException e)
	{
		e.printStackTrace();
	}
	catch(SQLException e)
	{
		System.out.println("Exception in GetCon");
	}
}
public static Connection getCon()
{
	return con;
}
public static int getPrimaryKey()
{
	int nextvalue=0;
	Connection con=GetCon.getCon();
	PreparedStatement ps2;
	try
	{
		ps2=con.prepareStatement("select company1.nextval from dual");
		
		ResultSet rs=ps2.executeQuery();
		rs.next();
		nextvalue=rs.getInt(1);
	}
	catch(SQLException e)
	{
		e.printStackTrace();
	}
	return nextvalue;
}
}
