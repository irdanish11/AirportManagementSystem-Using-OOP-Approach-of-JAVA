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
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.io.*;
import java.util.*;
import javax.swing.*;//
public class cateringManagment
{
    BufferedReader buR;
    public PrintWriter ePW=null;
    public void addCat(JFrame window)
    {
    
    
        JDialog eDialog = new JDialog();
        eDialog.setContentPane(new JLabel(new ImageIcon("C:/Program Files/Airport Database/air.jpg")));
		eDialog.setVisible(true);
		Container c = eDialog.getContentPane();
		eDialog.setSize(705, 630);
        eDialog.setTitle("Add's the Food Menu for a Flight");
		eDialog.setLocationRelativeTo(window);
		c.setLayout(null);
        
         JLabel laEmNam=new JLabel("Enter the Name of Food Menu:");
         laEmNam.setBounds(180, 210, 180, 25);
         c.add(laEmNam);
         JTextField tEmNam=new JTextField(30);
         tEmNam.setBounds(370, 210, 180, 25);
         c.add(tEmNam);
        
         JLabel laEmId=new JLabel("Enter the ID of Food Item:");
         laEmId.setBounds(180, 250, 160, 25);
         c.add(laEmId);
         JTextField tEmId=new JTextField(30);
         tEmId.setBounds(370, 250, 180, 25);
         c.add(tEmId);
         
         JLabel laEmCId=new JLabel("Enter the Flight Number:");
         laEmCId.setBounds(180, 330, 160, 25);
         c.add(laEmCId);
         JTextField tEmCId=new JTextField(30);
         tEmCId.setBounds(370, 330, 180, 25);
         c.add(tEmCId);
         
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
                         
                         try
                         {
                            
                             ePW=new PrintWriter(new FileOutputStream("C:\\Users\\Public\\Documents\\AirportData\\Files\\cateringData.txt",true));
                             String emData=nam+"-"+id+"-"+cid;
                             ePW.println(emData);
                             ePW.flush();
                             ePW.close();
                             JOptionPane.showMessageDialog(null, "The Record of the Catering has been added successfully");
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
    
    
    
    public void chkCat(JFrame window)
    {
        
        
        JDialog eCDialog = new JDialog();
        eCDialog.setContentPane(new JLabel(new ImageIcon("C:/Program Files/Airport Database/air.jpg")));
		eCDialog.setVisible(true);
		Container ec = eCDialog.getContentPane();
		eCDialog.setSize(630,250);
        eCDialog.setTitle("Check the Data of Catering");
		eCDialog.setLocationRelativeTo(window);
		ec.setLayout(null);
        JLabel ecEmp=new JLabel("Enter the ID of Food Menu:");
        ecEmp.setBounds(70, 70, 200, 25);
        ec.add(ecEmp);
        JTextField ecTEmp=new JTextField(30);
        ecTEmp.setBounds(290, 70, 200, 25);
        ec.add(ecTEmp);
        JButton ok=new JButton("ok");
        ok.setBounds(290, 100,50, 25);
        ec.add(ok);
        ok.setToolTipText("Press ok to Check the record of Food Menu");
        ok.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
                String id=ecTEmp.getText();
                try
                {
                    buR=new BufferedReader(new FileReader("C:\\Users\\Public\\Documents\\AirportData\\Files\\cateringData.txt"));
                    String l="";
                    while((l=buR.readLine())!=null)
                    {
                        String eArr[]=l.split("-");
                        
                        if(eArr[1].equals(id))
                        {
                            /*Shows the output dialog*/
                            eCDialog.setVisible(false);
                            JDialog echkDialog=new JDialog();
                            echkDialog.setContentPane(new JLabel(new ImageIcon("C:/Program Files/Airport Database/air.jpg")));
                            echkDialog.setVisible(true);
                            Container c=echkDialog.getContentPane();
                            echkDialog.setSize(400,500);
                            echkDialog.setTitle("Check The Data of Food Menu");
                            echkDialog.setLocationRelativeTo(window);
                            c.setLayout(null);
                            
                            JLabel eNam=new JLabel("Name of Food Menu:");
                            eNam.setBounds(80, 80, 180, 25);
                            c.add(eNam);
                            JLabel eONam=new JLabel(eArr[0]);
                            eONam.setBounds(200, 80, 180, 25);
                            c.add(eONam);
                            
                            JLabel eID=new JLabel("ID of Food Menu:");
                            eID.setBounds(80, 120, 180, 25);
                            c.add(eID);
                            JLabel eOID=new JLabel(eArr[1]);
                            eOID.setBounds(200, 120, 180, 25);
                            c.add(eOID);
                            
                            JLabel eEOID=new JLabel("Flight Number:");
                            eEOID.setBounds(80, 200, 180, 25);
                            c.add(eEOID);
                            JLabel eOOID=new JLabel(eArr[2]);
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
                            JOptionPane.showMessageDialog(null,"The Data of the Food ID is not Found!");
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
    
    public void delCat(JFrame window)
    {
        JDialog edelDialog = new JDialog();
        edelDialog.setContentPane(new JLabel(new ImageIcon("C:/Program Files/Airport Database/air.jpg")));
		edelDialog.setVisible(true);
		Container c = edelDialog.getContentPane();
		edelDialog.setSize(630,250);
        edelDialog.setTitle("Delete the Data of Food Menu");
		edelDialog.setLocationRelativeTo(window);
		c.setLayout(null);
        
        JLabel dPass=new JLabel("Enter the ID Number of Food Menu:");
        dPass.setBounds(70, 70, 200, 25);
        c.add(dPass);
        JTextField dTPass=new JTextField(30);
        dTPass.setBounds(290, 70, 200, 25);
        c.add(dTPass);
        JButton dButton=new JButton("ok");
        dButton.setBounds(290, 100,50, 25);
        c.add(dButton);
        dButton.setToolTipText("Press ok to delete the Record!");
        dButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
                if(dTPass.getText().isEmpty())
                {
                    edelDialog.setVisible(true);
					JOptionPane.showMessageDialog(null, "Empty Fields,Please Enter Valid ID");
                }
                else
                {
                    String id=dTPass.getText();
                    
                    try
                    {
                       BufferedReader dBr=new BufferedReader(new FileReader("C:\\Users\\Public\\Documents\\AirportData\\Files\\cateringData.txt"));
                    StringBuffer sBu=new StringBuffer();
                    
                    String line,nline;
                    while((line=dBr.readLine())!=null)
                    {
                        if(line.contains(id))
                        {
                            nline=line.replace(line,"");
                            line=nline;
                        }
                        if(line.equals(""))
                        {
                            
                        }
                        else
                        {
                            sBu.append(line+"\n");
                            edelDialog.setVisible(true);
                            JOptionPane.showMessageDialog(null, "Data Relative to ID is not Found");
                            break;
                        }
                    }
                    dBr.close();
                    FileWriter f=new FileWriter(new File("C:\\Users\\Public\\Documents\\AirportData\\Files\\cateringData.txt"),false);
                    PrintWriter p=new PrintWriter(f);
                    p.print(sBu.toString());
                    f.flush();
                    f.close();
                    JOptionPane.showMessageDialog(null, "The Data has been deleted successfully");
                    edelDialog.setVisible(false);
                    }
                    
                    catch(IOException e)
                    {
                        edelDialog.setVisible(true);
                        JOptionPane.showMessageDialog(null, "Input Output error during file Reading");
                    }
                    
                }
            }
        }
        );
        
        JButton eCancel=new JButton("Cancel");
        eCancel.setBounds(350, 100, 80, 25);
        c.add(eCancel);
        eCancel.setToolTipText("Cancel The Dialog Box");
        eCancel.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
                edelDialog.setVisible(false);
                                    
            }
         }
         );
        
    }
}