import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JFrame;
//MainFrame to be combined with other MainFrame
//This one by James Snee

public class MainFrame extends JFrame {
	
	private LoginDialog login;
	private RegisterDialog register;
	//Declaring access to the database
	private static final String USERNAME = "dbuser";
	private static final String PASSWORD = "dbpassword";
	//If we are connecting to a remote database not on localhost, replace
	//localhost in the following string with the IP address
	private static final String CONN_STRING = "jdbc:mysql://localhost/logincredentials";
	
	
	
	public MainFrame(){
		
		
		//instantiate the login and register dialogs
		login = new LoginDialog(this);
		register = new RegisterDialog(this);
		register.setVisible(false);
		login.setVisible(true);
		
		
	}
	
	public LoginDialog getLoginDialog(){
		
		return login;
		
	}
	
	public RegisterDialog getRegisterDialog(){
		
		return register;
		
	}
	
	//getter for the connection
	public Connection getConnection() throws SQLException{
		
		return DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);
		
	}

}
