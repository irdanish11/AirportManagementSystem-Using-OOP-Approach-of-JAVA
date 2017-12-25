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
import javax.swing.JMenuBar;//
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.io.*;
import java.util.*;
import javax.swing.*;
public class ticketsData
{
    BufferedReader buR;
    public PrintWriter ePW=null;
    public void addTic(JFrame window)
    {
    
    
        JDialog eDialog = new JDialog();
		eDialog.setVisible(true);
		Container c = eDialog.getContentPane();
		eDialog.setSize(705, 630);
        eDialog.setContentPane(new JLabel(new ImageIcon("C:/Program Files/Airport Database/air.jpg")));
        eDialog.setTitle("Add's the Tickets for a Flight:");
		eDialog.setLocationRelativeTo(window);
		c.setLayout(null);
        
         JLabel laEmNam=new JLabel("Total Number of Tickets:");
         laEmNam.setBounds(180, 210, 180, 25);
         c.add(laEmNam);
         JTextField tEmNam=new JTextField(30);
         tEmNam.setBounds(370, 210, 180, 25);
         c.add(tEmNam);
        
         JLabel laEmId=new JLabel("Enter Reserved Tickets:");
         laEmId.setBounds(180, 250, 160, 25);
         c.add(laEmId);
         JTextField tEmId=new JTextField(30);
         tEmId.setBounds(370, 250, 180, 25);
         c.add(tEmId);
         
         JLabel laEmCId=new JLabel("Enter the Available Tickets:");
         laEmCId.setBounds(180, 330, 160, 25);
         c.add(laEmCId);
         JTextField tEmCId=new JTextField(30);
         tEmCId.setBounds(370, 330, 180, 25);
         c.add(tEmCId);
         
         JLabel laTFl=new JLabel("Enter the Flight Number:");
         laTFl.setBounds(180, 290, 160, 25);
         c.add(laTFl);
         JTextField latTFl=new JTextField(30);
         latTFl.setBounds(370, 290, 180, 25);
         c.add(latTFl);
         
         JButton bOK=new JButton("ok");
         bOK.setBounds(370, 490, 50, 25);
         c.add(bOK);
         bOK.setToolTipText("Press OK to Save Data");
         bOK.addActionListener(new ActionListener()
             {
                 public void actionPerformed(ActionEvent ae)
                 {
                     
                     if(tEmNam.getText().isEmpty()||tEmCId.getText().isEmpty()||tEmId.getText().isEmpty())
                     {
                            eDialog.setVisible(true);
							JOptionPane.showMessageDialog(null, "Complete all the Text Fields");
                     }
                     else
                     {
                         String nam=tEmNam.getText();
                         String id=tEmId.getText();
                         String cid=tEmCId.getText();
                         String fl=latTFl.getText();
                         
                         try
                         {
                            
                             ePW=new PrintWriter(new FileOutputStream("C:\\Users\\Public\\Documents\\AirportData\\Files\\ticketData.txt",true));
                             String emData=fl+"-"+nam+"-"+id+"-"+cid;
                             ePW.println(emData);
                             ePW.flush();
                             ePW.close();
                             JOptionPane.showMessageDialog(null, "The Record of the Tickets has been added successfully");
                             eDialog.setVisible(false);
                         }
                         catch(FileNotFoundException e)
                         {
                             JOptionPane.showMessageDialog(null, "File not found!");
                         }
                         
                     }
                     
                 }
             }
         );
         
         JButton eCancel=new JButton("Cancel");
         eCancel.setBounds(430, 490, 80, 25);
         c.add(eCancel);
         eCancel.setToolTipText("Cancel The Dialog Box");
         eCancel.addActionListener(new ActionListener()
         {
            public void actionPerformed(ActionEvent ae)
            {
                eDialog.setVisible(false);                
            }
         }
         );
         
    }//end of addEmp() method.
    
    
    
    public void chkTick(JFrame window)
    {
        
        
        JDialog eCDialog = new JDialog();
        eCDialog.setContentPane(new JLabel(new ImageIcon("C:/Program Files/Airport Database/air.jpg")));
		eCDialog.setVisible(true);
		Container ec = eCDialog.getContentPane();
		eCDialog.setSize(630,250);
        eCDialog.setTitle("Check the Data of Tickets");
		eCDialog.setLocationRelativeTo(window);
		ec.setLayout(null);
        JLabel ecEmp=new JLabel("Enter the Flight Number:");
        ecEmp.setBounds(70, 70, 200, 25);
        ec.add(ecEmp);
        JTextField ecTEmp=new JTextField(30);
        ecTEmp.setBounds(290, 70, 200, 25);
        ec.add(ecTEmp);
        JButton ok=new JButton("ok");
        ok.setBounds(290, 100,50, 25);
        ec.add(ok);
        ok.setToolTipText("Press ok to Check the record of Tickets");
        ok.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
                String id=ecTEmp.getText();
                try
                {
                    buR=new BufferedReader(new FileReader("C:\\Users\\Public\\Documents\\AirportData\\Files\\ticketData.txt"));
                    String l="";
                    while((l=buR.readLine())!=null)
                    {
                        String eArr[]=l.split("-");
                        eCDialog.setVisible(false);
                        if(eArr[0].equals(id))
                        {
                            
                            
                            JDialog echkDialog=new JDialog();
                            echkDialog.setContentPane(new JLabel(new ImageIcon("C:/Program Files/Airport Database/air.jpg")));
                            echkDialog.setVisible(true);
                            Container c=echkDialog.getContentPane();
                            echkDialog.setSize(400,500);
                            echkDialog.setTitle("Check The Data of Tickets");
                            echkDialog.setLocationRelativeTo(window);
                            c.setLayout(null);
                            
                            JLabel lNumTic=new JLabel("Number of Tickets:");
                            lNumTic.setBounds(80, 80, 180, 25);
                            c.add(lNumTic);
                            JLabel lONumTic=new JLabel(eArr[1]);
                            lONumTic.setBounds(200, 80, 180, 25);
                            c.add(lONumTic);
                            
                            JLabel eID=new JLabel("Reserved Tickets:");
                            eID.setBounds(80, 120, 180, 25);
                            c.add(eID);
                            JLabel eOID=new JLabel(eArr[2]);
                            eOID.setBounds(200, 120, 180, 25);
                            c.add(eOID);
                            
                            JLabel lFlNum=new JLabel("Flight Number:");
                            lFlNum.setBounds(80, 160, 180, 25);
                            c.add(lFlNum);
                            JLabel lOFlNum=new JLabel(eArr[0]);
                            lOFlNum.setBounds(200, 160, 180, 25);
                            c.add(lOFlNum);
                            
                            JLabel eEOID=new JLabel("Available Tickets:");
                            eEOID.setBounds(80, 200, 180, 25);
                            c.add(eEOID);
                            JLabel eOOID=new JLabel(eArr[3]);
                            eOOID.setBounds(200, 200, 180, 25);
                            c.add(eOOID);
                            
                            JButton eOK=new JButton("ok");
                            eOK.setBounds(200, 360, 50, 25);
                            c.add(eOK);
                            eOK.setToolTipText("Exit the Output Dialog");
                            eOK.addActionListener(new ActionListener()
                            {
                                public void actionPerformed(ActionEvent ae)
                                {
                                    echkDialog.setVisible(false);
                                }
                            }
                            );
                           
                        }
                        else
                        {
                            //JOptionPane.showMessageDialog(null,"The Data of the ticket ID is not Found!");
                        }
                    }
                    buR.close();
                }
                catch(IOException io)
                {
                    JOptionPane.showMessageDialog(null,"Input Output Error during File Reading");
                }
                
                
            }
        }
        );
        
        JButton eCancel=new JButton("Cancel");
         eCancel.setBounds(350, 100, 80, 25);
         ec.add(eCancel);
         eCancel.setToolTipText("Cancel The Dialog Box");
         eCancel.addActionListener(new ActionListener()
         {
            public void actionPerformed(ActionEvent ae)
            {
                eCDialog.setVisible(false);             
            }
         }
         );
        
        
    }
    
}