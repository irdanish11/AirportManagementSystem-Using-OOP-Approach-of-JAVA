import java.awt.*;
import java.io.*;
import java.util.*;
import javax.swing.*;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.GridLayout;
import java.awt.Font;
import javax.swing.ImageIcon;//
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
import javax.swing.*;
public class employeData
{
    BufferedReader buR;
    public PrintWriter ePW=null; //to keep compiler happy
    public void addEmp(JFrame window)
    {
    
    
        JDialog eDialog = new JDialog();
        eDialog.setContentPane(new JLabel(new ImageIcon("C:/Program Files/Airport Database/air.jpg")));
		eDialog.setVisible(true);
		Container c = eDialog.getContentPane();
		eDialog.setSize(705, 630);
        eDialog.setTitle("Add the Data of Employees");
		eDialog.setLocationRelativeTo(window);
		c.setLayout(null);
        
         JLabel laEmNam=new JLabel("Enter the Name of Employee:");
         laEmNam.setBounds(180, 210, 180, 25);
         c.add(laEmNam);
         JTextField tEmNam=new JTextField(30);
         tEmNam.setBounds(370, 210, 180, 25);
         c.add(tEmNam);
        
         JLabel laEmId=new JLabel("Enter the ID of Employee:");
         laEmId.setBounds(180, 250, 160, 25);
         c.add(laEmId);
         JTextField tEmId=new JTextField(30);
         tEmId.setBounds(370, 250, 180, 25);
         c.add(tEmId);
         
         JLabel laEmDe=new JLabel("Enter the Department:");
         laEmDe.setBounds(180, 290, 160, 25);
         c.add(laEmDe);
         JTextField tEmDe=new JTextField(30);
         tEmDe.setBounds(370, 290, 180, 25);
         c.add(tEmDe);
         
         JLabel laEmCId=new JLabel("Enter the Organizational ID:");
         laEmCId.setBounds(180, 330, 160, 25);
         c.add(laEmCId);
         JTextField tEmCId=new JTextField(30);
         tEmCId.setBounds(370, 330, 180, 25);
         c.add(tEmCId);
         
         JLabel laEmDt=new  JLabel("Enter the Date of Joining:");
         laEmDt.setBounds(180, 370, 160, 25);
         c.add(laEmDt);
         JTextField tEmDt=new JTextField(30);
         tEmDt.setBounds(370, 370, 180, 25);
         c.add(tEmDt);
         
         JLabel laEmTm=new JLabel("Enter the Hours of Working:");
         laEmTm.setBounds(180, 410, 160, 25);
         c.add(laEmTm);
         JTextField tEmTm=new JTextField(30);
         tEmTm.setBounds(370, 410, 180, 25);
         c.add(tEmTm);
         
         JLabel laEmSa=new JLabel("Enter the Salary:");
         laEmSa.setBounds(180, 450, 160, 25);
         c.add(laEmSa);
         JTextField tEmSa=new JTextField(30);
         tEmSa.setBounds(370, 450, 180, 25);
         c.add(tEmSa);
         
         JButton bOK=new JButton("ok");
         bOK.setBounds(370, 490, 50, 25);
         c.add(bOK);
         bOK.setToolTipText("Press OK to Save Data");
         bOK.addActionListener(new ActionListener()
             {
                 public void actionPerformed(ActionEvent ae)
                 {
                     
                     if(tEmNam.getText().isEmpty()||tEmCId.getText().isEmpty()||tEmDe.getText().isEmpty()||tEmDt.getText().isEmpty()||tEmId.getText().isEmpty()||tEmSa.getText().isEmpty()||tEmTm.getText().isEmpty())
                     {
                            eDialog.setVisible(true);
							JOptionPane.showMessageDialog(null, "Complete all the Text Fields");
                     }
                     else
                     {
                         String nam=tEmNam.getText();
                         String id=tEmId.getText();
                         String de=tEmDe.getText();
                         String cid=tEmCId.getText();
                         String dt=tEmDt.getText();
                         String tm=tEmTm.getText();
                         String sa=tEmSa.getText();
                         
                         try
                         {
                            
                             ePW=new PrintWriter(new FileOutputStream("C:\\Users\\Public\\Documents\\AirportData\\Files\\employeData.txt",true));
                             String emData=nam+"-"+id+"-"+de+"-"+cid+"-"+dt+"-"+tm+"-"+sa;
                             ePW.println(emData);
                             ePW.flush();
                             ePW.close();
                             JOptionPane.showMessageDialog(null, "The Record of the Employee has been added successfully");
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
    
    
    
    public void chkEmp(JFrame window)
    {
        
        
        JDialog eCDialog = new JDialog();
        eCDialog.setContentPane(new JLabel(new ImageIcon("C:/Program Files/Airport Database/air.jpg")));
		eCDialog.setVisible(true);
		Container ec = eCDialog.getContentPane();
		eCDialog.setSize(630,250);
        eCDialog.setTitle("Check the Data of Employee");
		eCDialog.setLocationRelativeTo(window);
		ec.setLayout(null);
        JLabel ecEmp=new JLabel("Enter the ID Number of Employee:");
        ecEmp.setBounds(70, 70, 200, 25);
        ec.add(ecEmp);
        JTextField ecTEmp=new JTextField(30);
        ecTEmp.setBounds(290, 70, 200, 25);
        ec.add(ecTEmp);
        JButton ok=new JButton("ok");
        ok.setBounds(290, 100,50, 25);
        ec.add(ok);
        ok.setToolTipText("Press ok to Check the record of Employee");
        ok.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
                String id=ecTEmp.getText();
                try
                {
                    buR=new BufferedReader(new FileReader("C:\\Users\\Public\\Documents\\AirportData\\Files\\employeData.txt"));
                    String l="";
                    while((l=buR.readLine())!=null)
                    {
                        String eArr[]=l.split("-");
                        
                        
                        if(eArr[1].equals(id))
                        {
                            
                            
                            System.out.println("equal");
                            /*Shows the output dialog*/
                            eCDialog.setVisible(false);
                            JDialog echkDialog=new JDialog();
                            echkDialog.setContentPane(new JLabel(new ImageIcon("C:/Program Files/Airport Database/air.jpg")));
                            echkDialog.setVisible(true);
                            Container c=echkDialog.getContentPane();
                            echkDialog.setSize(400,500);
                            echkDialog.setTitle("Check The Data of Employee");
                            echkDialog.setLocationRelativeTo(window);
                            c.setLayout(null);
                            
                            JLabel eNam=new JLabel("Name of Employee:");
                            eNam.setBounds(80, 80, 180, 25);
                            c.add(eNam);
                            JLabel eONam=new JLabel(eArr[0]);
                            eONam.setBounds(200, 80, 180, 25);
                            c.add(eONam);
                            
                            JLabel eID=new JLabel("ID of Employee:");
                            eID.setBounds(80, 120, 180, 25);
                            c.add(eID);
                            JLabel eOID=new JLabel(eArr[1]);
                            eOID.setBounds(200, 120, 180, 25);
                            c.add(eOID);
                            
                            JLabel eDep=new JLabel("Department:");
                            eDep.setBounds(80, 160, 180, 25);
                            c.add(eDep);
                            JLabel eODep=new JLabel(eArr[2]);
                            eODep.setBounds(200, 160, 180, 25);
                            c.add(eODep);
                            
                            JLabel eEOID=new JLabel("Organizational ID:");
                            eEOID.setBounds(80, 200, 180, 25);
                            c.add(eEOID);
                            JLabel eOOID=new JLabel(eArr[3]);
                            eOOID.setBounds(200, 200, 180, 25);
                            c.add(eOOID);
                            
                            JLabel eDOJ=new JLabel("Date of Joining:");
                            eDOJ.setBounds(80, 280, 180, 25);
                            c.add(eDOJ);
                            JLabel eODOJ=new JLabel(eArr[4]);
                            eODOJ.setBounds(200, 280, 180, 25);
                            c.add(eODOJ);
                            
                            JLabel eHoW=new JLabel("Hours of Working:");
                            eHoW.setBounds(80, 240, 180, 25);
                            c.add(eHoW);
                            JLabel eOHoW=new JLabel(eArr[5]);
                            eOHoW.setBounds(200, 240, 180, 25);
                            c.add(eOHoW);
                            
                            JLabel eSal=new JLabel("Salary:");
                            eSal.setBounds(80, 320, 180, 25);
                            c.add(eSal);
                            JLabel eOSal=new JLabel(eArr[6]);
                            eOSal.setBounds(200, 320, 180, 25);
                            c.add(eOSal);
                            
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
                            JOptionPane.showMessageDialog(null,"The Data of the ID is not Found!");
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
    public void delEmp(JFrame window)
    {
        JDialog edelDialog = new JDialog();
        edelDialog.setContentPane(new JLabel(new ImageIcon("C:/Program Files/Airport Database/air.jpg")));
		edelDialog.setVisible(true);
		Container c = edelDialog.getContentPane();
		edelDialog.setSize(630,250);
        edelDialog.setTitle("Delete the Data of Employee");
		edelDialog.setLocationRelativeTo(window);
		c.setLayout(null);
        
        JLabel dPass=new JLabel("Enter the ID Number of Employee:");
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
                       BufferedReader dBr=new BufferedReader(new FileReader("C:\\Users\\Public\\Documents\\AirportData\\Files\\employeData.txt"));
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
                    FileWriter f=new FileWriter(new File("C:\\Users\\Public\\Documents\\AirportData\\Files\\employeData.txt"),false);
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
    
    public void modEmployee(JFrame window)
    {
        JDialog edelDialog = new JDialog();
        edelDialog.setContentPane(new JLabel(new ImageIcon("C:/Program Files/Airport Database/air.jpg")));
		edelDialog.setVisible(true);
		Container c = edelDialog.getContentPane();
		edelDialog.setSize(630,250);
        edelDialog.setTitle("Delete the Data of Employee");
		edelDialog.setLocationRelativeTo(window);
		c.setLayout(null);
        
        JLabel dPass=new JLabel("Enter the ID Number of Employee:");
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
                       BufferedReader dBr=new BufferedReader(new FileReader("C:\\Users\\Public\\Documents\\AirportData\\Files\\employeData.txt"));
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
                    FileWriter f=new FileWriter(new File("C:\\Users\\Public\\Documents\\AirportData\\Files\\employeData.txt"),false);
                    PrintWriter p=new PrintWriter(f);
                    p.print(sBu.toString());
                    f.flush();
                    f.close();
                    //JOptionPane.showMessageDialog(null, "The Data has been deleted successfully");
                    edelDialog.setVisible(false);
                    
                    /* Witing Data*/
         JDialog eDialog = new JDialog();
         eDialog.setContentPane(new JLabel(new ImageIcon("C:/Program Files/Airport Database/air.jpg")));
		eDialog.setVisible(true);
		eDialog.setSize(705, 630);
        Container e = eDialog.getContentPane();
        eDialog.setTitle("Add the Data of Employees");
		eDialog.setLocationRelativeTo(window);
		e.setLayout(null);
        
         JLabel laEmNam=new JLabel("Enter the Name of Employee:");
         laEmNam.setBounds(180, 210, 180, 25);
         e.add(laEmNam);
         JTextField tEmNam=new JTextField(30);
         tEmNam.setBounds(370, 210, 180, 25);
         e.add(tEmNam);
        
         JLabel laEmId=new JLabel("Enter the ID of Employee:");
         laEmId.setBounds(180, 250, 160, 25);
         e.add(laEmId);
         JTextField tEmId=new JTextField(30);
         tEmId.setBounds(370, 250, 180, 25);
         e.add(tEmId);
         
         JLabel laEmDe=new JLabel("Enter the Department:");
         laEmDe.setBounds(180, 290, 160, 25);
         e.add(laEmDe);
         JTextField tEmDe=new JTextField(30);
         tEmDe.setBounds(370, 290, 180, 25);
         e.add(tEmDe);
         
         JLabel laEmCId=new JLabel("Enter the Organizational ID:");
         laEmCId.setBounds(180, 330, 160, 25);
         e.add(laEmCId);
         JTextField tEmCId=new JTextField(30);
         tEmCId.setBounds(370, 330, 180, 25);
         e.add(tEmCId);
         
         JLabel laEmDt=new  JLabel("Enter the Date of Joining:");
         laEmDt.setBounds(180, 370, 160, 25);
         e.add(laEmDt);
         JTextField tEmDt=new JTextField(30);
         tEmDt.setBounds(370, 370, 180, 25);
         e.add(tEmDt);
         
         JLabel laEmTm=new JLabel("Enter the Hours of Working:");
         laEmTm.setBounds(180, 410, 160, 25);
         e.add(laEmTm);
         JTextField tEmTm=new JTextField(30);
         tEmTm.setBounds(370, 410, 180, 25);
         e.add(tEmTm);
         
         JLabel laEmSa=new JLabel("Enter the Salary:");
         laEmSa.setBounds(180, 450, 160, 25);
         e.add(laEmSa);
         JTextField tEmSa=new JTextField(30);
         tEmSa.setBounds(370, 450, 180, 25);
         e.add(tEmSa);
         
         JButton bOK=new JButton("ok");
         bOK.setBounds(370, 490, 50, 25);
         e.add(bOK);
         bOK.setToolTipText("Press OK to Save Data");
         bOK.addActionListener(new ActionListener()
             {
                 public void actionPerformed(ActionEvent ae)
                 {
                     
                     if(tEmNam.getText().isEmpty()||tEmCId.getText().isEmpty()||tEmDe.getText().isEmpty()||tEmDt.getText().isEmpty()||tEmId.getText().isEmpty()||tEmSa.getText().isEmpty()||tEmTm.getText().isEmpty())
                     {
                            eDialog.setVisible(true);
							JOptionPane.showMessageDialog(null, "Complete all the Text Fields");
                     }
                     else
                     {
                         String nam=tEmNam.getText();
                         String id=tEmId.getText();
                         String de=tEmDe.getText();
                         String cid=tEmCId.getText();
                         String dt=tEmDt.getText();
                         String tm=tEmTm.getText();
                         String sa=tEmSa.getText();
                         
                         try
                         {
                            
                             ePW=new PrintWriter(new FileOutputStream("C:\\Users\\Public\\Documents\\AirportData\\Files\\employeData.txt",true));
                             String emData=nam+"-"+id+"-"+de+"-"+cid+"-"+dt+"-"+tm+"-"+sa;
                             ePW.println(emData);
                             ePW.flush();
                             ePW.close();
                             JOptionPane.showMessageDialog(null, "The Record of the Employee has been added successfully");
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
         
         
    }
}