import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Scanner;
import java.io.File;


public class mainClass {
	public static Survey cSurvey=null;
	public static String s;
	public static questionfactory objectfact=new questionfactory();
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void surveyMenu() {

		System.out.println("1) Create a new Survey \n2) Display a Survey \n3) Load a Survey \n4) Save a Survey \n5) Modify an Existing Survey  \n6) Take a Survey  \n7) Tabulate a Survey \n8)  Quit");

		try {
			s=br.readLine();

			int input=Integer.parseInt(s);


			if(input>0 && input<9)
			{
				switch(input)
				{
					case 1:
						cSurvey=new Survey();
						cSurvey.createSurvey();
						try { 
							questionMenu(cSurvey,"Survey");
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						break;
					case 2:cSurvey.setDisplayMethod();
							 surveyMenu();
							 break;
					case 3:
							 String car=getfile("Surveys");
							 cSurvey=new Survey();
							 cSurvey=cSurvey.loadSurvey(car);
							 cSurvey.display();
							 surveyMenu();
							 break;

					case 4:try {
								 cSurvey.savetofile();
								 surveyMenu();
							 } catch (Exception e) {

								 e.printStackTrace();
								 surveyMenu();
							 }
							 break;

					case 5:modify("Survey");
							 surveyMenu();
							 break;
					case 6:String nof=getfile("Surveys");
							 cSurvey=new Survey();
							 cSurvey=cSurvey.loadSurvey(nof);
							 cSurvey.take();
							 surveyMenu();
							 break;
					case 7:cSurvey=new Survey();
							 String name12345=getfile("Surveys");
							 cSurvey=cSurvey.loadSurvey(name12345);
							 cSurvey.tabulate();
							 surveyMenu();
							 break;

					case 8:System.exit(0);
							 break;
					default:surveyMenu();
				}}
			else{
				System.out.println("wrong input");
				surveyMenu();
			}
		} 
		catch(NullPointerException e)
		{
			System.out.println("invalid input load file first");
			e.printStackTrace();
			surveyMenu();
		}catch (Exception e) {
			System.out.println("wrong input");
			e.printStackTrace();
			surveyMenu();
		}

	}

	public static String getfile(String type){
		File folder = new File("./"+type);
		File[] listOfFiles = folder.listFiles();

		for (int n = 0; n < listOfFiles.length; n++) {
			if (listOfFiles[n].isFile()) {
				System.out.println(n+":" + listOfFiles[n].getName());
			} else if (listOfFiles[n].isDirectory()) {
				System.out.println("Directory " + listOfFiles[n].getName());
			}
		}

		System.out.println("enter file you want to load");
		try {
			s=br.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block

			e.printStackTrace();
			return type;

		}
		int input=Integer.parseInt(s);

		return listOfFiles[input].getName();
	}

	public static void testMenu() {
		System.out.println("1) Create a new Test \n2) Display a Test \n3) Load a Test \n4) Save a Test \n5) Modify an Existing Test  \n6) Take a Test  \n7) Tabulate a Test \n8) Grade a Test \n9) Quit");

		try {
			s=br.readLine();

			int input=Integer.parseInt(s);


			if(input<10 && input>0)
			{
				switch(input)
				{
					case 1: cSurvey=new Test();
							((Test)cSurvey).createTest();
								try {
									questionMenu(cSurvey,"Test");
								}
								catch (Exception e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								 break;
					case 2:((Test)cSurvey).setDisplayMethod();
							 testMenu();
							 break;

					case 3: cSurvey=new Test();
							String name=getfile("Tests");
							cSurvey=((Test)cSurvey).loadTest(name);
							((Test)cSurvey).display();
							testMenu();
							break;

					case 4:((Test)cSurvey).savetofile();
							testMenu();
							break;

					case 5:modify("Test");
							testMenu();

					case 6:cSurvey=new Test();
							String name12=getfile("Tests");
							cSurvey=((Test)cSurvey).loadTest(name12);
							((Test)cSurvey).take();
							testMenu();
							break;

					case 7:cSurvey=new Test();
							String name1234=getfile("Tests");
							cSurvey=((Test)cSurvey).loadTest(name1234);
							((Test)cSurvey).tabulate();
							testMenu();
							break;

					case 8:cSurvey=new Test();
							String name123=getfile("Tests");
							cSurvey=((Test)cSurvey).loadTest(name123);
							int[] grades=((Test) cSurvey).grade();
							System.out.println("\n Grade is:  "+(grades[0]*10)+"/"+(grades[1]*10));
							testMenu();
							break;

					case 9:System.exit(0);
							break;

					default:testMenu();
				}
			}
			else{
				System.out.println("wrong input");
				testMenu();
			}

		}
		catch(NullPointerException e)
		{
			System.out.println("invalid input load file first");
			e.printStackTrace();
			testMenu();
		}
		catch (Exception e1) {
			System.out.println("wrong input");
			e1.printStackTrace();
			testMenu();
		}
	}

	public static void Take(String type) {
		System.out.println("Enter name of "+ type +"you wish to take");
		try {
			if(type=="Survey"){
				cSurvey=new Survey();
				BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
				String name=br1.readLine();


				cSurvey=cSurvey.loadSurvey(name);


			}
			else if (type=="Test"){
				cSurvey=new Test();

				BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
				String name=br1.readLine();

				try {
					cSurvey=cSurvey.loadSurvey(name);

				} catch (ClassNotFoundException e) {
					System.out.println("Test not found");
					Take(type);
				}
			}
			cSurvey.take();

		} catch (Exception e) {
			System.out.println("Survey not found");
			Take(type);
		}
	}

	public static void questionMenu(Survey a,String type) {

		System.out.println("1) Add a new T/F question \n2) Add a new multiple choice question \n3) Add a new short answer question \n4) Add a new essay question \n5) Add a new ranking question \n6) Add a new Matching choice question\n7)back ");

		try {
			s=br.readLine();

			int input=Integer.parseInt(s);


			if(input<8 && input>0)

			{ if(input==1)
				{	a.addQuestion(objectfact.makeTf());
					questionMenu(a,type);
				}
				else if(input==2)
				{	a.addQuestion(objectfact.createMultiChoice());
					questionMenu(a,type);
				}
				else if(input==3)
				{a.addQuestion(objectfact.makeshortAns());
					questionMenu(a,type);
				}
				else if(input==4)
				{	a.addQuestion(objectfact.makeEssay());
					questionMenu(a,type);
				}
				else if(input==6)
				{	a.addQuestion(objectfact.makeMatching());
					questionMenu(a,type);
				}
				else if(input==5)
				{	a.addQuestion(objectfact.makeRanking());
					questionMenu(a,type);
				}
				else if(input==7)
				{	if(type.equals("Survey"))
					surveyMenu();
					else if(type.equals("Test"))
						testMenu();
				}
			}
			else{
				System.out.println("wrong input");
				questionMenu(a,type);

			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			questionMenu(a,type);
		}
	}

	public static void modify(String type) throws IOException{
		System.out.println("What "+ type +" do you wish to modify ");
		if(type=="Survey"){
			cSurvey=new Survey();
			BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
			String name=br1.readLine();

			try {
				cSurvey=cSurvey.loadSurvey(name);
				cSurvey.display();
			} catch (ClassNotFoundException e) {
				System.out.println("Survey not found");
				modify(type);
			}
		}
		else if (type=="Test"){
			cSurvey=new Test();

			BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
			String name=br1.readLine();

			try {
				cSurvey=cSurvey.loadSurvey(name);
				cSurvey.display();
			} catch (ClassNotFoundException e) {
				System.out.println("Test not found");
				modify(type);
			}
		}

		System.out.println("Enter question number  you wish to modify ");

		Scanner in = new Scanner(System.in);
		int num = in.nextInt();
		num-=1;
		cSurvey.editQuestion(num);


	}

	public static void main(String args[]){

		System.out.println("Enter choice: "+"\n"+ "1)Survey\n2)Test");

		String s = null;
		try {
			s = br.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("invlid input");

		}
		int input=0;
		try{
			input=Integer.parseInt(s);
			if(input < 3 && input > 0)
			{
				if(input==1)
					surveyMenu();
				else
					testMenu();
			}
			else
			{ System.out.println("invlid input");
				main(args);
			}
		}
		catch(Exception e){
			e.printStackTrace();
			System.out.println("error");
			main(args);

		}
	}
}
