import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Scanner;
/**
 * 
 * @version v.1.2
 * @author Pietro Biasotti, Matthias Stocchi
 * @Note Il codice qui non funziona perché non è stata implementata una parte, perché c'è un bug in Registration
 */
public class Valid {
	private String nome;
	private String pw;
	Registration Registrazione = new Registration();
	
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
	 * @return true/false true nel caso le credenziali sono corrette o false nel caso le credenziali non siano corrette
	 * @throws IOException
	 */
	public boolean checkCredentials(String nome, String pw) throws IOException {
	     String usernametxt = Registrazione.getUsersNameFile();
	     

	    if (nome == null || pw == null  || nome.isEmpty() || pw.isEmpty()) {

	        return false;
	    }

	    try ( Reader fileReader = new FileReader(usernametxt);
	          ) {

	        Scanner userScan = new Scanner(fileReader);
	        Scanner passwordScan = new Scanner(passwordReader);

	        while(userScan.hasNext()) {
	             String user = userScan.next();
	            if (!passwordScan.hasNext()) {
	                return false;
	            }
	             String candidatePassword = passwordScan.next();
	            if (!user.equalsIgnoreCase(nome)) {
	                continue;
	            }

	            if (!candidatePassword.equals(pw)) {
	                return false;
	            }

	            return true;
	        }
	    } 
	    return false;
	}
}