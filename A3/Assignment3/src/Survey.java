import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Scanner;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.HashMap;


public class Survey implements java.io.Serializable{

	private static final long serialVersionUID = -3080130933191194200L;

	public String name;

	protected ArrayList<Question> questions;
	protected HashMap<String,ArrayList<Car>> responses;

	outPut output=new consoleO();

	public Survey()
	{
		name = null;

		questions = new ArrayList<Question>();
		responses=new HashMap<String,ArrayList<Car>>();

	}

	public void setDisplayMethod(){
		System.out.println("How do you want to display \n 1)Cosole ouput");
		Scanner in = new Scanner(System.in);
		int numinp = in.nextInt();
		if(numinp==1)
			output=new consoleO();
		else
		{
			System.out.println("Invalid Input");
			setDisplayMethod();
		}
		this.display();
	}

	public void editQuestion(int promp){
		questions.get(promp).modify();
	}

	public void display()
	{
		output.displaystring(this.name + "\n   ");

		for (int n = 0; n < questions.size(); n++)
		{
			output.displaystring((n + 1) + ":");
			questions.get(n).Display(output);
		}
	}

	public void createSurvey() throws IOException{
		System.out.println("Enter name for your survey");

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		this.name = br.readLine();
	}

	public void addQuestion(Question abc) throws Exception{
		abc.create();
		System.out.println("Type y to save ");
		BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
		String res=null;
		try {
			res = br1.readLine();
		} 
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if(res.equals("y")){
			this.questions.add(abc);
			savetofile();
			System.out.println("saved");
		}
		else
			return;
	}

	public void savetofile() throws Exception
	{

		File verifyFolder = new File("Surveys/");
		if (!verifyFolder.exists())
			verifyFolder.mkdirs();

		File createFile = new File("Surveys/" + this.name );

		if (!createFile.exists())
			createFile.createNewFile();

		FileOutputStream fileOut = new FileOutputStream(createFile);
		ObjectOutputStream out = new ObjectOutputStream(fileOut);
		out.writeObject(this);

		System.out.println("File saved at surveys/" + this.name );

		fileOut.close();
		out.close();

		out.close();
	}

	public Survey loadSurvey(String name) throws IOException, ClassNotFoundException
	{

		FileInputStream fi=null;

		fi = new FileInputStream("Surveys/" + name);
		ObjectInputStream ois = new ObjectInputStream(fi);

		Survey currentSurvey = (Survey) ois.readObject();
		ois.close();
		fi.close();
		return currentSurvey;
	}

	public void take() {

		System.out.println(this.name + "\n   ");
		System.out.println("Enter your name");
		BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
		String taker = null;
		try {
			taker=br1.readLine();
		}
		catch (IOException e1) {
			take();
			e1.printStackTrace();
		}
		
		ArrayList<Car> respo=new ArrayList<Car>();
		for (int n = 0; n < questions.size(); n++)
		{
			System.out.print((n + 1) + ":");
			questions.get(n).Display(output);

			respo.add(questions.get(n).take());
		}

		responses.put(taker, respo);

		try {
			this.savetofile();
		} 
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void  tabulate()
	{
		ArrayList<HashMap<Car,Integer>> temparrMap = new ArrayList<HashMap<Car,Integer>>();
		for(int n = 0; n < questions.size(); n++)
		{
			HashMap<Car, Integer> temp = new HashMap<Car,Integer>();
			for(Entry<String,ArrayList<Car>> entry :  responses.entrySet())

				if(checkkey(temp,entry.getValue().get(n)))
				{
					temp.put(entry.getValue().get(n), 1);
				}

			temparrMap.add(temp);
		}
		for(int j=0;j<temparrMap.size();j++){
			System.out.println();
			questions.get(j).displayPrompt();
			HashMap<Car,Integer> abc=temparrMap.get(j);
			for(Entry<Car,Integer> entry :  abc.entrySet())
			{  System.out.println(" "+entry.getValue()+")");
				entry.getKey().Display();
			}
		}
	}

	public boolean checkkey(HashMap<Car, Integer> tempHash,Car a)
	{
		for(Entry<Car,Integer> entry :  tempHash.entrySet())
		{  if(entry.getKey().isCorrect(a))
			{ 
				tempHash.replace(entry.getKey(), (entry.getValue()+1));

				return false;
			}
		}
		return true;
	}
	public int[] grade() {
		// TODO Auto-generated method stub
		return null;
	}
}
