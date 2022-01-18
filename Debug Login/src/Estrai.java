import java.io.*;

public class Estrai 
{
    public void Estrai () 
    {
        
    }
    public void printFile(String file) {
        //String file = "C:\\Users\\Utente\\Desktop\\okbot.txt"; 
        
        
        BufferedReader reader = null;
        String line = "";
        
        try 
        {
            reader = new BufferedReader(new FileReader(file));
            while ((line = reader.readLine()) != null) 
                    {
                       String [] row = line.split("\n");
                       int i=0;
                       for(String index : row) 
                       {
                           System.out.printf(index);
                           i++;
                       }
                    }
        }
        catch (Exception e) 
        {
            e.printStackTrace();
        }
    }
    public int getLenghtFile(String file) {
    	int l=0;
    	BufferedReader reader = null;
    	String line = "";
    	try {
			reader = new BufferedReader(new FileReader(file));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	try {
			while ((line = reader.readLine()) != null) l++;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return l;
    }
    public String[] getFromFile(String file, int l) {
        //String file = "C:\\Users\\Utente\\Desktop\\okbot.txt"; 
        
    	String[] arrayFile = new String[l];

        BufferedReader reader = null;
        String line = "";
        
        try 
        {
            reader = new BufferedReader(new FileReader(file));
            while ((line = reader.readLine()) != null) 
                    {
                       String [] row = line.split("\n");
                       int i=0;
                       for(String index : row) 
                       {
                           arrayFile[i]=index;
                           i++;
                       }
                    }
        }
        catch (Exception e) 
        {
            e.printStackTrace();
        }
		return arrayFile;
       
    }

}
