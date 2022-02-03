import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.io.FileWriter;
/**
 * **IGNORATE I FILE COMMENTANTI DA AIMEN OVVERO EVENTUALI SET E PARTI DI CODICE IMPORTANTI, RICORDO CHE CI STA ANCORA LAVORANDO**
 * @author Pietro Biasotti, Aimen Essaidi
 * 
 */
public class Registration{
	Scanner sc= new Scanner(System.in);
	
	File fileCredential = new File("credenziali.txt");

	//File filePassword = new File("password.txt");
	File fileUsers = new File("Users.txt");
	private String fileNameCredential = "credenziali.txt";
	//private String fileNamePassword = "password.txt";
	String fileNameUsers= "Users.txt";
	FileWriter writerCredential;
	FileWriter writerPassword;
	FileWriter writerUsers;
	Boolean canBeDeletedCredential = fileCredential.canWrite();
	
	//Boolean canBeDeletedPassword = filePassword.canWrite();
	Boolean canBeDeletedUsers = fileUsers.canWrite();
	String role="";
	String name="";
	String password="";
	String status=""; //lo status definisce se l'utente è un insegnate o studente.
	
	public void registration(){
		try {
		writerCredential = new FileWriter(fileCredential,true);
		} catch (IOException e) {
				e.printStackTrace();
			}
		/*try {
				writerPassword = new FileWriter(filePassword,true);
			} catch (IOException e) {
				e.printStackTrace();
			}*/
			try {
				writerUsers = new FileWriter(fileUsers,true);
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
	//METODI GETTER E SETTER.
	/**
	 * 
	 * @param fileNameCredential Percorso file (stringa) 
	 */
	/*public void setCredentialNameFile(String fileNameCredential) {
		this.fileNameCredential=fileNameCredential;
	}*/
	/**
	 * 
	 * @return fileNameCredential Percorso file (stringa) 
	 */
	public String getCredentialNameFile(){
		return fileNameCredential;
	}
	
	/*public void setPasswordNameFile(String fileNamePassword){
		this.fileNamePassword=fileNamePassword;
	}*/
	/**
	 * 
	 * @param fileNameUsers Percorso file (stringa) 
	 */
	public void setUsersNameFile(String fileNameUsers){		
		this.fileNameUsers=fileNameUsers;		
	}
	
	/*
	public String getPasswordNameFile(){
		return fileNamePassword;
	}*/
	/**
	 * 
	 * @return fileNameUsers Percorso file (stringa) 
	 */
	public String getUsersNameFile(){		
		return fileNameUsers;
	}
	/**
	 * 
	 * @return nome Utente
	 */
	public String getUsers(){		
		return name;
	}
	/*public String getPassword(){		
		return password;
	}*/

	/**
	 * 
	 * @return role Ruolo Utente (Studente/Professore)
	 */
	public String getRole(){		
		return role;
	}
	/**
	 * 
	 * @param role Ruolo Utente (Studente/Professore)
	 */
	public void setRole(String role)
	{
		this.role=role;
	}
	
	//METODO PER VERIFICARE L'ESISTENZA DEI FILE. 
	/**
	 * 
	 * @param fileVerify
	 * @return true/false in base alla esistenza del file
	 * @throws IOException
	 */
	public boolean fileVerify(File fileVerify) throws IOException {
		if(fileVerify.exists()) {
			System.out.println("The file related to the password exist!");
			if (fileVerify.canWrite()) {
				return true;
			}else
				return false;
		} else {
			fileVerify.createNewFile();
			System.out.println("The file related to the password dosn't exist! File created!");
				if (fileVerify.canWrite()) {
					return true;
				}else 
					return false;
			}
		}	
	//METODO PER L'INSERIMENTO CREDENZIALI PER LA REGISTRAZIONE.
	/**
	 * 
	 * @throws Eccezioni
	 */
	public void enterCredentials() throws Eccezioni{

	//METTI IN UN ALTRO METODO.
		System.out.println("Enter the username: ");
		String name="";
		try{
			name = sc.nextLine(); 	
			if(name.isEmpty())
			throw new Eccezioni();
		}catch(Eccezioni  e) {	
			System.out.println("you cannot use this name");		
			System.exit(0);
		}
		
	//METTI IN UN ALTRO METODO.
		String password="";
		System.out.println("Enter the password: ");	
		
		try{
			password = sc.nextLine();
			if(password.isEmpty())
				throw new Eccezioni();
			}catch(Eccezioni  e) {
				System.out.println("you cannot use this password");		
				System.exit(0);
			}
		
		String status="";
		System.out.println("Are you a Student or a Teacher?: ");
		
		try{
			status = sc.nextLine();
			if(status.isEmpty())
				throw new Eccezioni();
			}catch(Eccezioni  e) {
				System.out.println("invalid input!");		
				System.exit(0);
			}
		
			
		System.out.println("got the input!");
		this.name=name;
		this.password=password;
		this.status=status;
	}
	/**
	 * 
	 * @throws Eccezioni
	 * @bug Problema salvataggio Login su file
	 */
	public void saveCredentials() throws Eccezioni{
		
		try {
			System.out.println(name+'\n'+password+'\n'+status+'\n');
			writerCredential.write(name+';'+password+';'+status+'\n');
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			writerPassword.close();
		} catch (IOException e) {
			e.printStackTrace();
		}		
		
		
		/*
		try {
			writerUsers.write(name+';');
		} catch (IOException e1) {
			e1.printStackTrace();
		}	
		try {
			writerUsers.close();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		try {
			writerPassword.write(password +';');
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			writerPassword.write(status +';');
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			writerPassword.write('\n');
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			writerPassword.close();
		} catch (IOException e) {
			e.printStackTrace();
		}*/
		System.out.println("Account saved successfully!");
		
	

	}
	//METODO PER CONTROLLARE SE UNA PASSWORD HA I GIUSTI REQUISITI
	/*public void requirementsPassword(String password) {
		
		char controlCharacter;
		boolean verifyCase1;
		boolean verifyCase2;
		boolean verifyCase3;
		int i=0;
		
		if(password.length()<8) {
			System.out.println("The password must be at least 8 characters long!");
			verifyCase1 = true;
		}
				if(password.indexOf("$")==-1 && password.indexOf("&")==-1 && password.indexOf("£")==-1 && password.indexOf("@")==-1 && password.indexOf("?")==-1 && password.indexOf("!")==-1 && password.indexOf("§")==-1 && password.indexOf("+")==-1 && password.indexOf("-")==-1 && password.indexOf("*")==-1 && password.indexOf("/")==-1 && password.indexOf(" ")==-1){
					System.out.println("Enter at least one special character!");
					verifyCase2 = true;
				}			
				
				
				/*for(int i=0; i < password.length(); i++) {
					controlCharacter = password.charAt(i); 
				if (Character.isLowerCase(controlCharacter)) {
						System.out.println("Enter at least one upper character!");
						verifyCase3 = true;
			
				do {
					i++;
					for(int k=0; i < password.length(); i++) {
						controlCharacter = password.charAt(i); 
					if (Character.isLowerCase(controlCharacter)) {
							System.out.println("Enter at least one upper character!");
						
				}while()
			}*/
		}
