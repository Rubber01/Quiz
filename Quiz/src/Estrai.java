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
        while(scanner.hasNextLine()) //finch� c'� qualcosa
        {
             a[i++] = scanner.nextLine();  //l'array tall di posizione i � uguale alla riga i+1
        }
        return a; //passo l'array come valore output 
  } 
    /**
     * metodo che serve per dividere gli Utenti dalla Password e dal loro Ruolo (Professore/Studente) visco che la formattazione nel file � Utente;Password;Ruolo... � ancora in fase di sviluppo
     * @param file Nome fisico del file
     * @throws Eccezioni
     * @throws IOException
     * @throws ArrayIndexOutOfBoundsException
     *
     */
    
    public String[][] LangText(String file) {
    	Estrai es=new Estrai();
		BufferedReader reader;
    	int l=es.getLenghtFile(file);
    	String[][] Matrix= new String[2][getLenghtFile(file)];
    	String[] part1= new String[l];
        String[] part2= new String[l];
        try {
            String line = "";
            reader = new BufferedReader(new FileReader(file));
            int k=0;
            while ((line = reader.readLine()) != null) 
                    {
                       String[] parts = line.split(";");
                         
                           Matrix[0][k] = parts[0]; 
                           Matrix[1][k] = parts[1];
                      k++;
                    }
        	} 
        catch (IOException e) {
        	e.printStackTrace();
        }
        /*for(int k=0; k<30; k++) {
        	 System.out.print("inglese ");
             System.out.println(Matrix[0][k]);
             System.out.print("italiano ");
             System.out.println(Matrix[1][k+1]);

             k++;
             System.out.println("-----------------------------");
        }*/
        return Matrix;
    }
    /**
     * 
     * @param file
     * @return Matrix (matrice con all'interno i vari utenti)
     * @throws Eccezioni
     * @throws IOException
     * @throws ArrayIndexOutOfBoundsException
     */
    public String[][] splitUser(String file)throws Eccezioni, IOException, ArrayIndexOutOfBoundsException{
    	Estrai es=new Estrai();
		BufferedReader reader;
    	int l=es.getLenghtFile(file);
    	String[][] Matrix= new String[3][getLenghtFile(file)+1];
        try {
            String line = "";
            reader = new BufferedReader(new FileReader(file));
            int k=0;
            while ((line = reader.readLine()) != null) 
                    {
                       String[] parts = line.split(";");
                         
                           Matrix[0][k] = parts[0]; 
                           Matrix[1][k] = parts[1];
                           Matrix[2][k] = parts[2];
                      k++;
                    }
        	} 
        catch (IOException e) {
        	e.printStackTrace();
        }
        return Matrix;
    }

}


