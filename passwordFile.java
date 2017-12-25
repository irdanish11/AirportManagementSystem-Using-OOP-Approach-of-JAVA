import java.io.BufferedReader;
import java.io.*;
import javax.swing.*;

public class passwordFile{
public String u;
public String p;
public PrintWriter writer=null;
{
	
    //public static String u;
    //public static String p;
        File dir = new File("C:\\Users\\Public\\Documents\\AirportData\\Files\\Protected");
    	File dir1 = new File("C:\\Users\\Public\\Documents\\AirportData\\Images");
        // attempt to create the directory here
        boolean successful = dir.mkdirs();
		boolean dir1_successful = dir1.mkdirs();
        if (successful)
        {
            try
            {
                writer = new PrintWriter("C:\\Users\\Public\\Documents\\AirportData\\Files\\Protected\\Password.txt"); 
                writer.println("admin");
                writer.println("1122");
                u="admin";
                p="38303";
                writer.close();
            }
            catch(FileNotFoundException e)
            {
                JOptionPane.showMessageDialog(null,"File Not Found");
            }
        }      
        else
        {
            File f = new File("C:\\Users\\Public\\Documents\\AirportData\\Files\\Protected\\Password.txt");
            if(f.exists() && !f.isDirectory())
            {
                try
	            {
		            BufferedReader istrm=new BufferedReader(new FileReader("C:\\Users\\Public\\Documents\\AirportData\\Files\\Protected\\Password.txt"));
		            u=istrm.readLine();
		            p=istrm.readLine();
                    istrm.close();
	            }
	            catch(FileNotFoundException e)
	            {
		            JOptionPane.showMessageDialog(null,"File Not Found");
	            }
	            catch(IOException h)
	            {
		            JOptionPane.showMessageDialog(null,"Input Output error During File Reading!");
	            }
                // creating the directory failed
            }
            else
            {
                try
                {
                    writer = new PrintWriter("C:\\Users\\Public\\Documents\\AirportData\\Files\\Protected\\Password.txt"); 
                    writer.println("admin");
                    writer.println("1122");
                    u="admin";
                    p="38303";
                    writer.close();
                }
                catch(FileNotFoundException e)
                {
                    JOptionPane.showMessageDialog(null,"File Not Found");
                }
            }
        }
     
	/*try
	{
		 BufferedReader istrm=new BufferedReader(new FileReader("pass.txt"));
		 u=istrm.readLine();
		 p=istrm.readLine();
	}
	catch(FileNotFoundException e)
	{
		System.out.println("File Not Found");
	}
	catch(IOException f)
	{
		System.out.println("IO");//
	} */
}
}