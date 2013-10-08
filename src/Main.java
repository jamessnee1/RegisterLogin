import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Main {
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		//creates a new MainFrame
		MainFrame m = new MainFrame();
		
		//starts connection to the database
		DBUtil.Connect();
		
			
	}
		
}


