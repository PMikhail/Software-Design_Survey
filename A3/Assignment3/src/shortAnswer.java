import java.io.InputStreamReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.util.Scanner;

public class shortAnswer extends Essay {

	private static final long serialVersionUID = 5505880322030630817L;
	protected int limit;
	public shortAnswer(){
		super();
	}

	public void create() {
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
		System.out.println("Enter word limit");
		try {
			limit=Integer.parseInt(br.readLine());
		} 
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			create();
		}
		System.out.println("Enter number of responses you want for this question");
		try {
			noofinputs=Integer.parseInt(br.readLine());

		} 
		catch (Exception e) {
			// TODO Auto-generated catch block
			create();
		}
	}

	public void modify(){
		System.out.println(this.prompt);
		System.out.println("Do you wish to modify the prompt?");

		BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
		try {
			String res = br1.readLine();
			if(res.toLowerCase().equals("yes"))
				super.editPrompt();

			System.out.println("Do you want to change word limit");
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


			res = br.readLine();
			if(res.toLowerCase().equals("yes"))
			{ 
				Scanner in = new Scanner(System.in);
				int nlimit = in.nextInt();
				this.limit=nlimit;
			}
		} 
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			modify();
		}
	}

	public void Display(outPut output) {
		output.displaystring(this.prompt+" Limit: "+limit);
	}

	public Car take() {
		System.out.println("Enter "+noofinputs+" answers");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Car res=new VectorCar();
		try {

			for(int n=0;n<noofinputs;n++){
				res.setResponse(br.readLine());
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			take();
		}
		return res;
	}
}
