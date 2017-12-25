import java.awt.*;
import java.io.*;
import java.util.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class changePasword
{
    public void c_pass(JFrame window)
    {
        JDialog cPDialog = new JDialog();//
        cPDialog.setContentPane(new JLabel(new ImageIcon("C:/Program Files/Airport Database/air.jpg")));
		cPDialog.setVisible(true);
		Container c = cPDialog.getContentPane();
		cPDialog.setSize(630,400);
        cPDialog.setTitle("Change Password");
		cPDialog.setLocationRelativeTo(window);
		c.setLayout(null);
        
        JLabel oPwd=new JLabel("Enter the old Password:");
        oPwd.setBounds(70, 70, 200, 25);
        c.add(oPwd);
        JTextField oTPwd=new JTextField(30);
        oTPwd.setBounds(290, 70, 200, 25);
        c.add(oTPwd);
        
        JLabel nPwd=new JLabel("Enter the new Password");
        nPwd.setBounds(70,100,200,25);
        c.add(nPwd);
        JTextField nTPwd=new JTextField(30);
        nTPwd.setBounds(290, 100, 200, 25);
        c.add(nTPwd);
        
        JButton cPButton=new JButton("ok");
        cPButton.setBounds(290, 130,50, 25);
        c.add(cPButton);
        cPButton.setToolTipText("Press ok to change Password");
        
        cPButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
                try
                {
                    BufferedReader istrm=new BufferedReader(new FileReader("C:\\Users\\Public\\Documents\\AirportData\\Files\\Protected\\Password.txt"));
                    String usr=istrm.readLine();
                    String opsd=istrm.readLine();
                    istrm.close();
                    //System.out.println(oTPwd.getText());
                    PrintWriter o_stream=null;
                    try
                    {
                        if((oTPwd.getText().equals(opsd)))
                        {
                            o_stream=new PrintWriter(new FileOutputStream("C:\\Users\\Public\\Documents\\AirportData\\Files\\Protected\\Password.txt"));
                            o_stream.println("admin");
                            o_stream.println(nTPwd.getText());
                            o_stream.flush();
                            o_stream.close();
                            JOptionPane.showMessageDialog(null,"Password is Changed Successfully");
                            cPDialog.setVisible(false);
                        }
                        else
                        {
                            JOptionPane.showMessageDialog(null,"Password did not match!");
                        }
                    }
                    catch(FileNotFoundException e)
                    {
                        JOptionPane.showMessageDialog(null,"File Not Found");
                    }
                    
            
                }
                catch(IOException f)
                {
                    JOptionPane.showMessageDialog(null,"Input Output error During File Reading!");
                }
                
                
                
            }
        }
        );
        
        JButton cPCancel=new JButton("Cancel");
        cPCancel.setBounds(350, 130,80, 25);
        c.add(cPCancel);
        cPCancel.setToolTipText("TO Exit the Change Password Dialog");
        cPCancel.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
                cPDialog.setVisible(false);
            }
        }
        );
        
    }
    
    
}