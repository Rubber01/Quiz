import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class app {
	registration registrator = new registration();
 	Estrai es=new Estrai();
 	private String fileTextPassword = "Text.txt";
    Valid validator= new Valid();
    int lt=es.getLenghtFile(fileTextPassword);
    
    
    
	Scanner scan = new Scanner(System.in);
	public void start() throws Eccezioni, IOException{
		String[] text = es.getFromFile(fileTextPassword,lt);
		int textValue=0;
		String choose = "";
		do {
		choose = "";
		System.out.println(text[textValue]); //stringa 0
		choose=scan.nextLine();
		if(choose.equals("Italiano")||choose.equals("Italian")||choose.equals("italiano")||choose.equals("italian"))
			menuIta(1);
		else if(choose.equals("English") || choose.equals("english"))
			menuEng(1);
		else
			System.out.println(text[textValue+3]); //Stringa 4
	
		}while(!choose.equals("Italiano")||!choose.equals("Italian")||!choose.equals("italiano")||!choose.equals("italian")||!choose.equals("English") || !choose.equals("english"));
	}
	 public void menuEng(int s)  throws Eccezioni, IOException 
	    {
		 	String[] text = es.getFromFile(fileTextPassword,lt);
		 	int textValue=2;
	    	String choose = "";
	    	while(!choose.equals("Exit")) {
	    	System.out.println(text[textValue]); //riga 1
	    	
	    	if(s!=-1)
	    	{
		    	System.out.println(text[textValue+2]);//riga 2
		    	System.out.println(text[textValue+3]);//riga 3
		    	System.out.println(text[textValue+4]);//riga 4
		    	choose=scan.nextLine();
		    	if(choose.equals("si")||choose.equals("yes")||choose.equals("sure"))
		    	{
		    		int i=19;
		    		for(textValue=textValue+5; textValue<i; textValue++) //
		    		System.out.println(text[textValue]);
		    	}else
		    	System.out.println(text[textValue+17]); //19
		    	//if 2
		    	System.out.println(text[textValue+18]); //20 Btw, Are you already registered?
		    }else
		    System.out.println(text[textValue+2]); //20 
	    	choose=scan.nextLine();
		    if(choose.equals("si")||choose.equals("yes")||choose.equals("sure"))
		    	login();		
	    	else
	    		registration();
	    	}
	    }
    public void menuIta(int s)  throws Eccezioni, IOException 
    {
    	int textValue=50;
		String[] text = es.getFromFile(fileTextPassword,lt);
    	String choose = "";
    	do{
    	System.out.println(text[textValue]); //50
    	
    	if(s!=-1)
    	{
	    	System.out.println(text[textValue+1]); //51
	    	System.out.println(text[textValue+2]); //52
	    	choose=scan.nextLine();
	    	if(choose.equals("si")||choose.equals("yes")||choose.equals("sure"))
	    	{
	    		int i=64; //uno stack XD
	    		for(textValue=textValue+3; textValue<i; textValue++) //
	    		System.out.println(text[textValue]);
	    		System.out.println(text[textValue+1]);
	    	}else {
	    	System.out.println(text[textValue+16]);
	    	System.out.println(text[textValue+15]);
	    	}
	    	//if 2
	    	
    	}else
    	choose=scan.nextLine();
    	choose=scan.nextLine();
	    if(choose.equals("si")||choose.equals("yes")||choose.equals("sure"))
	    login();		
    	else if(choose.equals("no"))
    	{
    		registration();
    	}
    	else
    		es.splitUser(fileTextPassword);
	   }while(!choose.equals(""));
    }
    public void login()  throws Eccezioni, IOException
    {
    	registrator.enterCredentials();
    	if(validator.checkFile(registrator.getUsersNameFile())==true) {
    		/*
    		String[] arrayUsers = new String[es.getLenghtFile(registrator.getUsersNameFile())];
    		arrayUsers=es.getFromFile(registrator.getUsersNameFile(),es.getLenghtFile(registrator.getPasswordNameFile()));
        	String[] arrayPassword = new String[es.getLenghtFile(registrator.getPasswordNameFile())];
        	arrayPassword=es.getFromFile(registrator.getPasswordNameFile(),es.getLenghtFile(registrator.getPasswordNameFile()));
        	if(validator.checkCredentials(registrator.getUsers(), registrator.getPassword())==true)
        	*/
        	System.out.println("Login riuscito");	
    	}else
    	System.out.println("ERROR 404, IMPOSSIBILE APRIRE I FILE/UNABLE TO OPEN FILES");
    	
    }
    public void registration()  throws Eccezioni, IOException
    {
    	registrator.enterCredentials();
    	registrator.saveCredentials();
    }


}
