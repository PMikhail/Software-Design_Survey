import java.util.Vector;
import java.io.Serializable;
import java.util.Scanner;

public class MultipleChoice extends Questions
implements Serializable{
	
	protected Vector<String> choices = new Vector<String>();
	public MultipleChoice(){
		
	}
	@Override
	public void createquestion(){
		System.out.println("Enter prompt:");
		Scanner b = new Scanner(System.in);
		prompt = b.nextLine();
		System.out.println("Enter number of choices");
		int num = b.nextInt();
		for(int n=0;n<num;n++){
			Scanner a = new Scanner(System.in);
			System.out.println("Enter choice"+(n+1));
			choices.addElement(a.nextLine());
		}
	}
	@Override
	public void display(){
		System.out.println(prompt);
		for(int n=0;n<choices.size();n++){
			System.out.println((n+1)+") "+choices.elementAt(n));			
		}
	}
}
