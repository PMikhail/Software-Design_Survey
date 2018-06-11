import java.io.File;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Scanner;
import java.io.InputStreamReader;

public class Main {
	
	protected static Survey cSurvey;

	public static void mainMenu()
	{
		System.out.println("1.Survey");
		System.out.println("2.Test");
		try{
			Scanner in = new Scanner(System.in);
			int num = in.nextInt();
			if(num == 1){
				surveyMenu();
			}
			else
				if(num==2)
					testMenu();
			else{	
				System.out.println("Enter inputs 1 or 2");
				mainMenu();
			}
		}
		catch(Exception e){
			System.out.println("enter correct input");
			mainMenu();
		}
	}

	public static void main(String args[]){
		mainMenu();
	}

	private static void surveyMenu() {
		try{
			System.out.println("1.Create A Survey");
			System.out.println("2.Load a Survey");
			System.out.println("3.Display A survey");
			System.out.println("4.Save a Survey");
			System.out.println("5.Quit");
		
			Scanner in = new Scanner(System.in);
			int num = in.nextInt();
			switch(num)
			{
				case 1:
				cSurvey=new Survey();
				cSurvey=cSurvey.createSurvey();
				surveyMenu();
				break;
		
				case 2:
				cSurvey=new Survey();
				cSurvey = cSurvey.loadsurvey();
				cSurvey.displaysurvey();
				surveyMenu();
				break;

				case 3:
				cSurvey.displaysurvey();
				surveyMenu();
				break;
		
				case 4:
				cSurvey.saveSurvey();
				surveyMenu();
				break;
		
				case 5:
				System.out.println("Successfully Quit the Program");
				System.exit(0);
			}	
		}	
		catch(Exception e){
			System.out.println("enter correct input");
			surveyMenu();
		}
	}

	static void questionMenu(){
		System.out.println("1) Add a new T/F question");
		System.out.println("2) Add a new multiple choice question");
		System.out.println("3) Add a new short answer question");
		System.out.println("4) Add a new essay question");
		System.out.println("5) Add a new ranking question");
		System.out.println("6) Add a new matching question ");
		System.out.println("7) back");	
	}

	private static void testMenu() {
		System.out.println("1.Create A Test");
		System.out.println("2.Load a Test");
		System.out.println("3.Display A Test");
		System.out.println("4.Save a Test");
		System.out.println("5.Quit");
		try{
			Scanner in = new Scanner(System.in);
			int num = in.nextInt();
			switch(num)
			{
				case 1:
				cSurvey=new Test();
				cSurvey=cSurvey.createSurvey();
				testMenu();
				break;
		
				case 2:
				cSurvey = new Test();
				cSurvey = cSurvey.loadsurvey();
				cSurvey.displaysurvey();
				testMenu();
				break;
			
				case 3:
				cSurvey.displaysurvey();
				testMenu();
				break;
	
				case 4:
				cSurvey.saveSurvey();
				testMenu();
				break;
	
				case 5:
				System.out.println("Successfully Quit the Program!!!");
				System.exit(0);
				break;	
			}
		}
		catch(Exception e){
			System.out.println("enter correct input");
			testMenu();
		}
	}
}
