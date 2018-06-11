import java.util.Vector;
import java.io.Serializable;

public class StringCar extends Car implements Serializable{

	private static final long serialVersionUID = -9216065873317057869L;
	public String Response;

	public StringCar(){
		super();
	}
	public StringCar(String a){
		Response=a;
	}
	public String getsResponse(){
		return Response;
	}
	public void editResponse(int temp,String a){
		Response=a;
	}
	public void setResponse(String a){
		Response=a;
	}
	public boolean isCorrect(Car corr){
		if(this.Response.equals(corr.getsResponse()))
			return true;
		else 
			return false;
	}
	@Override
	public void Display(){
		System.out.println("    "+Response);
	}
	@Override
	public void save() {
		// TODO Auto-generated method stub
	}
	@Override
	public void Display(outPut output) {
		output.displaystring(Response);
	}
	@Override
	public Vector<String> getResponse() {
		// TODO Auto-generated method stub
		return null;
	}

}
