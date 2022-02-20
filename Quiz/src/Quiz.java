/**
 * importazione delle varie librerie
 */
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
/**
 * 
 * @author Pietro Biasotti, Matthias Stocchi, Aimen Essaidi
 *
 */
public class Quiz 
{	
	File filePunti = new File("Quiz.txt");
	Scanner scan = new Scanner(System.in);	
	Estrai es =new Estrai();
	Registration reg = new Registration();
	int punti;
	FileWriter writerPunti;
	int l;
	String quizNameFile="Quiz.txt";
	String[][] matrice= new String[es.getLenghtFile(quizNameFile)][6];
	String scoreNameFile="Score.txt";
	
	public Quiz() 
	{
		/**
		 * writer per scrivere i punti sul file Punti + try e catch
		 */
		try {
			writerPunti= new FileWriter(filePunti,true); 
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public String getScoreName() {
		return scoreNameFile;
	}
	
	/**
	 * metodo che estrae da un file i quiz in matrici
	 * @param file
	 */
	public void estraiQuiz(String file)
	{
		BufferedReader reader;
		String line = "";
		
	    try 
	    {	
	        reader = new BufferedReader(new FileReader(file));
	        int k=0;
	        
	        /**
	         * ciclo per estrarre dal file dove sono presenti i le domande risposte ecc. dei quiz
	         */
	        while ((line = reader.readLine()) != null) 
	        {
	        	String[] parts = line.split(";");
	        	    		
	        	   matrice[k][0] = parts[0]; 	//domanda 
	        	   matrice[k][1] = parts[1];  	//opzione1
	               matrice[k][2] = parts[2]; 	//opzione2
	               matrice[k][3] = parts[3];	//opzione3	
	               matrice[k][4] = parts[4];	//opzione4
	               matrice[k][5] = parts[5];	//risposta giusta
	        	k++;
	        	
	        }
	        
       	}catch (IOException e) 
    	{
       		e.printStackTrace();
    	}
		
	}
				/**
				 * metodo che fa iniziare il quiz 
				 */
	public void playQuiz() 
	        	{
	               int k=0;
	               /**
	                * stampa su schermo la domanda e le varie opzioni
	                */
	               System.out.print("Domanda " + k+1 + ": " + matrice[k][0] + "?\n");//domanda
	        	   System.out.print("A) " + matrice[k][1] + "\n");//opzione 1
	        	   System.out.print("B) " + matrice[k][2]+ "\n");//opzione 2
	        	   System.out.print("C) " + matrice[k][3] + "\n");//opzione 3
	        	   System.out.print("D) " + matrice[k][4] + "\n");//opzione 4
	            	
	        	   /**
	        	    * scrittura con lo scanner la risposta dell'utente
	        	    */
	        	  String rispostaUtente = scan.nextLine();
	            	   
	        	   k++;
	        	   System.out.println("-----------------------------");
	            	   
	        	   /**
	        	    * controllo della risposta dell'utente
	        	    */
	        	   if(rispostaUtente.equals(matrice[k][5]))/*risposta giusta*/ 
	        	   {
	        		   System.out.println(""); //hai indovinato
	        		    punti = punti + 1;//incremento del punto se la risposta dell'utente è giusta
	        	   }else if(!rispostaUtente.equals(matrice[k][5])) 
	        	   		{
	        			   System.out.println(); //risposta sbagliata
	            		}
	        	   SaveScore(scoreNameFile);
}
	public void viewQuiz() {
		int k=0;
        /**
         * stampa su schermo la domanda e le varie opzioni
         */
        System.out.print("Domanda " + k+1 + ": " + matrice[k][0] + "?\n");//domanda
 	   System.out.print("A) " + matrice[k][1] + "\n");//opzione 1
 	   System.out.print("B) " + matrice[k][2]+ "\n");//opzione 2
 	   System.out.print("C) " + matrice[k][3] + "\n");//opzione 3
 	   System.out.print("D) " + matrice[k][4] + "\n");//opzione 4
 	   System.out.print("Risposta corretta) " + matrice[k][5] + "\n");
 	   System.out.print("Risposta corretta) " + matrice[k][5] + "\n");
	}
	public void WriteQuiz(){
		l++;
		String[][] matrice=new String[l][6];
		System.out.println("inserisci la domanda ");
		String r=scan.nextLine();
		
		matrice[l][0]=r;
		System.out.println("inserisci la prima opzione");
		r=scan.nextLine();
		matrice[l][1]=r;
		System.out.println("inserisci la seconda opzione");
		r=scan.nextLine();
		matrice[l][2]=r;
		System.out.println("inserisci la terza opzione");
		r=scan.nextLine();
		matrice[l][3]=r;
		System.out.println("inserisci la quarta opzione");
		r=scan.nextLine();
		matrice[l][4]=r;
		System.out.println("inserisci la risposta corretta tra le 4 precedenti");
		r=scan.nextLine();
		matrice[l][5]=r;
		SaveQuiz(quizNameFile, matrice);
	}
	/**
	 * 
	 * @see metodo per il salvataggio su un file dello score del determinato utente
	 * @param file
	 * @param matrice
	 */
	public void SaveQuiz(String file,String[][] matrice) 
	{
		for(int k=0; k < l; k++) {
			
	        try {
	        	writerPunti = new FileWriter(matrice[k][0]+";");//salvataggio in formato (nome utente) 
	        	//domanda
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        try {
	        	writerPunti = new FileWriter(matrice[k][1]+";");
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        try {
	        	writerPunti = new FileWriter(matrice[k][2]+";");
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        try {
	        	writerPunti = new FileWriter(matrice[k][3]+";");
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        try {
	        	writerPunti = new FileWriter(matrice[k][4]+";");
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        try {
	        	writerPunti = new FileWriter(matrice[k][5]+"\n");
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        try {
	        	writerPunti.close();
	        } catch (IOException e1) {
	            e1.printStackTrace();
	        }
		}
    }
	/**
	 * 
	 * @param file
	 */
	public void SaveScore(String file) {
		try {
        	writerPunti = new FileWriter(punti+";"); //punteggio;Utente\n
        	//domanda
        } catch (IOException e) {
            e.printStackTrace();
        }
		try {
        	writerPunti = new FileWriter(reg.getUsers()+"\n");
        	//domanda
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	/**
	 * 
	 * @param file
	 */
	public void printScore(String file) {
		String[][] Matrix=es.LangText(file);
		for(int i=0; i<es.getLenghtFile(file); i++)
			for(int k=0; k<es.getLenghtFile(file); k++)
				System.out.println(Matrix[i][k]);
	}
}