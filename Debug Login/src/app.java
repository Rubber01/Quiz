import java.io.IOException;
import java.util.Scanner;

public class app {
	registration registrator = new registration();
 	Estrai es=new Estrai();String[] arrayFile = new String[es.getLenghtFile(registrator.getPasswordNameFile())];
    Valid validator= new Valid();
	Scanner scan = new Scanner(System.in);
	public void start() throws Eccezioni, IOException{ 
		String choose = "";
		do {
		choose = "";
		System.out.println("Select the language to use\nItalian(Italiano)\nEnglish\n*do not rate us badly, we are programmers not experts in languages*");
		choose=scan.nextLine();
		if(choose.equals("Italiano")||choose.equals("Italian")||choose.equals("italiano")||choose.equals("italian"))
			menuIta(1);
		else if(choose.equals("English") || choose.equals("english"))
			menuEng(1);
		else
			System.out.println("very interesting as a language but I don't know it");
	
		}while(!choose.equals("Italiano")||!choose.equals("Italian")||!choose.equals("italiano")||!choose.equals("italian")||!choose.equals("English") || !choose.equals("english"));
	}
	 public void menuEng(int s)  throws Eccezioni, IOException 
	    {
	    	String choose = "";
	    	while(!choose.equals("Exit")) {
	    	System.out.println("Welcome!");
	    	
	    	if(s!=-1)
	    	{
		    	System.out.println("You look like you're new");
		    	System.out.println("Do you want me to explain how the program works?");
		    	choose=scan.nextLine();
		    	if(choose.equals("si")||choose.equals("yes")||choose.equals("sure"))
		    	{
		    		System.out.println("Very simply this ministerial application \nserves to create and take quizzes \nthrough a login you can enter as a professor or student \n teachers can: \ncreate quizzes \ncorrect quizzes \nmake new quizzes \nsee the ratings they had given to previous quizzes \nstudents can \ntake quizzes \nview the results of old quizzes \nrepeat old quizzes");
		    	}else
		    	System.out.println("ah... fine -_-");
		    	//if 2
		    	System.out.println("ah... fine -_-");
		    	System.out.println("Btw, Are you already registered?");
		    }else
		    System.out.println("Are you registered?");
	    	choose=scan.nextLine();
		    if(choose.equals("si")||choose.equals("yes")||choose.equals("sure"))
		    	login();		
	    	else
	    		registration();
	    	}
	    }
    public void menuIta(int s)  throws Eccezioni, IOException 
    {
    	String choose = "";
    	do{
    	System.out.println("Benvenuto!");
    	
    	if(s!=-1)
    	{
	    	System.out.println("Hai l'aria di essere nuovo");
	    	System.out.println("Vuoi che ti spieghi come funziona il programma?");
	    	choose=scan.nextLine();
	    	if(choose.equals("si")||choose.equals("yes")||choose.equals("sure"))
	    	{
	    		System.out.println("Molto semplicemente questa applicazione ministeriale\nserve per creare e fare quiz\nattraverso un login si può entrare come professore o studente\ni docenti possono:\ncreare quiz\ncorreggere i quiz\nfare nuovi quiz\nvedere le valutazioni che avevano dato agli scorsi quiz\ngli studenti possono\nfare quiz\nvedere i risultati dei vecchi quiz\nrifare i vecchi quiz");
	    	}else
	    	System.out.println("ah... ok -_-");
	    	//if 2
	    	System.out.println("Btw, sei già registrato?");
	    }else
	    System.out.println("sei già registrato?");
    	choose=scan.nextLine();
	    if(choose.equals("si")||choose.equals("yes")||choose.equals("sure"))
	    login();		
    	else
    	{
    		registration();
    	}
	   }while(!choose.equals(""));
    }
    public void login()  throws Eccezioni, IOException
    {
    	registrator.enterCredentials();
    	if(validator.checkFile(registrator.getUsersNameFile())==true &&
    	validator.checkFile(registrator.getUsersNameFile())==true) {
    		String[] arrayUsers = new String[es.getLenghtFile(registrator.getUsersNameFile())];
        	arrayUsers=es.getFromFile(registrator.getUsersNameFile(),es.getLenghtFile(registrator.getPasswordNameFile()));
        	String[] arrayPassword = new String[es.getLenghtFile(registrator.getPasswordNameFile())];
        	arrayPassword=es.getFromFile(registrator.getPasswordNameFile(),es.getLenghtFile(registrator.getPasswordNameFile()));
        	if(validator.checkCredentials(registrator.getUsers(), registrator.getPassword())==true)
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
