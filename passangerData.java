import java.awt.*;
import java.io.*;
import java.util.*;
import javax.swing.*;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.GridLayout;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;//
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
public class passangerData
{
    BufferedReader buR;
    public FileWriter pFW=null;
    public PrintWriter pPW=null;
    public void addPassangerData(JFrame mainframe)
    {
        JDialog pDialog = new JDialog();
        pDialog.setContentPane(new JLabel(new ImageIcon("C:/Program Files/Airport Database/air.jpg")));
		pDialog.setVisible(true);
		Container c = pDialog.getContentPane();
		pDialog.setSize(765, 730);
        pDialog.setTitle("Add the Data of Passanger");
		pDialog.setLocationRelativeTo(mainframe);
		c.setLayout(null);
        
         JLabel laPaNam=new JLabel("Enter the Name of Passanger:");
         laPaNam.setBounds(180, 210, 180, 25);
         c.add(laPaNam);
         JTextField tPaNam=new JTextField(30);
         tPaNam.setBounds(370, 210, 180, 25);
         c.add(tPaNam);
        
         JLabel laPaId=new JLabel("Enter the ID of Passanger:");
         laPaId.setBounds(180, 250, 160, 25);
         c.add(laPaId);
         JTextField tPaId=new JTextField(30);
         tPaId.setBounds(370, 250, 180, 25);
         c.add(tPaId);
         
         JLabel laPaFl=new JLabel("Enter the Flight Number:");
         laPaFl.setBounds(180, 290, 160, 25);
         c.add(laPaFl);
         JTextField tPaFl=new JTextField(30);
         tPaFl.setBounds(370, 290, 180, 25);
         c.add(tPaFl);
         
         JLabel laPaAi=new JLabel("Enter the Airline:");
         laPaAi.setBounds(180, 330, 160, 25);
         c.add(laPaAi);
         JTextField tPaAi=new JTextField(30);
         tPaAi.setBounds(370, 330, 180, 25);
         c.add(tPaAi);
         
         JLabel laPaDt=new  JLabel("Enter the Date");
         laPaDt.setBounds(180, 370, 160, 25);
         c.add(laPaDt);
         JTextField tPaDt=new JTextField(30);
         tPaDt.setBounds(370, 370, 180, 25);
         c.add(tPaDt);
         
         JLabel laPaTm=new JLabel("Enter the time of Flight");
         laPaTm.setBounds(180, 410, 160, 25);
         c.add(laPaTm);
         JTextField tPaTm=new JTextField(30);
         tPaTm.setBounds(370, 410, 180, 25);
         c.add(tPaTm);
         
         JButton bOK=new JButton("ok");
         bOK.setBounds(370, 450, 50, 25);
         c.add(bOK);
         bOK.setToolTipText("Press OK to Save Data");
         bOK.addActionListener(new ActionListener()
             {
                 public void actionPerformed(ActionEvent ae)
                 {
                     
                     if(tPaNam.getText().isEmpty()||tPaAi.getText().isEmpty()||tPaDt.getText().isEmpty()||tPaFl.getText().isEmpty()||tPaId.getText().isEmpty()||tPaTm.getText().isEmpty())
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
                         String dt=tPaDt.getText();
                         String tm=tPaTm.getText();
                         
                         try
                         {
                            // pFW=new FileWriter(new File("passangerData.txt"));
                             pPW=new PrintWriter(new FileOutputStream("C:\\Users\\Public\\Documents\\AirportData\\Files\\PassangerData.txt",true));
                             String paData=nam+"-"+id+"-"+ai+"-"+fl+"-"+dt+"-"+tm;
                             pPW.println(paData);
                             pPW.flush();
                             pPW.close();
                             JOptionPane.showMessageDialog(null, "The Record of the Passanger has been added successfully");
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
    
    public void modPass(JFrame window)
    {
        JDialog pdelDialog = new JDialog();
        pdelDialog.setContentPane(new JLabel(new ImageIcon("C:/Program Files/Airport Database/air.jpg")));
		pdelDialog.setVisible(true);
		Container c = pdelDialog.getContentPane();
		pdelDialog.setSize(630,250);
        pdelDialog.setTitle("Delete the Data of Passanger");
		pdelDialog.setLocationRelativeTo(window);
		c.setLayout(null);
        
        JLabel dPass=new JLabel("Enter the ID Number of Passanger:");
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
                        BufferedReader dBr=new BufferedReader(new FileReader("C:\\Users\\Public\\Documents\\AirportData\\Files\\PassangerData.txt"));
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
                            JOptionPane.showMessageDialog(null, "Data Relative to ID is not Found");
                            break;
                        }
                    }
        dBr.close();
        FileWriter f=new FileWriter(new File("C:\\Users\\Public\\Documents\\AirportData\\Files\\PassangerData.txt"),false);
        PrintWriter p=new PrintWriter(f);
        p.print(sBu.toString());
        f.flush();
        f.close();
        pdelDialog.setVisible(false);            
                    
                    
                    /*Writing new or modifed data to file */
                    
                    
        JDialog pDialog = new JDialog();
        pDialog.setContentPane(new JLabel(new ImageIcon("C:/Program Files/Airport Database/air.jpg")));
		pDialog.setVisible(true);
		Container c = pDialog.getContentPane();
		pDialog.setSize(765, 730);
        pDialog.setTitle("Add the Data of Passanger");
		pDialog.setLocationRelativeTo(window);
		c.setLayout(null);
        
         JLabel laPaNam=new JLabel("Enter the Name of Passanger:");
         laPaNam.setBounds(180, 210, 180, 25);
         c.add(laPaNam);
         JTextField tPaNam=new JTextField(30);
         tPaNam.setBounds(370, 210, 180, 25);
         c.add(tPaNam);
        
         JLabel laPaId=new JLabel("Enter the ID of Passanger:");
         laPaId.setBounds(180, 250, 160, 25);
         c.add(laPaId);
         JTextField tPaId=new JTextField(30);
         tPaId.setBounds(370, 250, 180, 25);
         c.add(tPaId);
         
         JLabel laPaFl=new JLabel("Enter the Flight Number:");
         laPaFl.setBounds(180, 290, 160, 25);
         c.add(laPaFl);
         JTextField tPaFl=new JTextField(30);
         tPaFl.setBounds(370, 290, 180, 25);
         c.add(tPaFl);
         
         JLabel laPaAi=new JLabel("Enter the Airline:");
         laPaAi.setBounds(180, 330, 160, 25);
         c.add(laPaAi);
         JTextField tPaAi=new JTextField(30);
         tPaAi.setBounds(370, 330, 180, 25);
         c.add(tPaAi);
         
         JLabel laPaDt=new  JLabel("Enter the Date");
         laPaDt.setBounds(180, 370, 160, 25);
         c.add(laPaDt);
         JTextField tPaDt=new JTextField(30);
         tPaDt.setBounds(370, 370, 180, 25);
         c.add(tPaDt);
         
         JLabel laPaTm=new JLabel("Enter the time of Flight");
         laPaTm.setBounds(180, 410, 160, 25);
         c.add(laPaTm);
         JTextField tPaTm=new JTextField(30);
         tPaTm.setBounds(370, 410, 180, 25);
         c.add(tPaTm);
         
         JButton bOK=new JButton("ok");
         bOK.setBounds(370, 450, 50, 25);
         c.add(bOK);
         bOK.setToolTipText("Press OK to Save Data");
         bOK.addActionListener(new ActionListener()
             {
                 public void actionPerformed(ActionEvent ae)
                 {
                     
                     if(tPaNam.getText().isEmpty()||tPaAi.getText().isEmpty()||tPaDt.getText().isEmpty()||tPaFl.getText().isEmpty()||tPaId.getText().isEmpty()||tPaTm.getText().isEmpty())
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
                         String dt=tPaDt.getText();
                         String tm=tPaTm.getText();
                         
                         try
                         {
                            // pFW=new FileWriter(new File("passangerData.txt"));
                             pPW=new PrintWriter(new FileOutputStream("C:\\Users\\Public\\Documents\\AirportData\\Files\\PassangerData.txt",true));
                             String paData=nam+"-"+id+"-"+ai+"-"+fl+"-"+dt+"-"+tm;
                             pPW.println(paData);
                             pPW.flush();
                             pPW.close();
                             JOptionPane.showMessageDialog(null, "The Record of the Passanger has been added successfully");
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
    } //end of modPass()
    
    public void chkPass(JFrame window)
    {
        
       JDialog pCDialog = new JDialog();
       pCDialog.setContentPane(new JLabel(new ImageIcon("C:/Program Files/Airport Database/air.jpg")));
		pCDialog.setVisible(true);
		Container pc = pCDialog.getContentPane();
		pCDialog.setSize(630,250);
        pCDialog.setTitle("Check the Data of Passanger");
		pCDialog.setLocationRelativeTo(window);
		pc.setLayout(null);
        JLabel pcEmp=new JLabel("Enter the ID Number of Passanger:");
        pcEmp.setBounds(70, 70, 200, 25);
        pc.add(pcEmp);
        JTextField pcTPas=new JTextField(30);
        pcTPas.setBounds(290, 70, 200, 25);
        pc.add(pcTPas);
        JButton ok=new JButton("ok");
        ok.setBounds(290, 100,50, 25);
        pc.add(ok);
        ok.setToolTipText("Press ok to Check the record of Passanger");
        ok.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
                String id=pcTPas.getText();
                try
                {
                    buR=new BufferedReader(new FileReader("C:\\Users\\Public\\Documents\\AirportData\\Files\\PassangerData.txt"));
                    String l="";
                    //int i=0;
                    //int j=0;
                    
                   while((l=buR.readLine())!=null)
                    { 
                        
                        String pArr[]=l.split("-");
                        //String a[i]=pArr[1];
                        //i=i+1;
                        //System.out.println(l);
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
                            
                            JLabel pNam=new JLabel("Name of Passanger:");
                            pNam.setBounds(80, 80, 180, 25);
                            c.add(pNam);
                            JLabel pONam=new JLabel(pArr[0]);
                            pONam.setBounds(200, 80, 180, 25);
                            c.add(pONam);
                            
                            JLabel pID=new JLabel("ID of Passanger:");
                            pID.setBounds(80, 120, 180, 25);
                            c.add(pID);
                            JLabel pOID=new JLabel(pArr[1]);
                            pOID.setBounds(200, 120, 180, 25);
                            c.add(pOID);
                            
                            JLabel pDep=new JLabel("Airline:");
                            pDep.setBounds(80, 160, 180, 25);
                            c.add(pDep);
                            JLabel pODep=new JLabel(pArr[2]);
                            pODep.setBounds(200, 160, 180, 25);
                            c.add(pODep);
                            
                            JLabel pDOJ=new JLabel("Flight Number:");
                            pDOJ.setBounds(80, 200, 180, 25);
                            c.add(pDOJ);
                            JLabel pODOJ=new JLabel(pArr[3]);
                            pODOJ.setBounds(200, 200, 180, 25);
                            c.add(pODOJ);
                            
                            JLabel pHoW=new JLabel("Date:");
                            pHoW.setBounds(80, 240, 180, 25);
                            c.add(pHoW);
                            JLabel pOHoW=new JLabel(pArr[4]);
                            pOHoW.setBounds(200, 240, 180, 25);
                            c.add(pOHoW);
                            
                            JLabel pSal=new JLabel("Time:");
                            pSal.setBounds(80, 280, 180, 25);
                            c.add(pSal);
                            JLabel pOSal=new JLabel(pArr[5]);
                            pOSal.setBounds(200, 280, 180, 25);
                            c.add(pOSal);
                            
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
                        
                    }
                   
                  /* while(j<=i)
                   {
                       
                       if(a[j].equals(id))
                       {
                           break;
                       }
                       else if(j==i && (a[j].equals(id)==false))
                       {
                           System.out.println("not found");
                       }
                       else{
                           
                       }
                       j=j+1;
                   } */
                   
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
    
    public void delPass(JFrame window)
    {
        JDialog pdelDialog = new JDialog();
		pdelDialog.setVisible(true);
        pdelDialog.setContentPane(new JLabel(new ImageIcon("C:/Program Files/Airport Database/air.jpg")));
		Container c = pdelDialog.getContentPane();
		pdelDialog.setSize(630,250);
        pdelDialog.setTitle("Delete the Data of Passanger");
		pdelDialog.setLocationRelativeTo(window);
		c.setLayout(null);
        
        JLabel dPass=new JLabel("Enter the ID Number of Passanger:");
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
                        BufferedReader dBr=new BufferedReader(new FileReader("C:\\Users\\Public\\Documents\\AirportData\\Files\\PassangerData.txt"));
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
                    FileWriter f=new FileWriter(new File("C:\\Users\\Public\\Documents\\AirportData\\Files\\PassangerData.txt"),false);
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