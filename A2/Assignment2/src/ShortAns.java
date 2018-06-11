import java.util.Scanner;
import java.util.Vector;

public class ShortAns extends Questions{
	
	protected int limit;
	public ShortAns(){

	}
	@Override
	public void createquestion() {
		System.out.println("Enter prompt");
		Scanner b = new Scanner(System.in);
		prompt = b.nextLine();
		System.out.println("Enter word limit");
		limit= b.nextInt();
	}
	@Override
	public void display() {
		System.out.println(prompt);
		System.out.println("word limit"+limit);
	}
}
