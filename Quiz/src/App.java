import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class App {
	Registration registrator = new Registration();
 	Estrai es=new Estrai();
 	private String fileText = "Text.txt";
    Valid validator= new Valid();
    int lt=es.getLenghtFile(fileText);
    int lingua=-1;
	Scanner scan = new Scanner(System.in);
	/**
	 * 
	 * @throws Eccezioni
	 * @throws IOException
	 */
	public void start() throws Eccezioni, IOException{
		String[][] text = es.LangText(fileText);
		int textValue=0;
		int lingua=0;
		String choose = "";
		do {
		choose = "";
		System.out.println(text[0][0]); //stringa 0
		System.out.println(text[0][1]);
		System.out.println(text[0][2]);
		choose=scan.nextLine();
		if(choose.equals("Italiano")||choose.equals("Italian")||choose.equals("italiano")||choose.equals("italian"))
			menu(1);
		else if(choose.equals("English") || choose.equals("english"))
			menu(0);
		else
			System.out.println(text[lingua][textValue+3]); //Stringa 4
	
		}while(!choose.equals("Italiano")||!choose.equals("Italian")||!choose.equals("italiano")||!choose.equals("italian")||!choose.equals("English") || !choose.equals("english"));
	}
	 /**
	  * 
	  * @param lingua
	  * @throws Eccezioni
	  * @throws IOException
	  */
    public void menu(int lingua)  throws Eccezioni, IOException 
    {
    	int textValue=4;
    	this.lingua=lingua;
    	String[][] text = es.LangText(fileText);
    	String choose = "";
    	do{
    	System.out.println(text[lingua][textValue]); //50
    	
	    	System.out.println(text[lingua][textValue+1]); //51
	    	System.out.println(text[lingua][textValue+2]); //52
	    	choose=scan.nextLine();
	    	if(choose.equals("si")||choose.equals("yes")||choose.equals("sure"))
	    	{
	    		int i=19; 
	    		for(textValue=textValue+3; textValue<i; textValue++) //
	    			System.out.println(text[lingua][textValue]);
	    		System.out.println(text[lingua][textValue+1]);
	    	}else {
	    	System.out.println(text[lingua][textValue+15]);
	    	System.out.println(text[lingua][textValue+16]);
	    	}
	    	//if 2
    	choose=scan.nextLine();
	    if(choose.equals("si")||choose.equals("yes")||choose.equals("sure"))
	    login();		
    	else if(choose.equals("no"))
    	{
    		registration();
    	}
    	else
    		System.out.println("Error input");
	    System.exit(0);
	   }while(!choose.equals(""));
    }
    /**
     * 
     * @throws Eccezioni
     * @throws IOException
     */
    public void login()  throws Eccezioni, IOException
    {
    	String[][] text = es.LangText(fileText);
    	int textValue=31;
    	registrator.enterCredentials(fileText, lingua);
    	//System.out.println(validator.checkFile(registrator.getNameFile()));
    	if(validator.checkFile(registrator.getNameFile())==true) {
    		validator.checkCredentials(registrator.getUsers(), registrator.getPassword(), registrator.getRole(), lingua);
    	}else
    	System.out.println(text[lingua][textValue+1]);//ERROR 404, IMPOSSIBILE APRIRE I FILE/UNABLE TO OPEN FILES
    }
    /**
     * 
     * @throws Eccezioni
     * @throws IOException
     */
    public void registration()  throws Eccezioni, IOException
    {
    	registrator.enterCredentials(fileText, lingua);
    	registrator.saveCredentials(fileText, lingua);
    }


}
