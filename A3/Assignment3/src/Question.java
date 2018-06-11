import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public abstract class Question implements java.io.Serializable{

	private static final long serialVersionUID = 2638976008505558019L;
	protected Car Response;
	protected String prompt;

	public void setPrompt(String ques){
		this.prompt=ques;
	}

	public String getPrompt(){
		return this.prompt;
	}

	public void displayPrompt(){
		System.out.println(this.prompt);
	}

	public void editPrompt(){
		System.out.println("Enter a new Prompt");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String pro=this.prompt;
		try {
			pro = br.readLine();
		} 
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("invalid format");
		}

		this.prompt = pro;

	}

	public abstract void Display(outPut output);
	public abstract void create();
	public abstract void modify();
	
	public abstract Car take() ;
	
	/*
	private String questionPrompt = "";
	public void modify(){

		System.out.println("Do you wish to modify the prompt? ");
		Scanner key = new Scanner(System.in);
		String input = key.next();

        if (input == "y"){
        	System.out.println("Enter the prompt for your question:");
        	Scanner keyboard = new Scanner(System.in);
        	this.questionPrompt = keyboard.nextLine();
        }
        else if (input == "n"){
        	getC();
        	modifyChoices();
        }
        else{
        	System.out.println("Invalid Input");
        	modify();
        }
 	}
    public String[] getC() {
        return null;
    }
    public void modifyChoices() {}
	*/
}
