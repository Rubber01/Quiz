import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {

	public static void main(String[] args)throws Eccezioni, IOException {
		BufferedReader reader;
		String[] part1= new String[4];
        String[] part2= new String[4];
        String[] part3= new String[4];
        String line = "";

        try {
            reader = new BufferedReader(new FileReader("Users.txt"));
            while ((line = reader.readLine()) != null) 
                    {
            	int i=0;
                       String[] parts = line.split(";");
                       
                       i++;
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
                       for(int k=0; i<4; i++)
                       {
                    	   System.out.println(part1[k]);
                    	   System.out.println(part2[k]);
                    	   System.out.println(part3[k]);
                    	  
                    	   System.out.println("-----------------------------");

                       }
         
                    }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
		/*app application =new app();
		application.start();*/
        
        /*
        registration registrator = new registration();
        registrator.enterCredentials();
        registrator.saveCredentials();*/
	}

	
	}


