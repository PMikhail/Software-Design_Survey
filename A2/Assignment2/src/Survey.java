import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Vector;

public class Survey implements Serializable{
	private static final long serialVersionUID = 1L;
	protected String titleofsurvey;
	protected Vector<Questions> questionlist;

	public Survey(){
	
	}

	public Survey createSurvey(){
		questionlist=new Vector<Questions>();
		System.out.println("Enter name of survey");
		Scanner a = new Scanner(System.in);
		titleofsurvey=a.nextLine();
		Main.questionMenu();
		addQues();
		return this;
	}
	public void addQues()
	{
		try
		{
			Scanner in = new Scanner(System.in);
			int num = in.nextInt();
			Questions q = null;
			switch(num){
				case 1:
					q=new TF();
					q.createquestion();
					break;
			
				case 2:
					q=new MultipleChoice();
					q.createquestion();
					break;
			
				case 3:
					q=new ShortAns();
					q.createquestion();
					break;

				case 4:
					q=new Essay();
					q.createquestion();
					break;

				case 5:
					q=new RankQues();
					q.createquestion();
					break;
		
				case 6:
					q=new Matching();
					q.createquestion();
					break;
			
				case 7:
					return;
			}
			questionlist.addElement(q);
			Main.questionMenu();
			addQues();
		}
		catch(Exception e){
			System.out.println("Error Incorrect Input");
			addQues();
		}	
	}
	public void displaysurvey(){
		System.out.println("Survey "+titleofsurvey);
		for(int n=0;n<questionlist.size();n++){
			System.out.print("Q" + (n+1) + ")");
			questionlist.elementAt(n).display();
		}
	}

	public void saveSurvey() throws IOException {
		File verifyFolder = new File("Surveyfolder/");
		if (!verifyFolder.exists())
		verifyFolder.mkdirs();
		
		File f = new File("Surveyfolder/" + this.titleofsurvey );

		if (!f.exists())
			f.createNewFile();

		FileOutputStream fos = new FileOutputStream(f);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(this);
		
		System.out.println("Success");
		fos.close();
		oos.close();
	}

	public Survey loadsurvey() throws IOException, ClassNotFoundException {
		String type="Surveyfolder";
		File folder = new File("./"+type);
		File[] listOfFiles = folder.listFiles();
		for (int n=0;n<listOfFiles.length;n++){
			if (listOfFiles[n].isFile()) {
				System.out.println(n+":" + listOfFiles[n].getName());
			} 
			else if (listOfFiles[n].isDirectory()){
				System.out.println("Directory " + listOfFiles[n].getName());
			}
		}

		System.out.println("Enter the number of surveys to load");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		int i = Integer.parseInt(s);
		String name=listOfFiles[i].getName();
		FileInputStream fi=null;

		fi = new FileInputStream("Surveyfolder/" + name);
		ObjectInputStream ois = new ObjectInputStream(fi);
	
		Survey currentSurvey = (Survey) ois.readObject();
		ois.close();
		fi.close();
		return currentSurvey;
	}
}
