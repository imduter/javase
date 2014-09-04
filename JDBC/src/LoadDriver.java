import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
//Notice, do not import com.mysql.jdbc.*
//or you will hava problems!

public class LoadDriver 
{

	
	public static void main(String args[])
	{
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		
		try 
		{
			//The newInstance() call is a work around for some
			//broken Java implementations
			Class.forName("com.mysql.jdbc.Driver").newInstance();

		    conn =
		    		DriverManager.getConnection("jdbc:mysql://localhost/mydata?user=root&password=root");
		    stmt = conn.createStatement();
		    rs = stmt.executeQuery("select * from dept");
		    while(rs.next())
		    {
		    	System.out.println(rs.getString("deptno"));
		    }
		}
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		catch (SQLException ex)
		{
		    System.out.println("SQLException: " + ex.getMessage());
		    System.out.println("SQLState: " + ex.getSQLState());
		    System.out.println("VendorError: " + ex.getErrorCode());
		}
		catch (InstantiationException e) 
		{
			e.printStackTrace();
		} 
		catch (IllegalAccessException e) 
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if(conn != null)
				{
					conn.close();
					conn = null;
				}
				if(stmt != null)
				{
					stmt.close();
					stmt = null;
				}
				if(rs != null)
				{
					rs.close();
					rs = null;
				}
			}
			catch (SQLException e)
			{
				e.printStackTrace();
			}
			
		}
		
	}

}
