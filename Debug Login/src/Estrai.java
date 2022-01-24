import java.io.*;
import java.util.Scanner;


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
    
    public String[] getFromFile(String file, int l) throws IOException  {
    	Scanner scanner = new Scanner(new File(file)); //creo uno scanner per il file 
        String [] a = new String [100]; //inizializzo l'array
        int i = 0; //contatore
        while(scanner.hasNextLine()) //finché c'è qualcosa
        {
             a[i++] = scanner.nextLine();  //l'array tall di posizione i è uguale alla riga i+1
        }
        return a; //passo l'array come valore output 
  }
}


