import java.util.Scanner;

public class TF extends MultipleChoice{
	private static final long serialVersionUID = 1L;
	public TF(){
		
	}
	
	public void createquestion() {
		System.out.println("Enter prompt");
		Scanner b = new Scanner(System.in);
		prompt = b.nextLine();
		choices.addElement("T");
		choices.addElement("F");
	}
}
