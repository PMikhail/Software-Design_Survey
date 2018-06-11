import java.util.Scanner;
import java.util.Vector;

public class Essay extends Questions{
	
	public Essay()
	{
		
	}
	@Override
	public void createquestion(){
		System.out.println("Enter prompt:");
		Scanner s = new Scanner(System.in);
		prompt=s.nextLine();
	}
	@Override
	public void display(){
		System.out.println(prompt);		
	}
}
