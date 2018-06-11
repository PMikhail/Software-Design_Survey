import java.io.IOException;
import java.io.BufferedReader;
import java.util.Scanner;
import java.util.Vector;
import java.io.InputStreamReader;


public class Matching extends Question{

	private static final long serialVersionUID = -3573042656035694206L;

	protected Vector<String> left=new Vector<String>();
	protected Vector<String> right=new Vector<String>();

	@Override
	public void Display(outPut output) {
		output.displaystring(this.prompt);
		char upper = (char) ('A');
		for(int n=0;n<left.size();n++)
		{  
			upper=(char)(upper+n);
			output.displaystring(" " +(upper)+":"+left.elementAt(n)+" "+(n+1)+":"+right.elementAt(n));
		}
	}

	@Override
	public void create(){

		System.out.println("Enter Prompt here");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			super.prompt = br.readLine();
		} 
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("wrong type");
				this.create();
		}
		this.setChoices();
	}


	public void setChoices() {
		System.out.println("Enter number of choices on both list");
		BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
		String nofchoice = null;
		try {
			nofchoice = br1.readLine();



			int no=Integer.parseInt(nofchoice);
			System.out.println("enter left list elements");
			String choice=null;

			for(int n=0;n<no;n++){
				choice=br1.readLine();
				left.add(choice);
			}
			System.out.println("Enter right list of elements");
			for(int n=0;n<no;n++){
				choice=br1.readLine();
				right.add(choice);
			}
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			this.setChoices();
		}
	}


	@Override
	public void modify() {
		System.out.println(this.prompt);
		System.out.println("Do you wish to modify the prompt?");

		BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));

		String res;
		try {
			res = br1.readLine();
			if(res.toLowerCase().equals("yes"))
				super.editPrompt();
		} 
		catch (IOException e) {
			// TODO Auto-generated catch block
			modify();
		}
		for(int n=0;n<left.size();n++)
		{  
			System.out.println(" " +(n+1)+":"+left.elementAt(n)+" "+(n+1)+":"+right.elementAt(n));
		}
		System.out.println("Do you wish to modify left of right list of choices?");
		try {
			res = br1.readLine();
			if(res.toLowerCase().equals("left")){
				System.out.println("Enter the no of element you want to change and press enter and enter new element for list");
				Scanner in = new Scanner(System.in);
				int change = in.nextInt();
				String nelement=br1.readLine();
				left.set(change-1, nelement);
			}

			if(res.toLowerCase().equals("right")){
				System.out.println("Enter the no of element you want to change and press enter and enter new element for list");
				Scanner in = new Scanner(System.in);
				int change = in.nextInt();
				String nelement=br1.readLine();
				right.set(change-1, nelement);
			}

		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public Car take() {
		System.out.println("Enter your answer and press enter after each line ");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Car response=new VectorCar();
		String temp=null;
		try {
			for(int n=0;n<left.size();n++){
				temp=br.readLine();
				response.setResponse(temp);
			}

		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			take();
		}
		return response;
	}
}
