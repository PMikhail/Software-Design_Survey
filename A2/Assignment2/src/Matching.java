import java.util.Vector;
import java.util.Scanner;

public class Matching extends RankQues{
	
	protected Vector<String> choicesone;
	
	public Matching(){
		choicesone = new Vector<String>();
	}
	@Override
	public void createquestion(){
		System.out.println("Enter prompt");
		Scanner b = new Scanner(System.in);
		prompt = b.nextLine();
		System.out.println("Enter Number of Choices");	
		int num = b.nextInt();
		for(int n=0; n<num; n++){
			Scanner a = new Scanner(System.in);
			System.out.println("Enter Left Choices "+(n+1));
			choices.addElement(a.nextLine());
		} 
		for (int n=0;n<num;n++){
			Scanner a = new Scanner(System.in);
			System.out.println("Enter Right Choices "+(n+1));
			choicesone.addElement(a.nextLine());
		}
	}	
	@Override
	public void display(){
		System.out.println(prompt);
		for(int n=0;n<choices.size();n++){
			System.out.println((n+1)+") "+choices.elementAt(n)+" "+(n+1)+") "+choicesone.elementAt(n));
		}
	}
}
