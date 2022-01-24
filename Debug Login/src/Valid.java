import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Scanner;

public class Valid {
	private String nome;
	private String pw;
	registration Registrazione = new registration();

	public Valid() {
		
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}
	
	public boolean checkFile(String FileName) {
		File file = new File(FileName);
		if(file.exists()) {
			return true;
		} else {
		
			return false;
		}
	}	
	
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