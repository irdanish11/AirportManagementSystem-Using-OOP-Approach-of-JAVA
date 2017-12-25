import java.awt.*;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.GridLayout;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;//
import javax.swing.JTextField;
import java.io.*;
import java.util.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;

public class airPortData
{
    public static JFrame window=new JFrame();//set the constructor of JFrame
    public static JPanel panel=new JPanel();//set the constructor of JPanel

	public static void main(String[] args)
    {
        File dir = new File("C:\\Users\\Public\\Documents\\AirportData\\Files\\Protected");
    	File dir1 = new File("C:\\Users\\Public\\Documents\\AirportData\\Images");
        boolean successful = dir.mkdirs();
		boolean dir1_successful = dir1.mkdirs();
        airPortData aP = new airPortData();
        aP.welcome();
    }
    
    

    
    //Login Method.
    public static void mainlogin()
    {
        JDialog empLDialog=new JDialog();
        empLDialog.setContentPane(new JLabel(new ImageIcon("C:/Program Files/Airport Database/air.jpg")));
            empLDialog.setSize(765, 730);
            Container c=empLDialog.getContentPane();
            empLDialog.setVisible(true);
            empLDialog.setTitle("Employee Login");
            empLDialog.setLocationRelativeTo(window);
            c.setLayout(null);
        
        /*Creates the label */
		JLabel userLabel = new JLabel("User");
        empLDialog.add(userLabel);
		userLabel.setBounds(220, 250, 80, 25);
        userLabel.setVisible(true);
		
        
		/*Creates the TextField */
		JTextField userText = new JTextField(20);
        empLDialog.add(userText);
		userText.setBounds(300, 250, 160, 25);
        userText.setVisible(true);
		
        
		/*Creates the Label */
		JLabel passwordLabel = new JLabel("Password");
        empLDialog.add(passwordLabel);
		passwordLabel.setBounds(220, 290, 80, 25);
        passwordLabel.setVisible(true);
		
        
        
        
		/*Creates the Password Field */
		JPasswordField passwordText = new JPasswordField(20);
        empLDialog.add(passwordText);
		passwordText.setBounds(300, 290, 160, 25);
        passwordText.setVisible(true);
		
        //Add EnterKey to Respond as actionListener.
        Action action = new AbstractAction()
        {
            public void actionPerformed(ActionEvent ae)
            {
                String user=userText.getText();
                char[] pass_c=passwordText.getPassword();
                String pass=new String(pass_c); //converting chraceter array into string.
                
                passwordFile pF=new passwordFile();
                
                if(user.equals(pF.u)&&pass.equals(pF.p))
                {
                    empLDialog.setVisible(false);
                    airPortData log=new airPortData();
                    log.mainWindow();//invoking the method loginPanel() from passPro.java class
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"Wrong UserName / Password Combination", "Error", JOptionPane.ERROR_MESSAGE);
                }
    }
        };
passwordText.addActionListener( action );
		/*Creates the login button */
		JButton loginButton = new JButton("login");
        empLDialog.add(loginButton);
		loginButton.setBounds(300, 330, 80, 25);
        loginButton.setVisible(true);
		
        
        JButton exButton = new JButton("Exit");
        empLDialog.add(exButton);
        exButton.setBounds(400, 330, 80, 25);
        exButton.setVisible(true);
        
        
        exButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                System.exit(0);
            }
        });
        
        
		
		// Action Listener for the Login Button 
        loginButton.addActionListener(new ActionListener()
        {
               
            public void actionPerformed(ActionEvent ae)
            {
                String user=userText.getText();
                char[] pass_c=passwordText.getPassword();
                String pass=new String(pass_c); //converting chraceter array into string.
                
                passwordFile pF=new passwordFile();
                
                if(user.equals(pF.u)&&pass.equals(pF.p))
                {
                    empLDialog.setVisible(false);
                    airPortData log=new airPortData();
                    log.mainWindow();//invoking the method loginPanel() from passPro.java class
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"Wrong UserName / Password Combination", "Error", JOptionPane.ERROR_MESSAGE);
                }
    }
        }
        ); 
        
       empLDialog.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//set the default operation for close button
} // end of login method.
    
    public static void mainWindow()
    {
		
        
        
       window.setSize(1920,1080);//set the size of window
        window.setIconImage(new ImageIcon("C:/Program Files/Airport Database/airplane.png").getImage());//change the cup icon to desired icon 
        
      
        window.setTitle("Airport Database System By Irfan");
        
        
        JMenuBar jmb=new JMenuBar();
        JMenu menu=new JMenu("Menu");
        
        JMenuItem passe = new JMenuItem("Passanger");
        JMenuItem empl=new JMenuItem("Employee");
        JMenuItem tik=new JMenuItem("Tickets");
        JMenuItem cat=new JMenuItem("Cattering");
        JMenuItem sec=new JMenuItem("Security");
        JMenuItem cp=new JMenuItem("Change Password");
        JMenuItem logout = new JMenuItem("Logout!");
        JMenu about=new JMenu("About");
        JMenuItem aboutdev=new JMenuItem("About Developer");
        JMenuItem aboutsoft=new JMenuItem("About Software");
        JMenu help=new JMenu("Help");
        JMenu exit=new JMenu("Exit");
        JMenuItem exitPro=new JMenuItem("Exit the Program");
        exit.setToolTipText("To Exit the Program");
        
        cp.addActionListener(new ActionListener()
        {
           public void actionPerformed(ActionEvent ae)
           {
               changePasword cP=new changePasword();
               cP.c_pass(window);
            }
         }
         );
        
        logout.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
                window.setVisible(false);
                airPortData aP = new airPortData();
                aP.mainlogin();
            }
        }
        );
        
        sec.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
                securityLogin();
            }
        }
        );
        
        cat.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
                catLogin();
            }
        }
        );
        
        tik.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
                ticketsLogin();
            }
        }
        );
        
        passe.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
                loginPass();
            }
        }
        );
        
        empl.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
                empLogin();
            }
        }
        );
        
        exitPro.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
                System.exit(0);
            }
        }
        );
        
        aboutdev.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
                aboutDeveloper();
            }
        }
        );
        
        aboutsoft.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
                aboutSoftware();
            }
        }
        );
        
       // JPanel panel=new JPanel();//set the constructor of JPanel
        
        window.add(panel);//creating the panel
        panel.setLayout(null);//set the layout of panel.
        
        
       // Creates the label 
        JLabel abtLabel=new JLabel("AABII Solutions!");
        panel.add(abtLabel); 
        abtLabel.setBounds(600,200,250,25);
        abtLabel.setFont(new Font("Serif",Font.ROMAN_BASELINE,30));
        abtLabel.setVisible(true);
        
        
        
        
       JButton passanger = new JButton("Passangers");
		            passanger.setBounds(310, 280, 120, 25);
		            panel.add(passanger);
                    passanger.setToolTipText("To Add Passangers Data");
                    passanger.addActionListener(new ActionListener()
                    {
                        public void actionPerformed(ActionEvent ae)
                        {
                            loginPass();
                            
                        }
                    }
                    );//end of Action Listener for the passanger button.
                    JButton chkpassanger= new JButton("Employee");
		            chkpassanger.setBounds(460, 280, 120, 25);
		            panel.add(chkpassanger);
                    chkpassanger.setToolTipText("To Check Passanger Data");
                    chkpassanger.addActionListener(new ActionListener()
                    {
                        public void actionPerformed(ActionEvent ae)
                        {
                            empLogin();
                        }
                    }
                    );
                    
                    JButton delpassanger=new JButton("Tickets");
                    delpassanger.setBounds(610,280, 120, 25);
                    panel.add(delpassanger);
                    delpassanger.setToolTipText("Tickets Management");
                    delpassanger.addActionListener(new ActionListener()
                    {
                        public void actionPerformed(ActionEvent ae)
                        {
                            ticketsLogin();
                        }
                    }
                    );
                    JButton modpassanger=new JButton("Cattering");
                    modpassanger.setBounds(760,280, 120, 25);
                    panel.add(modpassanger);
                    modpassanger.setToolTipText("To Modify the Data of Passanger");
                    modpassanger.addActionListener(new ActionListener()
                    {
                        public void actionPerformed(ActionEvent ae)
                        {
                            catLogin();
                        }
                    }
                    );
                    
                    JButton employe= new JButton("Security Staff");
		            employe.setBounds(910, 280, 120, 25);
		            panel.add(employe);
                    employe.setToolTipText("To Add Employee Data");
                    employe.addActionListener(new ActionListener()
                    {
                        public void actionPerformed(ActionEvent ae)
                        {
                            securityLogin();
                        }
                    }
                    );//end of Action Listener for the employe button.
        
                    JButton exitButton=new JButton("Exit");
                    exitButton.setBounds(660, 350, 80, 25);
                    panel.add(exitButton);
                    exitButton.setToolTipText("Exit the Program");
                    exitButton.addActionListener(new ActionListener()
                    {
                        public void actionPerformed(ActionEvent ae)
                        {
                            System.exit(0);
                        }
                    }
                    ); 
                    
        menu.add(passe);
        menu.add(empl);
        menu.add(tik);
        menu.add(cat);
        menu.add(sec);
        menu.add(cp);
        menu.add(logout);
        about.add(aboutdev);
        about.add(aboutsoft);
        jmb.add(menu);
        jmb.add(about);
        jmb.add(help);
        jmb.add(exit);
        exit.add(exitPro);
        window.setJMenuBar(jmb);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//set the default operation for close button
        window.setVisible(true);//set the window visible.
        //window.setContentPane(new JLabel(new ImageIcon("F:\\air.jpg")));
        
    }//end of loginPanel() method.
    
    public static void aboutDeveloper()
    {
        
        JDialog aDialog = new JDialog();
		Container c = aDialog.getContentPane();
		aDialog.setSize(630, 300);
		aDialog.setLocationRelativeTo(window);
		c.setLayout(null);
		aDialog.setTitle("About");
		
		JPanel aDPanel = new JPanel();
        
		JLabel l1=new JLabel("This Software is Developed By Irfan Danish FA15-BEL-012");
        l1.setBounds(100, 70, 500, 25);
        c.add(l1);
		JButton okB=new JButton("Ok");
        okB.setBounds(290, 100,50, 25);
        c.add(okB);
		c.add(aDPanel);
		
		aDialog.setVisible(true);
		okB.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				aDialog.setVisible(false);
		    }
	   }
       );
      
    }//End of about method
    
    public static void aboutSoftware()
    {
        JDialog dialog = new JDialog();
		Container c = dialog.getContentPane();
		dialog.setSize(480, 200);
		dialog.setLocationRelativeTo(window);
		c.setLayout(new GridLayout(5, 1));
		dialog.setTitle("About");
		JButton okButton = new JButton("OK");
		JPanel buttonPanel = new JPanel();
		buttonPanel.add(okButton);
		c.add(new JLabel("Airport Database System By Irfan Danish ", JLabel.CENTER));
		c.add(new JLabel("FA15-BEL-012", JLabel.CENTER));
		c.add(new JLabel("Comsats Institute Of Information Technology, Islamabad", JLabel.CENTER));
		c.add(new JLabel("irfandanish.official@gmail.com", JLabel.CENTER));
		c.add(buttonPanel);
		c.setBackground(Color.YELLOW);
		dialog.setVisible(true);
		okButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				dialog.setVisible(false);
		    }
	});
    }
    
    
    public static void loginPass()
    {
        
                
                    
                    panel.removeAll();
                    panel.revalidate();
                    panel.repaint();
                    panel.setVisible(true);
                    
                	   
                    JLabel abtLabel=new JLabel("AABII Solutions!");
                    abtLabel.setBounds(600,200,250,25);
                    abtLabel.setFont(new Font("Serif",Font.ROMAN_BASELINE,30));
                    panel.add(abtLabel); 	
                    
                    JButton passanger = new JButton("Add Passangers Data");
		            passanger.setBounds(280, 280, 180, 25);
		            panel.add(passanger);
                    passanger.setToolTipText("To Add Passangers Data");
                    passanger.addActionListener(new ActionListener()
                    {
                        public void actionPerformed(ActionEvent ae)
                        {
                            passangerData pD=new passangerData();
                            pD.addPassangerData(window);
                        }
                    }
                    );//end of Action Listener for the passanger button.
                    JButton chkpassanger= new JButton("Check Passanger Data");
		            chkpassanger.setBounds(490, 280, 180, 25);
		            panel.add(chkpassanger);
                    chkpassanger.setToolTipText("To Check Passanger Data");
                    chkpassanger.addActionListener(new ActionListener()
                    {
                        public void actionPerformed(ActionEvent ae)
                        {
                            passangerData pD=new passangerData();
                            pD.chkPass(window);
                        }
                    }
                    );
                    
                    JButton delpassanger=new JButton("Delete Passanger Data");
                    delpassanger.setBounds(700,280, 180, 25);
                    panel.add(delpassanger);
                    delpassanger.setToolTipText("To Delete The Data of Passanger");
                    delpassanger.addActionListener(new ActionListener()
                    {
                        public void actionPerformed(ActionEvent ae)
                        {
                            passangerData dPD=new passangerData();
                            dPD.delPass(window);
                        }
                    }
                    );
                    JButton modpassanger=new JButton("Modify Passanger");
                    modpassanger.setBounds(910,280, 180, 25);
                    panel.add(modpassanger);
                    modpassanger.setToolTipText("To Modify the Data of Passanger");
                    modpassanger.addActionListener(new ActionListener()
                    {
                        public void actionPerformed(ActionEvent ae)
                        {
                            passangerData dPD=new passangerData();
                            dPD.modPass(window);
                        }
                    }
                    );  
            }
            
            
public static void empLogin()
    {
        
                    
                    panel.removeAll();
                    panel.revalidate();
                    panel.repaint();
                    panel.setVisible(true);
                    
                    JButton employe= new JButton("Add Employee Data");
		            employe.setBounds(280, 310, 180, 25);
		            panel.add(employe);
                    employe.setToolTipText("To Add Employee Data");
                    employe.addActionListener(new ActionListener()
                    {
                        public void actionPerformed(ActionEvent ae)
                        {
                            employeData eD=new employeData();
                            eD.addEmp(window);
                        }
                    }
                    );//end of Action Listener for the employe button.
                    
                    
                    JButton chkemploye= new JButton("Check Employee Data");
		            chkemploye.setBounds(490, 310, 180, 25);
		            panel.add(chkemploye);
                    chkemploye.setToolTipText("To Check Employee Data");
                    chkemploye.addActionListener(new ActionListener()
                    {
                        public void actionPerformed(ActionEvent ae)
                        {
                            employeData eD=new employeData();
                            eD.chkEmp(window);
                        }
                    }
                    );
                    
                    JButton delemploye=new JButton("Delete Employee Data");
                    delemploye.setBounds(700,310, 180, 25);
                    panel.add(delemploye);
                    delemploye.setToolTipText("To Delete Employee Data");
                    delemploye.addActionListener(new ActionListener()
                    {
                        public void actionPerformed(ActionEvent ae)
                        {
                            employeData eD=new employeData();
                            eD.delEmp(window);
                        }
                    }
                    );
                    
                    JButton modemploye=new JButton("Modify Employee");
                    modemploye.setBounds(910,310, 180, 25);
                    panel.add(modemploye);
                    modemploye.setToolTipText("To Modify the data of Employee");
                    modemploye.addActionListener(new ActionListener()
                    {
                        public void actionPerformed(ActionEvent ae)
                        {
                            employeData eD=new employeData();
                            eD.modEmployee(window);
                        }
                    }
                    );
                    
                    JButton exitButton=new JButton("Exit");
                    exitButton.setBounds(660, 350, 80, 25);
                    panel.add(exitButton);
                    exitButton.setToolTipText("Exit the Program");
                    exitButton.addActionListener(new ActionListener()
                    {
                        public void actionPerformed(ActionEvent ae)
                        {
                            System.exit(0);
                        }
                    }
                    );
  
    } //end of empLogin()
    
public static void catLogin()
    {
        
                    panel.removeAll();
                    panel.revalidate();
                    panel.repaint();
                    panel.setVisible(true);
                    
                    JLabel abtLabel=new JLabel("AABII Solutions!");
                    abtLabel.setBounds(550,200,250,25);
                    abtLabel.setFont(new Font("Serif",Font.ROMAN_BASELINE,30));
                    panel.add(abtLabel); 	
                    
                    JButton passanger = new JButton("Add Food");
		            passanger.setBounds(510, 280, 120, 25);
		            panel.add(passanger);
                    passanger.setToolTipText("To Add Food");
                    passanger.addActionListener(new ActionListener()
                    {
                        public void actionPerformed(ActionEvent ae)
                        {
                            cateringManagment cM=new cateringManagment();
                            cM.addCat(window);
                        }
                    }
                    );//end of Action Listener for the passanger button.
                    JButton chkpassanger= new JButton("Check Foods");
		            chkpassanger.setBounds(660, 280, 120, 25);
		            panel.add(chkpassanger);
                    chkpassanger.setToolTipText("To Check Food for a Flight");
                    chkpassanger.addActionListener(new ActionListener()
                    {
                        public void actionPerformed(ActionEvent ae)
                        {
                            cateringManagment cM=new cateringManagment();
                            cM.chkCat(window);
                        }
                    }
                    );
                    
                    JButton delpassanger=new JButton("Delete Food");
                    delpassanger.setBounds(800,280, 120, 25);
                    panel.add(delpassanger);
                    delpassanger.setToolTipText("To Delete The Food for a Flight");
                    delpassanger.addActionListener(new ActionListener()
                    {
                        public void actionPerformed(ActionEvent ae)
                        {
                            cateringManagment cM=new cateringManagment();
                            cM.delCat(window);
                        }
                    }
                    );
                    
                    JButton cTiPass=new JButton("Change Password");
                    cTiPass.setBounds(640, 320, 150, 25);
                    panel.add(cTiPass);
                    cTiPass.setToolTipText("Change Password");
                    cTiPass.addActionListener(new ActionListener()
                    {
                        public void actionPerformed(ActionEvent ae)
                        {
                            changePasword cP=new changePasword();
                            cP.c_pass(window);
                        }
                    }
                    );
           
    } //end of catLogin() method.

public static void ticketsLogin()
{
    	
                    panel.removeAll();
                    panel.revalidate();
                    panel.repaint();
                    panel.setVisible(true);
                    
                    JLabel abtLabel=new JLabel("AABII Solutions!");
                    abtLabel.setBounds(600,200,250,25);
                    abtLabel.setFont(new Font("Serif",Font.ROMAN_BASELINE,30));
                    panel.add(abtLabel); 	
                    
                    JButton addTick = new JButton("Add Tickets");
		            addTick.setBounds(580, 280, 120, 25);
		            panel.add(addTick);
                    addTick.setToolTipText("To Add of Number Seats/Tickets for a Flight");
                    addTick.addActionListener(new ActionListener()
                    {
                        public void actionPerformed(ActionEvent ae)
                        {
                            ticketsData tD=new ticketsData();
                            tD.addTic(window);
                        }
                    }
                    );//end of Action Listener for the passanger button.
                    JButton chkTicket= new JButton("Check Tickets");
		            chkTicket.setBounds(740, 280, 120, 25);
		            panel.add(chkTicket);
                    chkTicket.setToolTipText("Check Tickets of Flight:");
                    chkTicket.addActionListener(new ActionListener()
                    {
                        public void actionPerformed(ActionEvent ae)
                        {
                            ticketsData tD=new ticketsData();
                            tD.chkTick(window);
                        }
                    }
                    );
                    
                    JButton cTiPass=new JButton("Change Password");
                    cTiPass.setBounds(660, 320, 150, 25);
                    panel.add(cTiPass);
                    cTiPass.setToolTipText("Change Password");
                    cTiPass.addActionListener(new ActionListener()
                    {
                        public void actionPerformed(ActionEvent ae)
                        {
                            changePasword cP=new changePasword();
                            cP.c_pass(window);
                        }
                    }
                    );
                
} //end of ticketsLogin Method.


 public static void securityLogin()
{
    	
                    panel.removeAll();
                    panel.revalidate();
                    panel.repaint();
                    panel.setVisible(true);
                    
                    JLabel abtLabel=new JLabel("AABII Solutions!");
                    abtLabel.setBounds(600,200,250,25);
                    abtLabel.setFont(new Font("Serif",Font.ROMAN_BASELINE,30));
                    panel.add(abtLabel); 	
                    
                    JButton passanger = new JButton("Add Security");
		            passanger.setBounds(500, 280, 120, 25);
		            panel.add(passanger);
                    passanger.setToolTipText("To Add Security Staff");
                    passanger.addActionListener(new ActionListener()
                    {
                        public void actionPerformed(ActionEvent ae)
                        {
                            secData sD=new secData();
                            sD.addSecData(window);
                        }
                    }
                    );//end of Action Listener for the passanger button.
                    JButton chkpassanger= new JButton("Check Security");
		            chkpassanger.setBounds(660, 280, 120, 25);
		            panel.add(chkpassanger);
                    chkpassanger.setToolTipText("To Check details of Security Staff");
                    chkpassanger.addActionListener(new ActionListener()
                    {
                        public void actionPerformed(ActionEvent ae)
                        {
                            secData sD=new secData();
                            sD.chkSecurity(window);
                        }
                    }
                    );
                    
                    JButton del= new JButton("Delete Security");
		            del.setBounds(800, 280, 120, 25);
		            panel.add(del);
                    del.setToolTipText("To Delete Security Staff");
                    del.addActionListener(new ActionListener()
                    {
                        public void actionPerformed(ActionEvent ae)
                        {
                            secData sD=new secData();
                            sD.delSecurity(window);
                        }
                    }
                    );
} //end of securityLogin() Method.

public static void welcome()
{	
		///Load first Image
		JPanel panel1 = new JPanel();
        window.setIconImage(new ImageIcon("C:/Program Files/Airport Database/airplane.png").getImage());
		JLabel label1 = new JLabel(new ImageIcon("C:/Program Files/Airport Database/load.GIF"));
		panel1.add(label1);
		panel1.setLayout(new GridLayout(1,1));
		window.add(panel1);
		window.setSize(200,270);
		window.setLocation(600, 200);
		window.setUndecorated(true);
		window.setVisible(true);
		try 
		{
			Thread.sleep(2000);
		} catch (InterruptedException e) 
		{
			e.printStackTrace();
		}		
		window.remove(panel1);
		
		
		//Load Second Image
        JPanel panel=new JPanel();
        window.setIconImage(new ImageIcon("C:/Program Files/Airport Database/airplane.png").getImage());
        panel.setLayout(new GridLayout(1, 1));
		JLabel label=new JLabel();
		
		ImageIcon imageIcon = new ImageIcon(new ImageIcon("C:/Program Files/Airport Database/welcome.jpg").getImage().getScaledInstance(400, 250, Image.SCALE_DEFAULT));
		label.setIcon(imageIcon);
		panel.add(label);
		window.repaint();
		window.add(panel);
		window.setSize(400, 250);
		window.setLocation(500,230);
		window.setVisible(true);
		
		try 
		{
			Thread.sleep(1000);
		} catch (InterruptedException e) 
		{
			e.printStackTrace();
		}		
		window.remove(panel);
		
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setSize(765,730);
		window.setLocation(280 , 0);
		window.dispose();
		window.setUndecorated(false);
        airPortData aP = new airPortData();
        aP.mainlogin();        
		
	} 
    
}