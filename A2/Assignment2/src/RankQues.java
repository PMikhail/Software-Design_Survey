import java.util.Scanner;
import java.util.Vector;

public class RankQues extends Questions{
	
	protected Vector<String> choices ;
	
	public RankQues(){
		choices= new Vector<String>();
	}
	@Override
	public void createquestion(){
		System.out.println("Enter prompt");
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
	public void display() {
		System.out.println(prompt);
		for(int n=0;n<choices.size();n++){
			System.out.println((n+1)+") "+choices.elementAt(n));	
		}	
	}
}
