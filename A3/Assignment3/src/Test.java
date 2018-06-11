import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.Set;
import java.util.Map.Entry;
import java.util.Scanner;

import javax.swing.text.html.HTMLDocument.Iterator;

public class Test extends Survey{

	private static final long serialVersionUID = -1570645570118871214L;

	protected ArrayList<Car> answers=new ArrayList<Car>();

	public Test(){
		super();
	}

	public void createTest() throws IOException{
		System.out.println("enter name for Test");

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		this.name = br.readLine();
	}

	public void addQuestion(Question abc) throws Exception{
		abc.create();
		this.questions.add(abc);
		answers.add(this.setAnswer(abc));
		System.out.println("saved in answers");

	}

	private Car setAnswer(Question q) throws IOException
	{

		Car answer=null;

		System.out.println("Enter correct answers");

		if (q.getClass().getName().equals("MultiChoice")
				||  q.getClass().getName().equals("shortAnswer")|| q.getClass().getName().equals("Essay") )
		{
			answer=new VectorCar();
			System.out.println("How many answers does this Question have?");
			{
				BufferedReader br = new BufferedReader(new InputStreamReader(
							System.in));
				try
				{
					String temp = br.readLine();
					int noofanswer = Integer.parseInt(temp);
					if (noofanswer < 1)
					{
						System.out.println("enter number greater than 0");
						this.setAnswer(q);
					}
					else
					{
						for (int n = 0; n < noofanswer; n++)
						{
							br = new BufferedReader(new InputStreamReader(
										System.in));
							answer.setResponse(br.readLine());
						}
					}
				} 
				catch (Exception e)
				{
					System.out.println("error");
					this.setAnswer(q);
				}
			}
		}
		else if (q.getClass().getName().equals("Ranking")
				||  q.getClass().getName().equals("Matching") ){

			answer=new VectorCar();
			System.out.println("Enter correct answer use next line press n to stop");
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			while(true)
			{
				String temp = br.readLine();
				if(temp.equals("n"))
					break;
				answer.setResponse(temp);
			}

		}
		else
		{
			answer=new StringCar();
			BufferedReader br = new BufferedReader(new InputStreamReader(
						System.in));
			answer.setResponse(br.readLine());

		}
		return answer;
	}

	public void savetofile() throws Exception
	{

		File verifyFolder = new File("Tests/");
		if (!verifyFolder.exists())
			verifyFolder.mkdirs();

		File createFile = new File("Tests/" + this.name );

		if (!createFile.exists())
			createFile.createNewFile();

		FileOutputStream fileOut = new FileOutputStream(createFile);
		ObjectOutputStream out = new ObjectOutputStream(fileOut);
		out.writeObject(this);

		System.out.println("File saved at Tests/" + this.name );

		fileOut.close();
		out.close();

		out.close();


	}

	public void editQuestion(int qno){
		questions.get(qno).modify();;

		System.out.println("Do you wish to modify the correct answer?");

		BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
		String res=null;
		try {
			res = br1.readLine();

			if(res.toLowerCase().equals("yes")){
				answers.get(qno).Display();
				if(answers.get(qno).getClass().getName().equals("VectorCar")){
					System.out.println("Which answer you want to modify");

					Scanner in = new Scanner(System.in);
					int num = in.nextInt();
					System.out.println("Enter new answer");
					res = br1.readLine();
					answers.get(qno).editResponse(num-1,res);
				}
				if(answers.get(qno).getClass().getName().equals("StringCar")){
					System.out.println("Enter new answer");
					res = br1.readLine();
					answers.get(qno).editResponse(0,res);
				}
			}
		} 
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Test loadTest(String name) throws IOException, ClassNotFoundException
	{

		FileInputStream fi=null;

		fi = new FileInputStream("Tests/" + name);
		ObjectInputStream ois = new ObjectInputStream(fi);

		Test currentSurvey = (Test)ois.readObject();
		ois.close();
		fi.close();
		return currentSurvey;
	}

	public void display()
	{
		output.displaystring(this.name + "\n   ");
		for (int n = 0; n < questions.size(); n++)
		{
			output.displaystring((n + 1) + ":");
			questions.get(n).Display(output);
			output.displaystring("the correct answer is :" );
			answers.get(n).Display(output);
		}
	}

	public int[] grade(){

		System.out.println("enter the response you want to grade");

		int[] score={0,0};
		for(Entry<String, ArrayList<Car>> entry : responses.entrySet())
		{
			System.out.println("  "+entry.getKey());
		}
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String nameofres;
		try {
			nameofres = br.readLine();

			ArrayList<Car> res=responses.get(nameofres);

			for(int k = 0; k < res.size(); k++)
			{
				res.get(k).Display();
			}


			int correct = 0;
			int n;
			int essays = 0;
			for(n = 0; n < answers.size(); n++)
			{
				if(questions.get(n).getClass().getName().equals("Essay"))
				{
					essays++;
				}
				else if(res.get(n).isCorrect(answers.get(n)))
				{
					correct++;
				}
			}

			score[0]=correct;
			score[1]=(n-essays);
		} 
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return score;
	}
}
