import java.util.Scanner; //importa lo scanner per l'inserimento da tastiera
import java.io.File; //importa la libreria per l'utilizzo dei file e di tutti i metodi legati ai file
import java.io.IOException; //importa la libreria per l'implemento delle eccezioni
import java.io.FileWriter;// libreria per l'utilizzo del filewriter (scrivere all'interno di un file)

public class Registration {
		Estrai es = new Estrai();
		Scanner sc= new Scanner(System.in); 				//crezione dell'oggetto scanner
		File fileCredential = new File("Credential.txt"); 	//creazione di un oggetto file
		private String fileNameCredential= "Credential.txt";//nome del file
		
		FileWriter writerPassword; 	//variabile di tipo FileWriter per scrivere la password nel file fileCredential
		FileWriter writerUsers; 	//variabile di tipo FileWriter per scrivere il nome dell'utente nel file fileCredential
		FileWriter writerRole; 		//variabile di tipo FileWriter per scrivere il ruolo dell'utente nel file fileCredential
		
		Boolean canBeDeletedCredential = fileCredential.canWrite(); //  
		/*
		 *assegnazione della variabile boleana canBeDeleteCredentia al metodo canWrite 
		 *della libreria java.io.File per verficare se si può scrivere all'interno del file "fileCredential" 
		 */
		
		String name=""; 	//inizializzazione della stringa che rappresenterà il contenitore del nome dell'utente
		String password="";	//inizializzazione della stringa che rappresenterà il contenitore la password dell'utente
		String role="";		//inizializzazione della stringa che rappresenterà il contenitore del ruolo dell'utente
		
		
	public Registration(){
		
			//creazione degli oggetti per scrivere il ruolo la password e il nome utente nel file "fileCredential"
			try {
				writerRole = new FileWriter(fileCredential,true); 	//in quale file scrivere, true per l'append 
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				writerPassword = new FileWriter(fileCredential,true);
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				writerUsers = new FileWriter(fileCredential,true);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	
	//METODI GETTER E SETTER.
	public void setCredentialNameFile(String fileNameCredential){
		this.fileNameCredential=fileNameCredential;
	}
	public String getCredentialNameFile(String fileNameCredential){		
		return fileNameCredential;			
	}

	public void setUsers(String name){		
		this.name=name;
	}
	public void setPassword(String password){		
		this.password=password;
	}
	public void setRole(String role){
		this.role=role;
	}
	public String getUsers(){		
		return name;
	}
	public String getPassword(){		
		return password;
	}
	public String getRole(){
		return role;
	}
	public File getFile() {
		return fileCredential;
	}
	public String getNameFile() {
		return "Credential.txt";
	}

	
	/**
	 * metodo per verificare l'esistenza dei file 
	 * @param fileVerify
	 * @return
	 * @throws IOException
	 */
	public boolean fileVerify(File fileVerify) throws IOException {
		if(fileVerify.exists()) { // se esiste
			if (fileVerify.canWrite()) { // e se ci si può scrivere all'interno
				return true; 
			}else
				return false;
		} else {
			fileVerify.createNewFile(); //altrimenti crea un nuovo file
				if (fileVerify.canWrite()) {
					return true;
				}else 
					return false;
			}
		}	
	
	/**
	 * metodo per l'inserimento delle credenziali 
	 * @param fileTextPassword
	 * @param lingua
	 * @throws Eccezioni
	 */
	public void enterCredentials(String fileTextPassword, int lingua) throws Eccezioni{
		int textValue=23; //
		String[][] text = es.LangText(fileTextPassword);
		String name="";
		System.out.println(text[lingua][textValue]); //"Enter the username: "
		try{
			name = sc.nextLine(); 	
			if(name.isEmpty())
			throw new Eccezioni();
		}catch(Eccezioni  e) {	
			System.out.println(text[lingua][textValue+1]); //"you cannot use this name"
			System.exit(0);
		}
		
		String password="";
		System.out.println(text[lingua][textValue+2]); //"Enter your password: "
		try{
			password = sc.nextLine();
			if(password.isEmpty())
				throw new Eccezioni();
			}catch(Eccezioni  e) {
				System.out.println(text[lingua][textValue+3]); //"you cannot use this password"
				System.exit(0);
			}
		
		String role="";
		System.out.println(text[lingua][textValue+4]); //"Enter your role are you a Student or a Teacher: "
		try{
			role = sc.nextLine();
			if(role.isEmpty())
				throw new Eccezioni();
			}catch(Eccezioni  e) {
				System.out.println(text[lingua][textValue+7]);;//"you cannot use this password"
				System.exit(0);
			}
		System.out.println(text[lingua][textValue+5]); //"got the input!"
		
		this.name=name; //aggiornamento del nome dell'utente
		this.password=password;//aggiornamento della password dell'utente
		this.role=role;//aggiornamento del ruolo dell'utente
	}
	
	/**
	 * metodo per il salvataggio delle credenziali sul file
	 * @param fileTextPassword
	 * @param lingua
	 * @throws Eccezioni
	 */
	public void saveCredentials(String fileTextPassword, int lingua) throws Eccezioni{
		int textValue=29;
		String[][] text = es.LangText(fileTextPassword);
		
		//salvataggio nome
		try {
			writerUsers.write(name+";");
		} catch (IOException e1) {
			e1.printStackTrace();
		}	
		try {
			writerUsers.close();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		//salvataggio della password
		try {
			writerPassword.write(password +";");
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			writerPassword.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		//salvataggio del ruolo
		try {
			writerRole.write(role +"\n");
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			writerRole.close();
		} catch (IOException e) {
			e.printStackTrace();
		}	
		System.out.println(text[lingua][textValue]); //"Account saved successfully!"
		}
	}