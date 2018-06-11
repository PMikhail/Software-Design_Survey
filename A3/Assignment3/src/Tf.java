import java.io.InputStreamReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.util.Map.Entry;

public class Tf extends MultiChoice{

	private static final long serialVersionUID = 521315172932988375L;

	public Tf(){
		super();
	}

	public void modify(){
		System.out.println(this.prompt);
		String pro = null;
		System.out.println("Do you wish to modify the prompt?");
		BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
		try {
			String res = br1.readLine();
			if(res.toLowerCase().equals("yes")){
				System.out.println("Enter a new Prompt");
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


				pro = br.readLine();
				this.prompt = pro;
			} 
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("invalid format");
		}
	}

	public void setChoices(){

		choices.put('T', "")	; 
		choices.put('F', "")	; 
	}

	public Car take() {
		System.out.println("Enter a choice");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			String temp = br.readLine();
			return new StringCar(temp);

		} 
		catch (IOException e) {
			// TODO Auto-generated catch block
			take();
		}
		return Response;
	}

	public void Display(outPut output){
		output.displaystring(this.prompt);

		for(Entry<Character, String> entry : choices.entrySet())
		{  
			output.displaystring("  "+entry.getKey());
		}
	}
}
