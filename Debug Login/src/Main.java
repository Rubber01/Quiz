import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {

	public static void main(String[] args)throws Eccezioni, IOException{
		/*Estrai es=new Estrai();
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
                    	   System.out.println("-----------------------------");*/
                       
                    	/*   
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
        }*/
		app application =new app();
		application.start();
    }
		
        
        /*
        registration registrator = new registration();
        registrator.enterCredentials();
        registrator.saveCredentials();*/
}

	



