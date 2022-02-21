import java.util.Scanner;

public class MenuRole {
	/**
	 * @author Pietro Biasotti, Islam Ouarem
	 * @param lingua
	 */
	public static void menuDocente(int lingua) 
	{
		Estrai es=new Estrai();
	 	String fileText = "Text.txt";
	 	String[][] text = es.LangText(fileText);
		Scanner scan = new Scanner(System.in);
		Quiz quiz=new Quiz();
	 	int textValue=11;
		Registration registrator = new Registration();
		System.out.println(text[lingua][textValue+22]+registrator.getUsers());
		int i=15;
		int k=1;
		for(textValue=11; textValue<i; textValue++) {
			System.out.println(k+") "+text[lingua][textValue]);
			k++;
		}
		quiz.estraiQuiz("Quiz.txt");
		System.out.println(text[lingua][textValue+20]+registrator.getUsers());
		k=scan.nextInt();
		System.out.println(k);
		
		if(k==1) {
			for(int j=0; j<5; j++) {
				quiz.WriteQuiz();

			}
		}
			
		 if(k==2)
			quiz.viewQuiz();
		 if(k==3)
			quiz.WriteQuiz();
		 if(k==4)
			quiz.printScore(quiz.getScoreName());
		 if(k==5)
			return;
		//12 in giù
	
}
	/**
	 * 
	 * @param lingua
	 */
	public static void menuStudente(int lingua) 
	{
		Registration registrator = new Registration();
		Estrai es=new Estrai();
	 	String fileText = "Text.txt";
		Scanner scan = new Scanner(System.in);	
	 	String[][] text = es.LangText(fileText);
	 	int textValue=16;
		System.out.println(text[0][textValue+18]+registrator.getUsers());
		int i=19;
		int k=1;
		for(textValue=15; textValue<i; textValue++)
		{
			System.out.println(k+") "+text[lingua][textValue]);
			k++;
		}
		System.out.println(text[lingua][textValue+20]+registrator.getUsers());
		k=scan.nextInt();
		
		//17 in giù
	}
}
