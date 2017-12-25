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
import javax.swing.JLabel;//
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.io.*;
import java.util.*;
import javax.swing.*;
public class secData
{
    BufferedReader buR;
    public FileWriter pFW=null;
    public PrintWriter pPW=null;
    public void addSecData(JFrame mainframe)
    {
        JDialog pDialog = new JDialog();
        pDialog.setContentPane(new JLabel(new ImageIcon("C:/Program Files/Airport Database/air.jpg")));
		pDialog.setVisible(true);
		Container c = pDialog.getContentPane();
		pDialog.setSize(765, 730);
        pDialog.setTitle("Add the Data of Security Personal");
		pDialog.setLocationRelativeTo(mainframe);
		c.setLayout(null);
        
         JLabel laPaNam=new JLabel("Security Employe:");
         laPaNam.setBounds(180, 210, 180, 25);
         c.add(laPaNam);
         JTextField tPaNam=new JTextField(30);
         tPaNam.setBounds(370, 210, 180, 25);
         c.add(tPaNam);
        
         JLabel laPaId=new JLabel("ID of Security Employe:");
         laPaId.setBounds(180, 250, 160, 25);
         c.add(laPaId);
         JTextField tPaId=new JTextField(30);
         tPaId.setBounds(370, 250, 180, 25);
         c.add(tPaId);
         
         JLabel laPaFl=new JLabel("Enter the Phone Number:");
         laPaFl.setBounds(180, 290, 160, 25);
         c.add(laPaFl);
         JTextField tPaFl=new JTextField(30);
         tPaFl.setBounds(370, 290, 180, 25);
         c.add(tPaFl);
         
         JLabel laPaAi=new JLabel("Enter the Address:");
         laPaAi.setBounds(180, 330, 160, 25);
         c.add(laPaAi);
         JTextField tPaAi=new JTextField(30);
         tPaAi.setBounds(370, 330, 180, 25);
         c.add(tPaAi);
         
         JLabel laPatm=new  JLabel("Hours of Working HH:MM/HH:MM");
         laPatm.setBounds(180, 370, 160, 25);
         c.add(laPatm);
         JTextField tPatm=new JTextField(30);
         tPatm.setBounds(370, 370, 180, 25);
         c.add(tPatm);
         
         
         JButton bOK=new JButton("ok");
         bOK.setBounds(370, 450, 50, 25);
         c.add(bOK);
         bOK.setToolTipText("Press OK to Save Data");
         bOK.addActionListener(new ActionListener()
             {
                 public void actionPerformed(ActionEvent ae)
                 {
                     
                     if(tPaNam.getText().isEmpty()||tPaAi.getText().isEmpty()||tPatm.getText().isEmpty()||tPaFl.getText().isEmpty()||tPaId.getText().isEmpty())
                     {
                            pDialog.setVisible(true);
							JOptionPane.showMessageDialog(null, "Complete all the Text Fields");
                     }
                     else
                     {
                         String nam=tPaNam.getText();
                         String id=tPaId.getText();
                         String ai=tPaAi.getText();
                         String fl=tPaFl.getText();
                         String tm=tPatm.getText();
                         
                         try
                         {
                            // pFW=new FileWriter(new File("passangerData.txt"));
                             pPW=new PrintWriter(new FileOutputStream("C:\\Users\\Public\\Documents\\AirportData\\Files\\securityData.txt",true));
                             String paData=nam+"-"+id+"-"+ai+"-"+fl+"-"+tm;
                             pPW.println(paData);
                             pPW.flush();
                             pPW.close();
                             JOptionPane.showMessageDialog(null, "The Record of the Security Employe has been added successfully");
                             pDialog.setVisible(false);
                         }
                         catch(FileNotFoundException e)
                         {
                             pDialog.setVisible(true);
                             JOptionPane.showMessageDialog(null, "File not found!");
                         }
                         
                     }
                     
                 }
             }
         );
         
         JButton pCancel=new JButton("Cancel");
         pCancel.setBounds(430, 450, 80, 25);
         c.add(pCancel);
         pCancel.setToolTipText("Cancel The Dialog Box");
         pCancel.addActionListener(new ActionListener()
         {
            public void actionPerformed(ActionEvent ae)
            {
                pDialog.setVisible(false);                
            }
         }
         );
         
    }//end of method addPassangerData()
    
    public void chkSecurity(JFrame window)
    {
        
       JDialog pCDialog = new JDialog();
       pCDialog.setContentPane(new JLabel(new ImageIcon("C:/Program Files/Airport Database/air.jpg")));
		pCDialog.setVisible(true);
		Container pc = pCDialog.getContentPane();
		pCDialog.setSize(630,250);
        pCDialog.setTitle("Check the Data of Security Data");
		pCDialog.setLocationRelativeTo(window);
		pc.setLayout(null);
        JLabel pcEmp=new JLabel("ID Number of Security Personal:");
        pcEmp.setBounds(70, 70, 200, 25);
        pc.add(pcEmp);
        JTextField pcTPas=new JTextField(30);
        pcTPas.setBounds(290, 70, 200, 25);
        pc.add(pcTPas);
        JButton ok=new JButton("ok");
        ok.setBounds(290, 100,50, 25);
        pc.add(ok);
        ok.setToolTipText("Press ok to Check the record of Security Personal");
        ok.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
                String id=pcTPas.getText();
                try
                {
                    buR=new BufferedReader(new FileReader("C:\\Users\\Public\\Documents\\AirportData\\Files\\securityData.txt"));
                    String l="";
                    while((l=buR.readLine())!=null)
                    {
                        String pArr[]=l.split("-");
                       
                        
                        if(pArr[1].equals(id))
                        {
                            
                            
                            
                            /*Shows the output dialog*/
                            pCDialog.setVisible(false);
                            JDialog pchkDialog=new JDialog();
                            pchkDialog.setContentPane(new JLabel(new ImageIcon("C:/Program Files/Airport Database/air.jpg")));
                            pchkDialog.setVisible(true);
                            Container c=pchkDialog.getContentPane();
                            pchkDialog.setSize(400,500);
                            pchkDialog.setTitle("Check The Data of Passanger");
                            pchkDialog.setLocationRelativeTo(window);
                            c.setLayout(null);
                            
                            JLabel pNam=new JLabel("Name :");
                            pNam.setBounds(80, 80, 180, 25);
                            c.add(pNam);
                            JLabel pONam=new JLabel(pArr[0]);
                            pONam.setBounds(200, 80, 180, 25);
                            c.add(pONam);
                            
                            JLabel pID=new JLabel("ID of Employe:");
                            pID.setBounds(80, 120, 180, 25);
                            c.add(pID);
                            JLabel pOID=new JLabel(pArr[1]);
                            pOID.setBounds(200, 120, 180, 25);
                            c.add(pOID);
                            
                            JLabel pDep=new JLabel("Phone  Number");
                            pDep.setBounds(80, 160, 180, 25);
                            c.add(pDep);
                            JLabel pODep=new JLabel(pArr[3]);
                            pODep.setBounds(200, 160, 180, 25);
                            c.add(pODep);
                            
                            JLabel pDOJ=new JLabel("Address:");
                            pDOJ.setBounds(80, 200, 180, 25);
                            c.add(pDOJ);
                            JLabel pODOJ=new JLabel(pArr[2]);
                            pODOJ.setBounds(200, 200, 180, 25);
                            c.add(pODOJ);
                            
                            JLabel pHoW=new JLabel("Hours of Working:");
                            pHoW.setBounds(80, 240, 180, 25);
                            c.add(pHoW);
                            JLabel pOHoW=new JLabel(pArr[4]);
                            pOHoW.setBounds(200, 240, 180, 25);
                            c.add(pOHoW);
                            
                            JButton pOK=new JButton("ok");
                            pOK.setBounds(200, 320, 50, 25);
                            c.add(pOK);
                            pOK.setToolTipText("Exit the Output Dialog");
                            pOK.addActionListener(new ActionListener()
                            {
                                public void actionPerformed(ActionEvent ae)
                                {
                                    pchkDialog.setVisible(false);
                                }
                            }
                            );
                           
                        }
                        else
                        {
                            //JOptionPane.showMessageDialog(null,"The Data of the ID is not Found!");
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
        
        JButton pCancel=new JButton("Cancel");
         pCancel.setBounds(350, 100, 80, 25);
         pc.add(pCancel);
         pCancel.setToolTipText("Cancel The Dialog Box");
         pCancel.addActionListener(new ActionListener()
         {
            public void actionPerformed(ActionEvent ae)
            {
                pCDialog.setVisible(false);             
            }
         }
         );
        
    }//end of method chkPass()
    
    public void delSecurity(JFrame window)
    {
        JDialog pdelDialog = new JDialog();
        pdelDialog.setContentPane(new JLabel(new ImageIcon("C:/Program Files/Airport Database/air.jpg")));
		pdelDialog.setVisible(true);
		Container c = pdelDialog.getContentPane();
		pdelDialog.setSize(630,250);
        pdelDialog.setTitle("Delete the Data of Security Employe");
		pdelDialog.setLocationRelativeTo(window);
		c.setLayout(null);
        
        JLabel dPass=new JLabel("ID Number:");
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
                    pdelDialog.setVisible(true);
					JOptionPane.showMessageDialog(null, "Empty Fields,Please Enter Valid ID");
                }
                else
                {
                    String id=dTPass.getText();
                    
                    try
                    {
                        BufferedReader dBr=new BufferedReader(new FileReader("C:\\Users\\Public\\Documents\\AirportData\\Files\\securityData.txt"));
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
                            pdelDialog.setVisible(true);
                            //JOptionPane.showMessageDialog(null, "Data Relative to ID is not Found");
                            break;
                        }
                    }
                    dBr.close();
                    FileWriter f=new FileWriter(new File("C:\\Users\\Public\\Documents\\AirportData\\Files\\securityData.txt"),false);
                    PrintWriter p=new PrintWriter(f);
                    p.print(sBu.toString());
                    f.flush();
                    f.close();
                    JOptionPane.showMessageDialog(null, "The Data has been deleted successfully");
                    pdelDialog.setVisible(false);
                    }
                    
                    catch(IOException e)
                    {
                        pdelDialog.setVisible(true);
                        JOptionPane.showMessageDialog(null, "Input Output error during file Reading");
                    }
                    
                }
            }
        }
        );
        
        JButton pCancel=new JButton("Cancel");
        pCancel.setBounds(350, 100, 80, 25);
        c.add(pCancel);
        pCancel.setToolTipText("Cancel The Dialog Box");
        pCancel.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
                pdelDialog.setVisible(false);
                                    
            }
         }
         );
        
    }// end of method delPass().
}