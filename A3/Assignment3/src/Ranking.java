import java.io.IOException;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ranking extends Matching{

	private static final long serialVersionUID = -3182187514179010875L;

	public Ranking(){
		super();
		right=null;
	}

	public void setChoices(){
		System.out.println("Enter number of list");
		BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
		String nofchoice;
		try {
			nofchoice = br1.readLine();
			try{
				int no=Integer.parseInt(nofchoice);
				System.out.println("enter list elements");
				String choice=null;

				for(int n=0;n<no;n++){
					choice=br1.readLine();
					left.add(choice);
				}

			}
			catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				this.setChoices();
			}
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			this.setChoices();
		}
	}

	public void Display(outPut output) {

		output.displaystring(this.prompt);

		for(int n=0;n<left.size();n++)
		{  
			output.displaystring(" "+(n+1)+":"+left.elementAt(n));
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
			System.out.println("    " +(n+1)+":"+left.elementAt(n));
		}
		System.out.println("Do you wish to modify  list of choices?");
		try {
			res = br1.readLine();
			if(res.toLowerCase().equals("yes")){
				System.out.println("Enter the no of element you want to change and press enter and enter new element for list");
				Scanner in = new Scanner(System.in);
				int num = in.nextInt();
				String nelement=br1.readLine();
				left.set(num-1, nelement);
			}

		} 
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
