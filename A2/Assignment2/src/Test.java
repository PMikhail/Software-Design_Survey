import java.io.BufferedReader;
import java.io.File;
import java.io.Serializable;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Scanner;
import java.io.ObjectOutputStream;
import java.util.Vector;

public class Test extends Survey
implements Serializable{
	private static final long serialVersionUID = 1L;
	public Vector<String> correctanswer;
	public Test(){
		correctanswer=new Vector<String>();
	}
	public Survey createSurvey(){
		questionlist=new Vector<Questions>();
		System.out.println("Enter name of Test");
		Scanner a = new Scanner(System.in);
		titleofsurvey=a.nextLine();
		Main.questionMenu();
		addQues();
		return this;
	}
	public void addQues(){
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
			
		case 7:return ;
		}
		questionlist.addElement(q);
		if(q.getClass().getName()!="Essay"){
			System.out.println("Enter correct answer");
			Scanner abc = new Scanner(System.in);
			correctanswer.addElement(abc.nextLine());
		}
	
		Main.questionMenu();
		addQues();
	}
	
	public Survey loadsurvey() throws IOException, ClassNotFoundException {
		String type="Testfolder";
		File folder = new File("./"+type);
		File[] listOfFiles = folder.listFiles();
	
		for (int n=0;n<listOfFiles.length;n++) {
			if (listOfFiles[n].isFile()) {
		    	System.out.println(n+":" + listOfFiles[n].getName());
			}
			else if (listOfFiles[n].isDirectory()) {
				System.out.println("Directory " + listOfFiles[n].getName());
			}
		}
	    
		System.out.println("Enter the number of Tests to load");
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String	s=br.readLine();
		int input=Integer.parseInt(s);
		String name=listOfFiles[input].getName();

		FileInputStream fi=null;
		fi = new FileInputStream("Testfolder/" + name);
		ObjectInputStream ois = new ObjectInputStream(fi);
	
		Survey currentSurvey = (Survey) ois.readObject();
		ois.close();
		fi.close();
		return currentSurvey;
	}

	public void displaysurvey()
	{
		System.out.println("Test "+titleofsurvey);
		for(int n=0;n<questionlist.size();n++)
		{
			System.out.print("Q"+(n+1)+")");
			questionlist.elementAt(n).display();
			System.out.println("correct answer is "+correctanswer.elementAt(n));
		}
	}

	public void saveSurvey() throws IOException {
		File verifyFolder = new File("Testfolder/");
		if (!verifyFolder.exists())
			verifyFolder.mkdirs();

		File f = new File("Testfolder/" + this.titleofsurvey );

		if (!f.exists())
			f.createNewFile();


		FileOutputStream fos = new FileOutputStream(f);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(this);

		System.out.println("Success");
		fos.close();
		oos.close();
	}
}
