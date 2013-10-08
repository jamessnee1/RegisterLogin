

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JLabel;

//ActionListener to handle event when the "New" game option is selected
//By James Snee
public class NewGameActionListener implements ActionListener {
	//frame where the event will be triggered from
	private MainFrame frame;

	public NewGameActionListener(MainFrame frame)
	{
		this.frame = frame;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		
			if (frame.getRegisterDialog().getFname().trim().equals("")){
				frame.getRegisterDialog().setInformation("Error: Please enter your first name!");
			}
			
			else if (frame.getRegisterDialog().getLname().trim().equals("")){
				frame.getRegisterDialog().setInformation("Error: Please enter your last name!");
			}

			else if (frame.getRegisterDialog().getAddress().trim().equals("")){
				frame.getRegisterDialog().setInformation("Error: Please enter your address!");
			}

			else if (frame.getRegisterDialog().getPhoneNum().trim().equals("")){
				frame.getRegisterDialog().setInformation("Error: Please enter your phone number!");
			}

			else if (frame.getRegisterDialog().getRegUsername().trim().equals("")){
				frame.getRegisterDialog().setInformation("Error: Please enter a username!");
			}


			else if (frame.getRegisterDialog().getRegPassword().trim().equals("")){
				frame.getRegisterDialog().setInformation("Error: Please enter a password!");
			}
			
			else {
				//else check if the user does not already exist in the database
				try {
					DBUtil.checkUsername(frame.getConnection(), frame.getRegisterDialog().getRegUsername());
					
					//if check passes, create new entry in database
					DBUtil.updateDatabase(frame.getConnection(), frame.getRegisterDialog().getFname(), frame.getRegisterDialog()
							.getLname(), frame.getRegisterDialog().getAddress(), frame.getRegisterDialog().getPhoneNum(),
							frame.getRegisterDialog().getRegUsername(), frame.getRegisterDialog().getRegPassword());
					frame.getRegisterDialog().setVisible(false);
					System.out.println("User successfully created! Starting new game now");
					//call new game method here
					
				} catch (SQLException e2) {
					System.out.println("Exception in NewGameActionListener called");
					DBUtil.processException(e2);
					
				}
				
			}
			
	}
}


