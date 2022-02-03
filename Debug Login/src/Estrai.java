import java.io.*;
import java.util.Scanner;

/**
 * 
 * @author Pietro Biasotti, Islam Ouarem, Matthias Stocchi
 *
 *
 */
public class Estrai 
{ 
	
    public void Estrai () 
    {
        
    }
    /**
     * 
     * @param file Nome fisico del file da stampare
     */
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
    /**
     * 
     * @param file Nome fisico del file
     * @return l lunghezza file
     */
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
    /**
     * 
     * @param file Nome fisico del file
     * @param l lunghezza file
     * @return a array di stringhe prese dal file riga per riga
     * @throws IOException
     */
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
    /**
     * metodo che serve per dividere gli Utenti dalla Password e dal loro Ruolo (Professore/Studente) visco che la formattazione nel file è Utente;Password;Ruolo... è ancora in fase di sviluppo
     * @param file Nome fisico del file
     * @throws Eccezioni
     * @throws IOException
     * @throws ArrayIndexOutOfBoundsException
     *
     */
    public void splitUser(String file)throws Eccezioni, IOException, ArrayIndexOutOfBoundsException{
    	Estrai es=new Estrai();
		BufferedReader reader;
    	int l=es.getLenghtFile("Users.txt");
		String[] part1= new String[l];
        String[] part2= new String[l];
        String[] part3= new String[l];
        String line = "";

        try {
            reader = new BufferedReader(new FileReader("Users.txt"));
            while ((line = reader.readLine()) != null) 
                    {
                       String[] parts = line.split(";");
                       for (String a : parts)
                       {
                    	   int k=0;
                    	   part1[k] = parts[0]; 
                           part2[k] = parts[1];
                           part3[k] = parts[2];
                           
                    	   /*System.out.println(a);
                    	   System.out.println("-----------------------------");
                       */
                    	   
                       }
                       int k=0;
                       System.out.print("Utente ");
                	   System.out.println(part1[k]);
                	   System.out.print("Password ");
                	   System.out.println(part2[k]);
                	   System.out.print("Ruolo ");
                	   System.out.println(part3[k]);
                	   k++;
                	   System.out.println("-----------------------------");
                       	   

                       }
         
                   
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


