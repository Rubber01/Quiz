

import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.io.FileWriter;

public class registration{
	Scanner sc= new Scanner(System.in);
	File filePassword = new File("password.txt");
	File fileUsers = new File("Users.txt");
	private String fileNamePassword = "password.txt";
	private String fileNameUsers= "Users.txt";
	FileWriter writerPassword = null;
	FileWriter writerUsers = null;
	Boolean canBeDeletedPassword = filePassword.canWrite();
	Boolean canBeDeletedUsers = fileUsers.canWrite();
	String name="";
	String password="";
public registration(){
		try {
			writerPassword = new FileWriter(filePassword,true);
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			writerUsers = new FileWriter(fileUsers,true);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
//METODI GETTER E SETTER.
public void setPasswordNameFile(String fileNamePassword){
	this.fileNamePassword=fileNamePassword;
}
public void setUsersNameFile(String fileNameUsers){		
	this.fileNameUsers=fileNameUsers;		
}
public String getPasswordNameFile(){
	return fileNamePassword;
}
public String getUsersNameFile(){		
	return fileNameUsers;
}
public String getUsers(){		
	return name;
}
public String getPassword(){		
	return password;
}
//METODO PER VERIFICARE L'ESISTENZA DEI FILE. 
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
	
		
	System.out.println("got the input!");
	this.name=name;
	this.password=password;
}
public void saveCredentials() throws Eccezioni{
	try {
		writerUsers.write(name+'\n');
	} catch (IOException e1) {
		e1.printStackTrace();
	}	
	try {
		writerUsers.close();
	} catch (IOException e1) {
		e1.printStackTrace();
	}
	try {
		writerPassword.write(password + '\n');
	} catch (IOException e) {
		e.printStackTrace();
	}
	try {
		writerPassword.close();
	} catch (IOException e) {
		e.printStackTrace();
	}	
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
