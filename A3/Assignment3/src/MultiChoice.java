import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map.Entry;


public class MultiChoice extends Question {

	private static final long serialVersionUID = 7934678887786336331L;
	protected HashMap<Character,String> choices=null;
	int noofinputs=1;

	public MultiChoice(){
		super();
		choices=new HashMap<Character,String>();
	}

	public HashMap<Character,String> getChoices(){
		return choices;
	}

	public MultiChoice(HashMap<Character,String> choice){

		super();
		choices=choice;
	}

	public void setChoices() {
		System.out.println("Enter number of choices");
		BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
		String nofchoice;
		try {
			nofchoice = br1.readLine();

			int no=Integer.parseInt(nofchoice);
			System.out.println("enter choices");
			String choice=null;

			for(int n=0;n<no;n++){
				System.out.println("enter choice"+(n+1));
				choice=br1.readLine();
				char upper = (char) ('A' + n);
				choices.put(upper, choice);
			}
		} 
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("Enter number of responses you want for this question");
		try {
			noofinputs=Integer.parseInt(br1.readLine());

		} 
		catch (Exception e) {
			// TODO Auto-generated catch block
			setChoices();
		}

	}

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

	public void Display(outPut output){
		output.displaystring(this.prompt);

		for(Entry<Character, String> entry : choices.entrySet())
		{
			output.displaystring("    "+entry.getKey() + ") " +entry.getValue()+"    ");
		}
		System.out.println();

	}
	@Override
	public void modify() {
		
		System.out.println(this.prompt);
		System.out.println("Do you wish to modify the prompt?");

		BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
		try {
			String res = br1.readLine();
			if(res.toLowerCase().equals("yes"))
				super.editPrompt();
				System.out.println("Do you wish to modify the Choices?");
				res = br1.readLine();
				if(res.toLowerCase().equals("yes")){
					System.out.println("Which choice you want to modify?");

					for(Entry<Character, String> entry : choices.entrySet())
					{
						System.out.print(entry.getKey() + ") " +entry.getValue()+"    ");
					}

					Character res1 = (Character)br1.readLine().charAt(0);
					if(choices.containsKey(res1)) {
						System.out.println("Enter new value for choice");
						String	 res12 = br1.readLine();
						choices.put(res1,res12);
					}
				}
			} 
		catch (IOException e) {
				modify();
		}
	}
	@Override
	public Car take() {

		System.out.println("Enter give "+noofinputs+" choices");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Car res=new VectorCar();
		try {

			for(int n=0;n<noofinputs;n++){
				res.setResponse(br.readLine());
			}

		} 
		catch (Exception e) {
			// TODO Auto-generated catch block
			take();
		}
		return res;

	}
}
