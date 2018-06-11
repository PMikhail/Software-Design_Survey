import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Essay extends Question {

	private static final long serialVersionUID = 4319531515389317447L;
	int noofinputs;
	public Essay(){
		super();

	}
	@Override
	public void Display(outPut output) {
		output.displaystring(this.prompt);

	}

	@Override
	public void create() {
		System.out.println("Enter Prompt here");

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			super.prompt = br.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("wrong type");
			this.create();
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

	public Car take() {
		System.out.println("Enter give "+noofinputs+" answers");
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

	public void modify(){
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
			e.printStackTrace();
		}

	}
}
