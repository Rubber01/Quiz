import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Scanner;
/**
 * 
 * @version v.1.2
 * @author Pietro Biasotti, Matthias Stocchi
 * 
 */
public class Valid {
	private String nome;
	private String pw;
	Estrai es=new Estrai();
	Registration Registrazione = new Registration();
	MenuRole menu=new MenuRole();
	public Valid() {
		
	}
	/**
	 * 
	 * @return nome (Nome utente)
	 */
	public String getNome() {
		return nome;
	}
	/**
	 * 
	 * @param nome (Nome utente)
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
	/**
	 * 
	 * @return pw (Password utente)
	 */
	public String getPw() {
		return pw;
	}
	/**
	 * 
	 * @param pw (Password utente)
	 */
	public void setPw(String pw) {
		this.pw = pw;
	}
	/**
	 * 
	 * @param FileName
	 * @return true/false vero o falso in base all'esistenza o meno del file
	 */
	public boolean checkFile(String FileName) {
		File file = new File(FileName);
		if(file.exists()) {
			return true;
		} else {
		
			return false;
		}
	}	
	/**
	 * 
	 * @param nome
	 * @param pw
	 * @link collegamento ai menù docenti e studenti
	 * @throws IOException
	 * @throws Eccezioni 
	 * @throws ArrayIndexOutOfBoundsException 
	 */
	public void checkCredentials(String nome, String pw, String ruolo,int lingua) throws IOException, ArrayIndexOutOfBoundsException, Eccezioni {
	     String[][] matrice=es.splitUser("Credential.txt");   
	    if (nome == null || pw == null  || nome.isEmpty() || pw.isEmpty()) {
	        return;
	    }
	    System.out.println("nome "+ nome + " password " +pw + " ruolo "+ ruolo);
	    System.out.println(es.getLenghtFile(Registrazione.getNameFile()));
	    System.out.println(Registrazione.getNameFile());
	    for(int i=0; i<es.getLenghtFile(Registrazione.getNameFile()); i++) {
	    	
	    	 System.out.println("Confronto la matrice 0"+ i +" di valore "+ matrice[0][i]+ " con il nome " +nome);
	    	 if(matrice[0][i].equals(nome)) {
		    	 System.out.println("Confronto la matrice 1"+ i +" di valore "+ matrice[1][i]+ " con la password " +pw);
		    	 if(matrice[1][i].equals(pw)) {
			    	 System.out.println("Confronto la matrice 2"+ i +" di valore "+ matrice[2][i]+ " con il ruolo " +ruolo);
		    		 if(matrice[2][i].equals(ruolo)) {
		    			 if(ruolo.equals("Studente")||ruolo.equals("studente"))
		    			 {
		    				menu.menuStudente(lingua);
		    				return;
		    			 }
		    				if(ruolo.equals("Docente")||ruolo.equals("docente"))
		    				{
		    					menu.menuDocente(lingua);
		    					return;
		    				}
		    				 
		    		 }
		    			 
		    	 }
	    	 }
	    }
		System.out.println("Stronzo hai sbagliato...Coglione controlla di nuovo, magari sarai più fortunato");
	    	//for(int k=0; k<es.getLenghtFile(Registrazione.getNameFile()); k++)
	    	
	    
	    
	    
	    for(int i=0; i<es.getLenghtFile(Registrazione.getNameFile()); i++) {
	    	//for(int k=0; k<es.getLenghtFile(Registrazione.getNameFile()); k++) {
	    	if(matrice[0][i]==nome)
	    		if(matrice[1][i]==pw)
	    			if(matrice[2][i]==ruolo)
	    			{
	    				if(ruolo=="Studente"||ruolo=="studente")
	    					System.out.println("Benvenuto , hai fatto l'accesso come Docente");
	    				if(ruolo=="Docente"||ruolo=="docente")
	    					System.out.println("Benvenuto , hai fatto l'accesso come Docente");
	    			}
	    	}
	    //}
	}

}
